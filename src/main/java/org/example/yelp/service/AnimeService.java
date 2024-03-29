package org.example.yelp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


@Service
@Slf4j
public class AnimeService {

    private static final String url = "https://myanimelist.p.rapidapi.com/anime/52991";
    private static final String xRapidAPIKey = "3b8b1d289emshdb414c508d57ac8p1f2d30jsneafbddd01250";
    private static final String xRapidAPIHost = "myanimelist.p.rapidapi.com";


    @Autowired
    private RestTemplate restTemplate;

    public Object allAnime() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidAPIKey);
            headers.set("X-RapidAPI-Host", xRapidAPIHost);

            //making get call to rapid api
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            log.info("Output from Rapid API: {}", response.getBody());
            return response.getBody();

        } catch (Exception e){
            log.error("something wrong getting value from api", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "exception while calling endpoint",
                    e
            );
        }
    }
}
