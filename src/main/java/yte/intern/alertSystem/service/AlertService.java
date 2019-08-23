package yte.intern.alertSystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.alertSystem.model.Alert;
import yte.intern.alertSystem.repository.AlertRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;

    public void addAlert(Alert alert){

        if(!alert.getUrl().contains("Http://"+alert.getUrl())){

            alert.setUrl("http://"+alert.getUrl());

        }

        this.alertRepository.save(alert);

    }

   public List<Alert> getAlerts(){

        return alertRepository.findAll();

   }

   public void deleteAlert(Long id){

        this.alertRepository.deleteById(id);

   }

   public Alert getOneAlert(Long id){

        return this.alertRepository.getById(id);

   }
   public void updateAlert(Alert alert){

        if(!alert.getUrl().contains("Http://"+alert.getUrl())){

            alert.setUrl("http://"+alert.getUrl());

        }

        Alert alert1 = alertRepository.getById(alert.getId());

        alert.setSituations(alert1.getSituations());

        alertRepository.save(alert);

   }

}
