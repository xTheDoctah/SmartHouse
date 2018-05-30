package it.xthedoctah.spring.service;

import it.xthedoctah.spring.dto.ListTemperatureDTO;
import it.xthedoctah.spring.dto.TemperatureDTO;

public interface TempService {
    void modifyTemp(int id, double temp, double humidity, int pressure);

    ListTemperatureDTO getAllTemps();

    TemperatureDTO getRoomTemp(int id);


}
