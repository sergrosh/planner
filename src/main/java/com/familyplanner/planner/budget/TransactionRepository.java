package com.familyplanner.planner.budget;

import org.springframework.data.repository.Repository;

public interface TransactionRepository extends Repository<Transaction, Integer> {
    Transactions getAllByMemberId(Integer memberId);
}
