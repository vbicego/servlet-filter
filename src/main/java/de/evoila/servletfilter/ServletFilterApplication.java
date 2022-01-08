package de.evoila.servletfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServletFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletFilterApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Hello World";
    }

}
