package com.thang.demo.repository;

import com.thang.demo.entity.Address;
import com.thang.demo.entity.Product;
import com.thang.demo.request.SanPhamRequest;
import com.thang.demo.response.SanPhamResponseCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * @author thangdt
 */
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = """
            select\s
            pr.id, max(prde.price) AS price_max, min(prde.price) AS price_min, sum(prde.quantity) AS quantity,  pr.name
            from product pr\s
            right join product_detail   prde on pr.id = prde.id_product
            left join category ca on ca.id = prde.id_category
            left join color co on co.id = prde.id_color
            left join form fo on fo.id = prde.id_form
            left join size si on si.id = prde.id_size
            where ( :#{#request.name} IS NULL
                  OR :#{#request.name} LIKE ''
                  OR pr.name LIKE %:#{#request.name}%)
            and ( :#{#request.priceMax} IS NULL
                  OR :#{#request.priceMax} LIKE ''
                  OR prde.price < :#{#request.priceMax})
            and ( :#{#request.priceMin} IS NULL
                  OR :#{#request.priceMin} LIKE ''
                  OR prde.price > :#{#request.priceMin})
            and ( :#{#request.color} IS NULL
                  OR :#{#request.color} LIKE ''
                  OR co.id > :#{#request.color})
           and ( :#{#request.form} IS NULL
                  OR :#{#request.form} LIKE ''
                  OR fo.id > :#{#request.form})
            and ( :#{#request.category} IS NULL
                  OR :#{#request.category} LIKE ''
                  OR ca.id > :#{#request.category})
            and ( :#{#request.size} IS NULL
                  OR :#{#request.size} LIKE ''
                  OR si.id > :#{#request.size})
            group by pr.id, pr.name
                         """
            , countQuery = """
            select\s
            pr.id, max(prde.price) AS price_max, min(prde.price) AS price_min, sum(prde.quantity) AS quantity,  pr.name
            from product pr\s
            right join product_detail   prde on pr.id = prde.id_product
            left join category ca on ca.id = prde.id_category
            left join color co on co.id = prde.id_color
            left join form fo on fo.id = prde.id_form
            left join size si on si.id = prde.id_size
             where ( :#{#request.name} IS NULL
                  OR :#{#request.name} LIKE ''
                  OR pr.name LIKE %:#{#request.name}% ) 
            and ( :#{#request.priceMax} IS NULL
                  OR :#{#request.priceMax} LIKE ''
                  OR prde.price < :#{#request.priceMax})
            and ( :#{#request.priceMin} IS NULL
                  OR :#{#request.priceMin} LIKE ''
                  OR prde.price > :#{#request.priceMin})
            and ( :#{#request.color} IS NULL
                  OR :#{#request.color} LIKE ''
                  OR co.id > :#{#request.color})
           and ( :#{#request.form} IS NULL
                  OR :#{#request.form} LIKE ''
                  OR fo.id > :#{#request.form})
            and ( :#{#request.category} IS NULL
                  OR :#{#request.category} LIKE ''
                  OR ca.id > :#{#request.category})
            and ( :#{#request.size} IS NULL
                  OR :#{#request.size} LIKE ''
                  OR si.id > :#{#request.size})
            group by pr.id, pr.name
                        """
            , nativeQuery = true)
    List<SanPhamResponseCustom> findProduct(SanPhamRequest request);

}
