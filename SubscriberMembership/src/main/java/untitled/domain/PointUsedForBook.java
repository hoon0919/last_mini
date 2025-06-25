package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointUsedForBook extends AbstractEvent {

    private String subscriberId;
    private String bookId;
    private Integer amount;
    private Integer pointBalance;
    private Date createdAt;

    public PointUsedForBook(Subscriber aggregate) {
        super(aggregate);
    }

    public PointUsedForBook() {
        super();
    }
}
//>>> DDD / Domain Event
