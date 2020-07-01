package services.app.authenticationservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE_NAME = "emails";
    public static final String AUTH_SYNC_QUEUE_NAME = "auth_sync_rpc";
    public static final String USER_ID_QUEUE_NAME = "user_id";

    @Bean
    public Queue userIdQueue() {
        return new Queue(USER_ID_QUEUE_NAME, false);
    }

    @Bean
    public Queue authQueue() {
        return new Queue(AUTH_SYNC_QUEUE_NAME, false);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
}
