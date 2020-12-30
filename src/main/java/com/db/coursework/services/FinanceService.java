package com.db.coursework.services;

import com.db.coursework.entities.FinancePayment;
import com.db.coursework.repo.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FinanceService {
    private final PaymentRepository repository;

    @Transactional
    public FinancePayment createPayment(FinancePayment payment) {
        return repository.save(payment);
    }


    @Transactional
    public List<FinancePayment> getClientPayments(String clientToken) {
        return repository.getClientPayments(clientToken);
    }
}
