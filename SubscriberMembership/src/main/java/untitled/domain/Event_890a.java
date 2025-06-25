package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Event_890a extends AbstractEvent {

    private Long id;

    public Event_890a(PointTransaction aggregate) {
        super(aggregate);
    }

    public Event_890a() {
        super();
    }
}
//>>> DDD / Domain Event
