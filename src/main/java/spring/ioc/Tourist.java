package spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class Tourist {
    String name;

    @Autowired
    Country country;

    public Tourist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country.getName();
    }
}
