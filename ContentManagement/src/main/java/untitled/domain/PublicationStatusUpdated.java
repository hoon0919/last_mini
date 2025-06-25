package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationStatusUpdated extends AbstractEvent {

    private Long publicationHistoryId;
    private PublicationResultStatus resultStatus;
    private String resultMessage;
    private Date publishedAt;

    public PublicationStatusUpdated(PublicationHistory aggregate) {
        super(aggregate);
    }

    public PublicationStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
