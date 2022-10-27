package com.saraya.hotelmanagementndeyegaye.service;

import com.saraya.hotelmanagementndeyegaye.dto.ReservationDTO;
import com.saraya.hotelmanagementndeyegaye.model.Reservation;
import com.saraya.hotelmanagementndeyegaye.model.Room;
import com.saraya.hotelmanagementndeyegaye.repository.ReservationRepository;
import com.saraya.hotelmanagementndeyegaye.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ModelMapper mapper;

    private final RoomRepository roomRepository;

    private final ReservationRepository repo;

    public ReservationService(ModelMapper mapper, RoomRepository roomRepository, ReservationRepository repo) {
        this.mapper = mapper;
        this.roomRepository = roomRepository;
        this.repo = repo;
    }
    public List<Reservation> getAll(){
        return repo.findAll();
    }

    public Optional<Reservation> getById(
            int reservationId){
        return repo.findById(reservationId);
    }
    public Reservation getByDateInn(
            String dateInn){
        return repo.findByDateInn(dateInn);
    }

    public ReservationDTO create (ReservationDTO dto){
        Reservation reservation = mapper.map(dto , Reservation.class);
        //Room room = roomRepository.findByNumberRoom(dto.getRoom().getNumberRoom());
      // reservation.setRoom(room);
        reservation = repo.save(reservation);
        ReservationDTO reservationDTO = mapper.map(reservation, ReservationDTO.class);
        return reservationDTO;
    }

    public Reservation update(ReservationDTO dto){
        Reservation reservation = mapper.map(dto , Reservation.class);
        return repo.save(reservation);
    }

    public void deleteByDateInn(
            String dateInn){
        Reservation reservation = repo.findByDateInn(dateInn);
        repo.delete(reservation);
    }

    public void deleteById(int reservationId){
        repo.deleteById(reservationId);
    }

    public Reservation findByDateInn(String dateInn){
        return repo.findByDateInn(dateInn);
    }


}
