package az.edu.turing.flightbookingapp.controller;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/flights")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto) {
        FlightDto addedFlight = adminService.addFlight(flightDto);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Long id, @RequestBody FlightDto flightDto) {
        FlightDto updatedFlight = adminService.updateFlight(id, flightDto);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        adminService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
