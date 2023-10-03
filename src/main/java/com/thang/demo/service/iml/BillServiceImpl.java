package com.thang.demo.service.iml;

import com.thang.demo.entity.*;
import com.thang.demo.infrastructure.constant.StatusBill;
import com.thang.demo.infrastructure.constant.StatusMethod;
import com.thang.demo.infrastructure.constant.StatusPayMents;
import com.thang.demo.infrastructure.constant.TypeBill;
import com.thang.demo.repository.*;
import com.thang.demo.request.AddBillRequest;
import com.thang.demo.response.CartDetailResponse;
import com.thang.demo.response.CustomBillByUserResponse;
import com.thang.demo.service.BillService;
import com.thang.demo.service.PayMentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author thangdt
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {

    @Autowired
    private BillHistoryRepository billHistoryRepository;

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private VoucherDetailRepository voucherDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private PayMentMethodRepository payMentMethodRepository;

    @Override
    public Bill createBill(String idUser, AddBillRequest request) {
        Optional<User> user = userRepository.findById(idUser);
        Optional<Bill> billCheck = billRepository.findByCode(request.getCode());
        if(!billCheck.isPresent()){
            Bill newBill = Bill.builder()
                    .user(user.get())
                    .typeBill(TypeBill.OFFLINE)
                    .statusBill(StatusBill.TAO_HOA_DON)
                    .code(request.getCode())
                    .itemDiscount(new BigDecimal("0"))
                    .totalMoney(new BigDecimal("0"))
                    .moneyShip(new BigDecimal("0")).build();
            billRepository.save(newBill);
        }
        Optional<Bill>  bill = billRepository.findByCode(request.getCode());
        bill.get().setPhoneNumber(request.getPhoneNumber());
        bill.get().setAddress(request.getAddress());
        bill.get().setUserName(request.getUserName());
        bill.get().setItemDiscount(new BigDecimal(request.getItemDiscount()));
        bill.get().setTotalMoney(new BigDecimal(request.getTotalMoney()));
        bill.get().setMoneyShip(new BigDecimal(request.getMoneyShip()));
        bill.get().setNote(request.getNote());
        Cart cart = cartRepository.findByUser(user.get());
        List<CartDetailResponse> carts = cartDetailRepository.findAllCartByIdUser(idUser);
        carts.forEach(item -> {
            Optional<ProductDetail> productDetail = productDetailRepository.findById(item.getIdProductDetail());
            productDetail.get().setQuantity(productDetail.get().getQuantity() - item.getQuantity());
            productDetailRepository.save(productDetail.get());

            BillDetail billDetail = BillDetail.builder().bill(bill.get()).productDetail(productDetail.get()).price(productDetail.get().getPrice()).quantity(item.getQuantity()).build();
            billDetailRepository.save(billDetail);
        });
        cartDetailRepository.deleteAllByCart(cart);
        BillHistory billHistory = BillHistory.builder().bill(bill.get()).statusBill(StatusBill.TAO_HOA_DON).employees(user.get()).build();
        billHistoryRepository.save(billHistory);
        Optional<Voucher> voucher = voucherRepository.findById(request.getIdVoucher());
        if(voucher.isPresent()){
            voucher.get().setQuantity(voucher.get().getQuantity() - 1);
            voucherRepository.save(voucher.get());
            VoucherDetail voucherDetail = VoucherDetail.builder().beforPrice(voucher.get().getValue()).bill(bill.get()).voucher(voucher.get()).build();
            voucherDetailRepository.save(voucherDetail);
        }

        if(!billCheck.isPresent()){
            PaymentsMethod paymentsMethod = PaymentsMethod.builder().method(StatusMethod.TIEN_MAT).status(StatusPayMents.TRA_SAU).bill(bill.get()).employees(user.get()).totalMoney(new BigDecimal(request.getTotalMoney())).build();
            payMentMethodRepository.save(paymentsMethod);
        }
        return billRepository.save(bill.get());
    }

    @Override
    public List<CustomBillByUserResponse> findAllByUser(String idUser) {
        Optional<User> user = userRepository.findById(idUser);
        List<CustomBillByUserResponse> responses = new ArrayList<>();
        billRepository.findAllByUser(user.get()).forEach(item -> {
            PaymentsMethod paymentsMethod = payMentMethodRepository.findByBill(item);
            List<BillDetail> billDetails = billDetailRepository.findAllByBill(item);
            responses.add(new CustomBillByUserResponse(item, paymentsMethod, billDetails));
        });
        return responses;
    }
}
