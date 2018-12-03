package spring.ioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.ioc.Country;
import spring.ioc.Tourist;

@Configuration
public class Configs {

    @Bean
    public Tourist getTourist() {
        return new Tourist("James");
    }

    @Bean
    public Country getCountry() {
        return new Country("USA");
    }
}
