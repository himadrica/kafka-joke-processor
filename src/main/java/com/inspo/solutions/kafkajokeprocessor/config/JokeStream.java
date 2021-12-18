package com.inspo.solutions.kafkajokeprocessor.config;

import com.inspo.solutions.kafkajokeprocessor.model.Joke;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class JokeStream {

    @Bean
    Function<KStream<String, Joke>, KStream<String, Joke>> jokeProcessor(){
        return kstream -> kstream.filter((key, joke) -> {
           return joke.isSafe();
        });
    }
}
