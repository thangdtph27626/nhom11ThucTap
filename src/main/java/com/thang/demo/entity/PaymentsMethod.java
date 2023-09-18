package com.thang.demo.entity;

import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.StatusMethod;
import com.thang.demo.infrastructure.constant.StatusPayMents;
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
@Table(name = "payments_method")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsMethod extends PrimaryEntity {

    @Enumerated(EnumType.STRING)
    private StatusMethod method;

    private String description;

    private String vnp_TransactionNo;

    @Column(name = "total_money")
    private BigDecimal totalMoney;

    @Enumerated(EnumType.STRING)
    private StatusPayMents status;

    @ManyToOne
    @JoinColumn(name = "id_employees",referencedColumnName = "id")
    private User employees;

    @ManyToOne
    @JoinColumn(name = "id_bill",referencedColumnName = "id")
    private Bill bill;
}
