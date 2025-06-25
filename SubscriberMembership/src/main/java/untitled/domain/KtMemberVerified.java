package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class KtMemberVerified extends AbstractEvent {

    private String subscriberId;
    private Boolean ktVerified;

    public KtMemberVerified(Subscriber aggregate) {
        super(aggregate);
    }

    public KtMemberVerified() {
        super();
    }
}
//>>> DDD / Domain Event
