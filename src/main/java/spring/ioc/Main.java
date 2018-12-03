package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.configuration.Configs;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configs.class);
        Tourist tourist = context.getBean(Tourist.class);
        System.out.println(tourist.getName());
        System.out.println(tourist.getCountry());
    }
}
