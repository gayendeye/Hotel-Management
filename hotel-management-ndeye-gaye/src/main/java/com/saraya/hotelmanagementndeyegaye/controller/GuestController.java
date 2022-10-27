package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.model.Guest;
import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import com.saraya.hotelmanagementndeyegaye.service.GuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
@RequestMapping("/api/test/guest")
@CrossOrigin(origins = "*")
public class GuestController {

    private final Logger LOGGER = LoggerFactory.getLogger(GuestController.class);

    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @GetMapping
    public List<Guest> getAll(){
        LOGGER.info("All of the Guest");
        return service.getAll();
    }


    @GetMapping("/{guestId}")
    public Optional<Guest> getById(@PathVariable int guestId){
        LOGGER.info("Get the Guest by the id");
        return service.getById(guestId);
    }

    @GetMapping("/{city}/{country}")
    public Guest getByCityAndCountry(@PathVariable String city , @PathVariable String country){
        LOGGER.info("Get the Guest by the city and the country");
        return service.getByCityAndCountry(city, country);
    }

    @PostMapping
    public Guest create(@RequestBody Guest guest){
        LOGGER.info("CREATING NEW GUEST...");
        return service.create(guest);
    }

    @PutMapping
    public Guest update(@RequestBody Guest guest){
        LOGGER.info("Update a Guest...");
        return service.update(guest);
    }

    @DeleteMapping("delete/{city}/{country}")
    public void deleteByCityAndCountry(@PathVariable String city , @PathVariable String country){
        LOGGER.info("Delete Guest by tne city and the country....");
        service.deleteByCityAndCountry(city, country);
    }

    @DeleteMapping("/{guestId}")
    public void deleteById(@PathVariable int guestId){
        LOGGER.info("Delete a Guest by ID.....");
        service.deleteById(guestId);
    }

}
