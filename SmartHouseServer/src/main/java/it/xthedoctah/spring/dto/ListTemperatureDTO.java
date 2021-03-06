package it.xthedoctah.spring.dto;

import it.xthedoctah.spring.common.CommonsValue;
import it.xthedoctah.spring.common.DtoBase;

import java.util.ArrayList;

public class ListTemperatureDTO extends DtoBase {

    private ArrayList<TemperatureDTO> temperatureDTOS = new ArrayList<TemperatureDTO>();

    public ListTemperatureDTO(ArrayList<TemperatureDTO> temperatureDTOS) {
        this.temperatureDTOS = temperatureDTOS;
    }

    public ListTemperatureDTO() {
        this.init();
    }

    public ArrayList<TemperatureDTO> getTemperatureDTOS() {
        return temperatureDTOS;
    }

    public void setTemperatureDTOS(ArrayList<TemperatureDTO> temperatureDTOS) {
        this.temperatureDTOS = temperatureDTOS;
    }

    /*Preload empty element into the array*/
    public void init() {
        TemperatureDTO temperatureDTO = new TemperatureDTO();
        System.out.println("INIT: " + CommonsValue.ROOM_AMOUNT);
        for (int i = 0; i < CommonsValue.ROOM_AMOUNT; i++) {
            temperatureDTOS.add(temperatureDTO);
        }
        System.out.println("INIT 2:" + temperatureDTOS.size());
        temperatureDTO = null;
    }
}
