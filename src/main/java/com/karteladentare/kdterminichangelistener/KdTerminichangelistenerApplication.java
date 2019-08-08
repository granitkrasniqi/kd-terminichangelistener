package com.karteladentare.kdterminichangelistener;

import com.karteladentare.kdterminichangelistener.events.models.TerminiChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class KdTerminichangelistenerApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(KdTerminichangelistenerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KdTerminichangelistenerApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(TerminiChangeModel terminiChangeModel) {
        logger.info("Received an event for termini id {}",
                terminiChangeModel.getTerminiId());
    }
}
