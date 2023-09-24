package com.thang.demo.entity;

import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.GenderProductDetail;
import com.thang.demo.infrastructure.constant.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Nguyễn Vinh
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "product_detail")
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail extends PrimaryEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    private GenderProductDetail gender;

    private BigDecimal price;

    private Integer quantity;

    private String maQR;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category",referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product",referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_color",referencedColumnName = "id")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_size",referencedColumnName = "id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_form",referencedColumnName = "id")
    private Form form;

}
