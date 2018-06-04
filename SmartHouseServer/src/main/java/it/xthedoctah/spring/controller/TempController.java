package it.xthedoctah.spring.controller;

import it.xthedoctah.spring.common.CommonsValue;
import it.xthedoctah.spring.common.ParserClass;
import it.xthedoctah.spring.dto.ListTemperatureDTO;
import it.xthedoctah.spring.dto.TemperatureDTO;
import it.xthedoctah.spring.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
public class TempController {
    @Autowired
    TempService temp;


    @RequestMapping(value = "/")
    public void index() {
        System.out.println("La grandezza è " + temp.getAllTemps().getTemperatureDTOS().size());
    }

    @RequestMapping(value = "/currenttemp")
    @ResponseBody
    public TemperatureDTO getTemp(@RequestParam int id) {
        return this.temp.getRoomTemp(id);
    }

    @RequestMapping(value = "/alltemps")
    @ResponseBody
    public ListTemperatureDTO getAllTemps() {
        return this.temp.getAllTemps();
    }

    /*
     * Accept GET request to update the TempService Data.
     */
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public void setTempArduino(@RequestParam int id, @RequestParam double temp, @RequestParam double humidity, @RequestParam int pressure) {
        this.temp.modifyTemp(id, temp, humidity, pressure);
        String[] params = new String[]{"Id Stanza", "Temperatura", "Umidità", "Pressione"};
        ParserClass.jsonToCsv(this.temp.getRoomTemp(id), params, CommonsValue.TEMP_LIST_CSV);
    }

    @RequestMapping(value = "/testdata")
    public void setTestData() {
        for (int i = 0; i < CommonsValue.ROOM_AMOUNT; i++) {
            this.temp.modifyTemp(i, Math.round(Math.random() * 10), Math.round(Math.random() * 10), 10);//FIXME: Take only 2 dec.
        }
    }

}
