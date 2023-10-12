package com.mv.SpringAsyncExample.service;

import com.mv.SpringAsyncExample.model.MovieModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class MovieService {
    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);

    private final RestTemplate restTemplate;

    public MovieService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    //https://ghibliapi.vercel.app/films/58611129-2dbc-4a81-a72f-77ddfc1b1b49
    @Async
    public CompletableFuture lookForMovie(String movieId) throws InterruptedException {
        LOG.info("Looking up Movie ID : {}", movieId);
        String url = String.format("https://ghibliapi.vercel.app/films/%s", movieId);
        MovieModel results = restTemplate.getForObject(url, MovieModel.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }



}
