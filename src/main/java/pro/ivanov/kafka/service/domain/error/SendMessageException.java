package pro.ivanov.kafka.service.domain.error;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SendMessageException extends RuntimeException {

    private Instant timestamp;
}
