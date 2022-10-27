package com.saraya.hotelmanagementndeyegaye.repository;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest , Integer> {

    Guest findByCityAndCountry(String city, String country);
}
