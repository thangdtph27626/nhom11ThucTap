package com.thang.demo.entity;

import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.Status;
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

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "user_voucher")
@AllArgsConstructor
@NoArgsConstructor
public class UserVoucher extends PrimaryEntity {

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_voucher",referencedColumnName = "id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private User user;

}
