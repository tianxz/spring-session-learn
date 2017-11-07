package org.vinci.spring.sessionlearn.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by XizeTian on 2017/11/6.
 */
@SpringBootApplication
@ServletComponentScan
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}