package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Bill;
import com.thang.demo.entity.BillDetail;
import com.thang.demo.response.BillDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface BillDetailRepository extends JpaRepository<BillDetail, String> {

    List<BillDetail> findAllByBill(Bill bill);

    @Query(value = """
            select bide.id, pr.id as idProduct, bide.quantity, bide.price, pr.name as nameProduct, co.name as nameColor, si.name as nameSize from bill_detail bide
            left join product_detail prde on prde.id =  bide.id_product_detail
            left join product pr on pr.id = prde.id_product
            left join size si on si.id = prde.id_size
            left join color co on co.id = prde.id_color
            where bide.id_bill = :idBill
                         """
            , nativeQuery = true)
    List<BillDetailResponse> findAllByIdBill(@Param("idBill") String idBill);
}
