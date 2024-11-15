package com.bookride.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bookride.dto.DriverDto;
import com.bookride.service.DriverService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/chauffeurs")
@RestController
@Validated
@RequiredArgsConstructor
public class DriverController {
    
    private final DriverService driverService;

    @GetMapping("/list")
    public List<DriverDto> getAllDrivers(){
        List<DriverDto> driver = driverService.getAll();
        return driver;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable Long id){
        DriverDto driver = driverService.getById(id);
        return new ResponseEntity<>(driver,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DriverDto> createDriver(@RequestBody @Valid DriverDto driverDto ){
        DriverDto driver = driverService.create(driverDto);
        return new ResponseEntity<>(driver,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DriverDto> updateDriver(@PathVariable Long id , @RequestBody @Valid DriverDto driverDto ){
        DriverDto driver = driverService.update(id, driverDto);
        return new ResponseEntity<>(driver,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DriverDto> deleteDriver(@PathVariable Long id){
        driverService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
