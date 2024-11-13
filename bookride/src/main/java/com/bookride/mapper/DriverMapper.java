package com.bookride.mapper;

import org.mapstruct.Mapping;

import com.bookride.dto.DriverDto;
import com.bookride.model.Driver;

import liquibase.pro.packaged.M;

public interface  DriverMapper {
    DriverDto toDto(Driver driver);
    Driver toEntity(DriverDto driverDto);
}