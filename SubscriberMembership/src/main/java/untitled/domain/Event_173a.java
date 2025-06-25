package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Event_173a extends AbstractEvent {

    private Long id;

    public Event_173a(PointTransaction aggregate) {
        super(aggregate);
    }

    public Event_173a() {
        super();
    }
}
//>>> DDD / Domain Event
