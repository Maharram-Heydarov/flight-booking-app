package az.edu.turing.flightbookingapp.service.impl;

import az.edu.turing.flightbookingapp.dto.FlightDto;
import az.edu.turing.flightbookingapp.entity.FlightEntity;
import az.edu.turing.flightbookingapp.exception.FlightNotFoundException;
import az.edu.turing.flightbookingapp.mapper.FlightMapper;
import az.edu.turing.flightbookingapp.repository.FlightRepository;
import az.edu.turing.flightbookingapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Autowired
    public AdminServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        FlightEntity flightEntity = flightMapper.toEntity(flightDto);
        FlightEntity savedFlight = flightRepository.save(flightEntity);
        return flightMapper.toDto(savedFlight);
    }

    @Override
    public FlightDto updateFlight(Long id, FlightDto flightDto) {
        FlightEntity flightEntity = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + id + " not found"));
        flightEntity.setDepartureLocation(flightDto.getDepartureLocation());
        flightEntity.setDestinationLocation(flightDto.getDestinationLocation());
        flightEntity.setDate(flightDto.getDate());
        flightEntity.setTime(flightDto.getTime());
        FlightEntity updatedFlight = flightRepository.save(flightEntity);
        return flightMapper.toDto(updatedFlight);
    }

    @Override
    public void deleteFlight(Long id) {
        FlightEntity flightEntity = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + id + " not found"));
        flightRepository.delete(flightEntity);
    }
}