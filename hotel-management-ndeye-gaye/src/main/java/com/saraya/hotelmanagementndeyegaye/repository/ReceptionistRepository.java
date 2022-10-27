package com.saraya.hotelmanagementndeyegaye.repository;

import com.saraya.hotelmanagementndeyegaye.model.Payment;
import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist , Integer> {
    Receptionist findByEmail(String email);
}
