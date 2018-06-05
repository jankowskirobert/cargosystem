package eu.jankowskirobert.cargosystem.domain.order;

import ch.qos.logback.core.net.server.Client;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Accessors(fluent = true)
public class Order {

    private Client client;
    private BigDecimal totalCost;

    private List<OrderLine> items;

    private LocalDateTime submitDate;

    private OrderStatus status;

    public enum OrderStatus {
        ARCHIVED, SUBMITTED, DRAFT
    }

    private OrderPolicy policy;

}
