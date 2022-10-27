package com.saraya.hotelmanagementndeyegaye.service;

import com.saraya.hotelmanagementndeyegaye.model.Receptionist;
import com.saraya.hotelmanagementndeyegaye.model.Room;
import com.saraya.hotelmanagementndeyegaye.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomService {

    private final RoomRepository repo;

    public RoomService(RoomRepository repo) {
        this.repo = repo;
    }

    public List<Room> getAll(){
        return repo.findAll();
    }

    public Optional<Room> getById(
            int roomId){
        return repo.findById(roomId);
    }
    public Room getByNumberRoom(
            String numberRoom){
        return repo.findByNumberRoom(numberRoom);
    }

    public Room create (Room room){

        return repo.save(room);
    }

    public Room update(Room room){
        return repo.save(room);
    }

    public void deleteByNumberRoom(
            String numberRoom){
        Room room = repo.findByNumberRoom(numberRoom);
        repo.delete(room);
    }

    public void deleteById(int roomId){
        repo.deleteById(roomId);
    }

    public Room findByNumberRoom(String  numberRoom) {
        return repo.findByNumberRoom(numberRoom);
    }

}
