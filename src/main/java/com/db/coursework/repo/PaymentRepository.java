package com.db.coursework.repo;

import com.db.coursework.entities.FinancePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<FinancePayment, Integer> {
    @Query(value = "SELECT * from Payments p where p.sender_id = :clientToken", nativeQuery = true)
    List<FinancePayment> getClientPayments(@Param("clientToken") String clientToken);
}
