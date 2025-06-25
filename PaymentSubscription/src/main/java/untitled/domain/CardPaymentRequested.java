package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CardPaymentRequested extends AbstractEvent {

    private String paymentId;
    private SubscriberId subscriberId;
    private Integer amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private Date timestamp;

    public CardPaymentRequested(Payment aggregate) {
        super(aggregate);
    }

    public CardPaymentRequested() {
        super();
    }
}
//>>> DDD / Domain Event
