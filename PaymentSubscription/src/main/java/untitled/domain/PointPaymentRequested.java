package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointPaymentRequested extends AbstractEvent {

    private String paymentId;
    private SubscriberId subscriberId;
    private BookId bookId;
    private Integer amount;
    private PaymentStatus status;
    private Date timestamp;

    public PointPaymentRequested(Payment aggregate) {
        super(aggregate);
    }

    public PointPaymentRequested() {
        super();
    }
}
//>>> DDD / Domain Event
