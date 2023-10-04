package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Bill;
import com.thang.demo.entity.User;
import com.thang.demo.request.BillRequest;
import com.thang.demo.response.BillResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
@Repository
public interface BillRepository extends JpaRepository<Bill, String> {

    Optional<Bill> findByCode(String code);

    List<Bill> findAllByUser(User user);

    @Query(value = """
                SELECT  ROW_NUMBER() OVER( ORDER BY bi.created_date DESC ) AS stt, bi.id, bi.code, bi.created_date, bi.user_name AS userName ,   bi.type, bi.status_bill, bi.total_money, bi.item_discount  FROM bill bi
                WHERE  ( :#{#request.startTime} = 0
                         OR bi.created_date >= :#{#request.startTime}  )
                AND ( :#{#request.endTime} = 0
                         OR bi.created_date <= :#{#request.endTime}  )       
                AND ( :#{#request.status} IS NULL
                         OR :#{#request.status} LIKE ''
                         OR bi.status_bill = (:#{#request.status}))
                AND ( :#{#request.key} IS NULL
                         OR :#{#request.key} LIKE ''
                         OR bi.code LIKE %:#{#request.key}% 
                         OR bi.user_name LIKE %:#{#request.key}% 
                         OR bi.phone_number LIKE %:#{#request.key}% )
                AND ( :#{#request.type} IS NULL
                         OR :#{#request.type} LIKE ''
                         OR bi.type = :#{#request.type})
                ORDER BY bi.created_date DESC
                            
                """, nativeQuery = true)
    List<BillResponse> getAll(BillRequest request);
}
