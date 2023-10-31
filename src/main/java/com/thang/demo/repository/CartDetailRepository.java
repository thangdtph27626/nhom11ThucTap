package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Cart;
import com.thang.demo.entity.CartDetail;
import com.thang.demo.entity.ProductDetail;
import com.thang.demo.response.CartDetailResponse;
import com.thang.demo.response.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface CartDetailRepository extends JpaRepository<CartDetail, String> {

    @Query(value = """
            select cade.id, prde.id As id_product_detail, prde.price, pr.name, co.name As name_color, si.name As name_size, prde.quantity As quantity_max, cade.quantity  from cart_detail cade
            left join product_detail prde on prde.id = cade.id_product_detail
            left join product pr on pr.id = prde.id_product
            left join color co on co.id = prde.id_color
            left join size si on si.id = prde.id_size
            left join cart ca on ca.id = cade.id_cart
            left join users us on us.id = ca.id_user
            where us.id = :idUser
                         """

            , nativeQuery = true)
    List<CartDetailResponse> findAllCartByIdUser(@Param("idUser") String idUser);

    Optional<CartDetail> findByProductDetail(ProductDetail productDetail);

    Integer deleteAllByCart(Cart cart);
}
