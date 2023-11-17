package com.thang.demo.service.iml;

import com.thang.demo.entity.Bill;
import com.thang.demo.entity.PaymentsMethod;
import com.thang.demo.entity.User;
import com.thang.demo.infrastructure.constant.*;
import com.thang.demo.infrastructure.listener.Config;
import com.thang.demo.repository.BillRepository;
import com.thang.demo.repository.PayMentMethodRepository;
import com.thang.demo.repository.UserRepository;
import com.thang.demo.request.CreatePayMentMethodTransferRequest;
import com.thang.demo.request.PayMentVnpayRequest;
import com.thang.demo.service.PayMentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author thangdt
 */
@Service
public class PayMentServiceImpl implements PayMentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PayMentMethodRepository payMentMethodRepository;

    public String createVnpay(CreatePayMentMethodTransferRequest createPayMentMethodTransferRequest, HttpServletRequest request) throws UnsupportedEncodingException {
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        cld.add(Calendar.MINUTE,15);

        String vnp_ExpireDate = formatter.format(cld.getTime());

        Map<String,String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", VnPayConstant.vnp_Version);
        vnp_Params.put("vnp_Command",VnPayConstant.vnp_Command);
        vnp_Params.put("vnp_TmnCode",VnPayConstant.vnp_TmnCode);
        vnp_Params.put("vnp_Amount",String.valueOf(createPayMentMethodTransferRequest.vnp_Ammount + "00"));
        vnp_Params.put("vnp_BankCode", VnPayConstant.vnp_BankCode);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        vnp_Params.put("vnp_CurrCode",VnPayConstant.vnp_CurrCode);
        vnp_Params.put("vnp_IpAddr", Config.getIpAddress(request));
        vnp_Params.put("vnp_Locale",VnPayConstant.vnp_Locale);
        vnp_Params.put("vnp_OrderInfo",createPayMentMethodTransferRequest.vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType",createPayMentMethodTransferRequest.vnp_OrderType);
        vnp_Params.put("vnp_ReturnUrl", VnPayConstant.vnp_ReturnUrl);
        vnp_Params.put("vnp_TxnRef", String.valueOf(createPayMentMethodTransferRequest.vnp_TxnRef));
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldList = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldList);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        Iterator itr =  fieldList.iterator();
        while (itr.hasNext()){
            String fieldName = (String) itr.next();
            String fieldValue = vnp_Params.get(fieldName);
            if(fieldValue!=null && (fieldValue.length()>0)){
                hashData.append(fieldName);
                hashData.append("=");
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append("=");
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                if(itr.hasNext()){
                    query.append("&");
                    hashData.append("&");
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(VnPayConstant.vnp_HashSecret,hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnPayConstant.vnp_Url + "?" + queryUrl;
        return paymentUrl;
    }

    @Override
    public boolean paymentSuccess(String idEmployees, PayMentVnpayRequest request) {
        Optional<User> account = userRepository.findById(idEmployees);
        if (!account.isPresent()) {

        }
        if(request.getVnp_ResponseCode().equals("00")){
            Bill bill = Bill.builder()
                    .user(account.get())
                    .typeBill(TypeBill.OFFLINE)
                    .statusBill(StatusBill.TAO_HOA_DON)
                    .code(request.vnp_TxnRef)
                    .itemDiscount(new BigDecimal("0"))
                    .totalMoney(new BigDecimal("0"))
                    .moneyShip(new BigDecimal("0")).build();
            billRepository.save(bill);
            PaymentsMethod paymentsMethod = new PaymentsMethod();
            paymentsMethod.setBill(bill);
            paymentsMethod.setDescription(request.getVnp_OrderInfo());
            paymentsMethod.setTotalMoney(new BigDecimal(request.getVnp_Amount()));
            paymentsMethod.setStatus(StatusPayMents.THANH_TOAN);
            paymentsMethod.setMethod(StatusMethod.CHUYEN_KHOAN);
            paymentsMethod.setEmployees(account.get());
            paymentsMethod.setVnp_TransactionNo(request.getVnp_TransactionNo());
            payMentMethodRepository.save(paymentsMethod);
            return true;
        }
        return false;
    }

    @Override
    public PaymentsMethod findByCodeBill(String code) {
        Optional<Bill> bill = billRepository.findById(code);
        return payMentMethodRepository.findByBill(bill.get());
    }

    @Override
    public PaymentsMethod findByBill(String idBill) {
        Optional<Bill> bill = billRepository.findById(idBill);
        return payMentMethodRepository.findByBill(bill.get());
    }
}
