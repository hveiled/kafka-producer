package pro.ivanov.kafka.service.domain.error;

import java.time.Instant;

public record ErrorMessage(
        Instant timestamp,
        String message
) {
}
