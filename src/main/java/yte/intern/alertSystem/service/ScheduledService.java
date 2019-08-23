package yte.intern.alertSystem.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import yte.intern.alertSystem.model.Alert;
import yte.intern.alertSystem.repository.AlertRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduledService {

    private AsycnTaskService asycnTaskService;
    private AlertRepository alertRepository;

   @Scheduled(fixedDelay = 1000)
    public void alertCheck() throws IOException {

        List<Alert> alerts = alertRepository.findAll();

        for(Alert alert :alerts){

            LocalDateTime localDateTime = LocalDateTime.now();

            if(alert.getLeftperiod()==0L){
                alert.setLeftperiod(alert.getPeriod());
                asycnTaskService.webSocketCheckWebsite(alert,localDateTime);

            }
            else{
                alert.setLeftperiod(alert.getLeftperiod()-1L);
                alertRepository.save(alert);
            }
        }
    }



}
