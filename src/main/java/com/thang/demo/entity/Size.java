package com.thang.demo.entity;


import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "size")
@AllArgsConstructor
@NoArgsConstructor
public class Size extends PrimaryEntity {

    private Integer name;

    @Enumerated(EnumType.STRING)
    private Status status;


}
