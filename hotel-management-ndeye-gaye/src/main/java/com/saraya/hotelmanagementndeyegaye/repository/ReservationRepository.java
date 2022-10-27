package com.saraya.hotelmanagementndeyegaye.repository;

import com.saraya.hotelmanagementndeyegaye.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation , Integer> {
    Reservation findByDateInn(String dateInn);
}
