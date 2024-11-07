package com.group8.vlearning.domain;

import java.util.List;

import com.group8.vlearning.util.constant.VoucherTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voucher_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VoucherTypeEnum typeName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "condition_id")
    private VoucherCondition condition;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Voucher> vouchers;
}