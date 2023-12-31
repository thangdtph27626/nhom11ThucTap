package com.thang.demo.entity;

import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.StatusBill;
import com.thang.demo.infrastructure.constant.TypeBill;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends PrimaryEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "item_discount")
    private BigDecimal itemDiscount;

    @Column(name = "total_money ")
    private BigDecimal totalMoney;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeBill typeBill;

    @Column(name = "note")
    private String note;

    @Column(name = "money_ship ")
    private BigDecimal moneyShip;

    @Enumerated(EnumType.STRING)
    private StatusBill statusBill;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;
}
