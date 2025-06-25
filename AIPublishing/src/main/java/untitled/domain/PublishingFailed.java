package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishingFailed extends AbstractEvent {

    private String publishingJobId;
    private String failReason;
    private PublishingJobStatus status;

    public PublishingFailed(PublishingJob aggregate) {
        super(aggregate);
    }

    public PublishingFailed() {
        super();
    }
}
//>>> DDD / Domain Event
