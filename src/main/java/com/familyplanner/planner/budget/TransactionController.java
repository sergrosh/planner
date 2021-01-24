package com.familyplanner.planner.budget;

import java.math.BigDecimal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Transaction controller", tags = "transaction")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Get total amount of transactions by member id.
     *
     * @param memberId member identifier
     * @return total amount of transactions by member id
     */
    @CrossOrigin
    @ApiOperation(value = "Get transactions by member id", tags = "member")
    @GetMapping("/getTotalByMemberId/{memberId}")
    public ResponseEntity<BigDecimal> getByMemberId(@PathVariable("memberId") Integer memberId) {
        Transactions transactions = transactionRepository.getAllByMemberId(memberId);
        if (transactions.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(transactions.getTotalAmount());
    }
}
