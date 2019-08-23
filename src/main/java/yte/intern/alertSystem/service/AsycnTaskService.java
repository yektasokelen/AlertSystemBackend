package yte.intern.alertSystem.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import yte.intern.alertSystem.model.Alert;
import yte.intern.alertSystem.model.Situation;
import yte.intern.alertSystem.repository.AlertRepository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AsycnTaskService {

    private final RestTemplate restTemplate;
    private final AlertRepository alertRepository;

    /*@Async
    public void aSycnTask(Alert alert, LocalDateTime localDateTime){

    try{

        ResponseEntity<String> result = restTemplate.exchange(alert.getUrl(), alert.getMethod(), null, String.class);

        Situation situation = new Situation(null,localDateTime,1);

        alert.getSituations().add(situation);

    }
        catch(Exception e){

        Situation situation = new Situation(null,localDateTime,0);

        alert.getSituations().add(situation);

        }

    alertRepository.save(alert);
*/

    @Async
    public void webSocketCheckWebsite(Alert alert, LocalDateTime localDateTime) throws IOException {

        try {
            URL url = new URL(alert.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(alert.getMethod().toString());
            int code = connection.getResponseCode();

            Situation situation = new Situation(null,localDateTime,1);
            alert.getSituations().add(situation);

        }
        catch(Exception e){

        Situation situation = new Situation(null,localDateTime,0);

        alert.getSituations().add(situation);

        }

        alertRepository.save(alert);

    }
    



}
