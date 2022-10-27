package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.model.Room;
import com.saraya.hotelmanagementndeyegaye.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('USER')")
@RequestMapping("/api/test/room" )
@CrossOrigin(origins = "*")
public class RoomController {

    private final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }


@GetMapping
//@PreAuthorize("hasRole('ADMIN')")
    public List<Room> getAll(){
        LOGGER.info("All of the Room");
        return service.getAll();
    }

    @GetMapping("/{roomId}")
    public Room getById(@PathVariable int roomId){
        LOGGER.info("Get the Room by the id");
        return service.getById(roomId).get();
    }

    @GetMapping("/number/{numberRoom}")
    public Room getByNumberRoom(@PathVariable String numberRoom){
        LOGGER.info("Get the Room by the NumberRoom");
        return service.getByNumberRoom(numberRoom);
    }
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    public Room create(@RequestBody Room room){
        LOGGER.info("CREATING NEW ROOM...");
        return service.create(room);
    }

    @PutMapping
    public Room update(@RequestBody Room room){
        LOGGER.info("Update a Room...");
        return service.update(room);
    }

    @DeleteMapping("delete/{numberRoom}")
    public void deleteByNumberRoom(@PathVariable String numberRoom){
        LOGGER.info("Delete Room by tne NumberRoom....");
        service.deleteByNumberRoom(numberRoom);
    }

    @DeleteMapping("/{roomId}")
    public void deleteById(@PathVariable int roomId){
        LOGGER.info("Delete a Room by the ID.....");
        service.deleteById(roomId);
    }

}
