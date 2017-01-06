package es.sandbox.ui.messages.spring.site;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashMessagesSpringBootThymeleafShowcaseApplication {

    private static final Logger LOG = LoggerFactory.getLogger(FlashMessagesSpringBootThymeleafShowcaseApplication.class);

    public FlashMessagesSpringBootThymeleafShowcaseApplication() {
        LOG.info("Loading spring-boot's flash-messages showcase");
    }

    public static void main(String[] args) {
        SpringApplication.run(FlashMessagesSpringBootThymeleafShowcaseApplication.class, args);
    }
}
