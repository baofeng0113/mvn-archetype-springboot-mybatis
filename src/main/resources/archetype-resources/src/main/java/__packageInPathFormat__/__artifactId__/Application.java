package ${package}.${artifactId};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import ${package}.${artifactId}.framework.context.ApplicationContextListener;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    public ApplicationContextListener applicationContextListener() {
        return new ApplicationContextListener();
    }

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        SpringApplication.run(Application.class, args);
        LOGGER.info("Spring boot application startup success, cost: {}ms",
                System.currentTimeMillis() - currentTimeMillis);
    }
}
