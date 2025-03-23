package pro.ivanov.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    NewTopic productCreatedTopic() {
        return TopicBuilder
                .name("product-created-events-topic")
                .partitions(3)
                //must be as much as servers count
                .replicas(3)
                //two servers must be synchronized to leader (aka Isr)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }

}
