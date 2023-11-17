package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Bill;
import com.thang.demo.entity.PaymentsMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * @author thangdt
 */
public interface PayMentMethodRepository extends JpaRepository<PaymentsMethod, String> {

    PaymentsMethod findByBill(Bill bill);

    @Modifying
    @Query(value = """
                    UPDATE payments_method pa
                    SET pa.status = 'THANH_TOAN'
                    WHERE pa.id_bill = :idBill
                    """, nativeQuery = true)
    void updateAllByIdBill(@Param("idBill") String idBill);
}
