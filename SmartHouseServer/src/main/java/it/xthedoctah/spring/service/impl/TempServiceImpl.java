package it.xthedoctah.spring.service.impl;

import it.xthedoctah.spring.dto.ListTemperatureDTO;
import it.xthedoctah.spring.dto.TemperatureDTO;
import it.xthedoctah.spring.service.TempService;
import org.springframework.stereotype.Service;


@Service
public class TempServiceImpl implements TempService {

    private ListTemperatureDTO listTemperatureDTO = new ListTemperatureDTO();
    private TemperatureDTO temperatureDTO;

    @Override
    public void modifyTemp(int id, double temp, double humidity, int pressure) {
        this.temperatureDTO = new TemperatureDTO(id, temp, humidity, pressure);
        this.listTemperatureDTO.getTemperatureDTOS().set(id, this.temperatureDTO);
    }

    @Override
    public ListTemperatureDTO getAllTemps() {
        return listTemperatureDTO;
    }

    @Override
    public TemperatureDTO getRoomTemp(int id) {
        for (TemperatureDTO temperatureDTO : listTemperatureDTO.getTemperatureDTOS()) {
            if (temperatureDTO.getIdStanza() == id) {
                return temperatureDTO;
            }
        }
        return null;
    }
}

