package com.thang.demo.entity;

import com.thang.demo.entity.base.PrimaryEntity;
import com.thang.demo.infrastructure.constant.Status;
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

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends PrimaryEntity {

    @Column(name = "notify_content")
    private String notifyContent;

    @Column(name = "notify_date")
    private Long notifyDate;

    private String url;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

}
