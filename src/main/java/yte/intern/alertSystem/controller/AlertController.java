package yte.intern.alertSystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yte.intern.alertSystem.model.Alert;
import yte.intern.alertSystem.service.AlertService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AlertController {
    
    private final AlertService alertService;

    @PostMapping("/alert/add")
    public void addAlert(@RequestBody Alert alert){

        alertService.addAlert(alert);

    }

    @DeleteMapping("/alert/delete/{id}")
    public void deleteAlert(@PathVariable Long id){

        alertService.deleteAlert(id);

    }

    @GetMapping("alert/getalert")
    public List<Alert> getAlert(){

        return alertService.getAlerts();

    }

    @GetMapping("alert/{id}")
    public Alert getOneAlert(@PathVariable Long id){

        return alertService.getOneAlert(id);

    }

    @PostMapping("/alert/update")
    public void updateAlert(@RequestBody Alert alert){

        alertService.updateAlert(alert);

    }


}
