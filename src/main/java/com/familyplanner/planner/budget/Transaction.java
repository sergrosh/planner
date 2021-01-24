package com.familyplanner.planner.budget;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.familyplanner.planner.family.Member;
import com.familyplanner.planner.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction extends BaseEntity {

    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "execution_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate executionDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnoreProperties("transactions")
    private Member member;
}