package com.saraya.hotelmanagementndeyegaye.service;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import com.saraya.hotelmanagementndeyegaye.repository.GuestRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuestService {


    private final GuestRepository repo;

    public GuestService(GuestRepository repo) {
        this.repo = repo;
    }


    public List<Guest> getAll(){
        return repo.findAll();
    }

    public Optional<Guest> getById(
            int guestId){
        return repo.findById(guestId);
    }
    public Guest getByCityAndCountry(
            String city , String country){
        return repo.findByCityAndCountry(city , country);
    }

    public Guest create (Guest guest){
        return repo.save(guest);
    }

    public Guest update(Guest guest){
        return repo.save(guest);
    }

    public void deleteByCityAndCountry(
            String city , String country){
        Guest guest = repo.findByCityAndCountry(city, country);
        repo.delete(guest);
    }

    public void deleteById(int guestId){
        repo.deleteById(guestId);
    }

    public Guest findByCityAndCountry(String city , String country){
        return repo.findByCityAndCountry(city, country);
    }
}

