package com.familyplanner.planner.budget;

import java.math.BigDecimal;
import java.util.Iterator;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;

@RequiredArgsConstructor(staticName = "of")
public class Transactions implements Streamable<Transaction> {

    private Streamable<Transaction> streamable;

    public BigDecimal getTotalAmount() {
        return streamable.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Iterator<Transaction> iterator() {
        return streamable.iterator();
    }
}
