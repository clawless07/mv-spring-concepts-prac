package com.mv.SpringAsyncExample;

import com.mv.SpringAsyncExample.model.MovieModel;
import com.mv.SpringAsyncExample.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncApplicationRunner implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncApplicationRunner.class);

    private final MovieService movieService;

    public AsyncApplicationRunner(MovieService movieService){
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {

        long start = System.currentTimeMillis();

        CompletableFuture<MovieModel> page1 = movieService.lookForMovie("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        CompletableFuture<MovieModel> page2 = movieService.lookForMovie("2baf70d1-42bb-4437-b551-e5fed5a87abe");
        CompletableFuture<MovieModel> page3 = movieService.lookForMovie("4e236f34-b981-41c3-8c65-f8c9000b94e7");

        CompletableFuture.allOf(page1, page2, page3).join();

        // Print results, including elapsed time
        LOG.info("Elapsed time: " + (System.currentTimeMillis() - start));
        LOG.info("--> " + page1.get());
        LOG.info("--> " + page2.get());
        LOG.info("--> " + page3.get());

    }
}
