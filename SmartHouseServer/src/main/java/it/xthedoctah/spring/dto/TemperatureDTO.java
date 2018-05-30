package it.xthedoctah.spring.dto;

import it.xthedoctah.spring.common.DtoBase;


public class TemperatureDTO extends DtoBase {

    private int idStanza;
    private double temp;
    private double humidity;
    private double temp_min;
    private double temp_max;
    private int pressure;

    public TemperatureDTO(int idStanza, double temp, double humidity, int pressure) {
        this.idStanza = idStanza;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public TemperatureDTO() {

    }

    public int getIdStanza() {
        return idStanza;
    }

    public void setIdStanza(int idStanza) {
        this.idStanza = idStanza;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String[] record() {
        return new String[]{String.valueOf(idStanza), String.valueOf(this.temp), String.valueOf(this.humidity), String.valueOf(this.pressure)};
    }
}

