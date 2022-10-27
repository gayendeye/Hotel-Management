package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.dto.ReceptionistDTO;
import com.saraya.hotelmanagementndeyegaye.model.Payment;
import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import com.saraya.hotelmanagementndeyegaye.service.ReceptionistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/auth/receptionist")
@CrossOrigin(origins = "*")
public class ReceptionistController {

    private final Logger LOGGER = LoggerFactory.getLogger(ReceptionistController.class);

    private final ReceptionistService service;

    public ReceptionistController(ReceptionistService service) {
        this.service = service;
    }


    @GetMapping
    public List<Receptionist> getAll(){
        LOGGER.info("All of the Receptionist");
        return service.getAll();
    }


    @GetMapping("/{email}")
    public Receptionist getByEmail(@PathVariable String email){
        LOGGER.info("Get the Receptionist by the name");
        return service.getByEmail(email);
    }

    @GetMapping("/{receptionistId}")
    public Optional<Receptionist> getById(@PathVariable int receptionistId){
        LOGGER.info("Get the Receptionist by the id");
        return service.getById(receptionistId);
    }

    @PostMapping
    public Receptionist create(@RequestBody Receptionist receptionist){
        LOGGER.info("CREATING NEW RECEPTIONIST...");
        return service.create(receptionist);
    }

    @PutMapping
    public Receptionist update(@RequestBody Receptionist receptionist){
        LOGGER.info("Update a receptionist...");
        return service.update(receptionist);
    }

    @DeleteMapping("delete/{email}")
    public void deleteByEmail(@PathVariable String email){
        LOGGER.info("Delete Receptionist by tne email....");
        service.deleteByEmail(email);
    }

    @DeleteMapping("/{receptionistId}")
    public void deleteById(@PathVariable int receptionistId){
        LOGGER.info("Delete a Receptionist by ID.....");
        service.deleteById(receptionistId);
    }

}
