package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishingCompleted extends AbstractEvent {

    private String publishingJobId;
    private String coverImageUrl;
    private String summaryText;
    private String productId;
    private Date completedAt;
    private PublishingJobStatus status;

    public PublishingCompleted(PublishingJob aggregate) {
        super(aggregate);
    }

    public PublishingCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
