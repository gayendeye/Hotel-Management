package com.saraya.hotelmanagementndeyegaye.repository;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import com.saraya.hotelmanagementndeyegaye.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment , Integer> {
    Payment findByName(String name);
}
