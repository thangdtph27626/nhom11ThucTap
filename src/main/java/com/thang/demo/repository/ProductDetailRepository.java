package com.thang.demo.repository;

import com.thang.demo.entity.*;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.ProductDetailResponse;
import com.thang.demo.response.SanPhamResponseCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {

    @Query(value = """
            select\s
            prde.id,
            prde.quantity,
            prde.gender,
            prde.price,
            pr.name As name_product,
            ca.name As name_category,
            co.name As name_color,
            co.id AS id_color,
            si.id AS id_size,
            fo.name AS name_form,
            si.name AS name_size
            from product_detail prde
            left join product pr on pr.id = prde.id_product
            left join category ca on ca.id = prde.id_category
            left join color co on co.id = prde.id_color
            left join form fo on fo.id = prde.id_form
            left join size si on si.id = prde.id_size
            where pr.id = :product
            
                         """

            , nativeQuery = true)
    List<ProductDetailResponse> findProductDetailByIdProduct(@Param("product") String idPrduct);

    ProductDetail findBySizeAndColorAndProduct(Size size, Color color, Product product);
}
