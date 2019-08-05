package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ReaderConfig {

    private static final BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public BufferedReader bufferedReader() {

        return reader;
    }
}
