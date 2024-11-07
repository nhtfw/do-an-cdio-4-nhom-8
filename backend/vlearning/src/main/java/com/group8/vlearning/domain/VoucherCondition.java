package com.group8.vlearning.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voucher_condition")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conditionName;

    private String value;

    @OneToMany(mappedBy = "condition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VoucherType> types;
}
