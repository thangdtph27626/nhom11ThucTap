package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Bill;
import com.thang.demo.entity.User;
import com.thang.demo.request.BillRequest;
import com.thang.demo.request.FindBillDateRequest;
import com.thang.demo.response.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = """
   SELECT
       i.name AS image,
       p.name  AS nameProduct,
       pd.price AS price,
       SUM(bd.quantity) AS sold,
       SUM(bd.price) AS sales
   FROM bill_detail bd
            JOIN bill b on bd.id_bill = b.id
            JOIN product_detail pd on pd.id = bd.id_product_detail
            JOIN product p on pd.id_product = p.id
            JOIN (SELECT id_product_detail, MAX(id) AS max_image_id
                  FROM image
                  GROUP BY id_product_detail) max_images ON pd.id = max_images.id_product_detail
            LEFT JOIN image i ON max_images.max_image_id = i.id
   WHERE bd.id_product_detail IS NOT NULL AND b.status_bill like 'THANH_CONG'
   GROUP BY  i.name, p.name, pd.price
   ORDER BY sold desc
                                      """, nativeQuery = true)
    List<StatisticalBestSellingProductResponse> getAllStatisticalBestSellingProduct();

    @Query(value = """
    SELECT
        created_date AS billDate,
        COUNT(*) AS totalBillDate
    FROM
        bill
    WHERE   (created_date >= :#{#req.startDate} AND created_date <= :#{#req.endDate} )
        AND (status_bill like 'THANH_CONG')
    GROUP BY created_date
    ORDER BY created_date ASC;
                          """, nativeQuery = true)
    List<StatisticalBillDateResponse> getAllStatisticalBillDate(@Param("req") FindBillDateRequest req);

    @Query(value = """
    SELECT
         b.created_date AS billDate,
         SUM(bd.quantity) AS totalProductDate
    FROM
         bill_detail bd
    JOIN bill b on bd.id_bill = b.id
    WHERE   (b.created_date >= :#{#req.startDate} AND b.created_date <= :#{#req.endDate} )
        AND (b.status_bill like 'THANH_CONG')
    GROUP BY b.created_date
    ORDER BY b.created_date ASC;
                          """, nativeQuery = true)
    List<StatisticalProductDateResponse> getAllStatisticalProductDate(@Param("req") FindBillDateRequest req);

    @Query(value = """
            SELECT   
            COUNT(DISTINCT b.id) AS totalBill,
            SUM(b.total_money) AS totalBillAmount,
            SUM(bd.quantity) AS totalProduct
            FROM bill b JOIN bill_detail bd ON b.id = bd.id_bill
            WHERE
            b.created_date >= :startOfMonth AND b.created_date <= :endOfMonth
            AND b.status_bill = 'THANH_CONG';
            
                                         
              """, nativeQuery = true)

    List<StatisticalMonthlyResponse> getAllStatisticalMonthly(@Param("startOfMonth") Long startOfMonth, @Param("endOfMonth") Long endOfMonth);

    @Query(value = """
            SELECT
                COUNT(id) AS totalBillToday,
                SUM(total_money) AS totalBillAmountToday
            FROM
                bill
            WHERE
                created_date >= :currentDate
                AND status_bill like 'THANH_CONG';                       
                          """, nativeQuery = true)
    List<StatisticalDayResponse> getAllStatisticalDay(@Param("currentDate") Long currentDate);


    @Query(value = """
              SELECT
                  status_bill AS statusBill,
                  COUNT(*) AS totalStatusBill
              FROM
                  bill
              GROUP BY
                  status_bill;                   
                              """, nativeQuery = true)
    List<StatisticalStatusBillResponse> getAllStatisticalStatusBill();

}
