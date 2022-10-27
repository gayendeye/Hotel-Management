package com.saraya.hotelmanagementndeyegaye.service;

import com.saraya.hotelmanagementndeyegaye.dto.ReceptionistDTO;
import com.saraya.hotelmanagementndeyegaye.model.Payment;
import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import com.saraya.hotelmanagementndeyegaye.repository.ReceptionistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReceptionistService {

    @Autowired
    private ModelMapper mapper;

    private final ReceptionistRepository repo;

    public ReceptionistService(ModelMapper mapper, ReceptionistRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }


    public List<Receptionist> getAll(){
        return repo.findAll();
    }

    public Optional<Receptionist> getById(
            int receptionistId){
        return repo.findById(receptionistId);
    }
    public Receptionist getByEmail(
            String email){
        return repo.findByEmail(email);
    }

    public Receptionist create (Receptionist receptionist){
      return repo.save(receptionist);
    }


    public Receptionist update(Receptionist receptionist){
        return repo.save(receptionist);
    }

    public void deleteByEmail(
            String email){
        Receptionist receptionist = repo.findByEmail(email);
        repo.delete(receptionist);
    }

    public void deleteById(int receptionistId){
        repo.deleteById(receptionistId);
    }

    public Receptionist findByEmail(String email){
        return repo.findByEmail(email);
    }
}
