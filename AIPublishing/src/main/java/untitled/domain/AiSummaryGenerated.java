package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AiSummaryGenerated extends AbstractEvent {

    private String publishingJobId;
    private String summaryText;
    private PublishingJobStatus status;

    public AiSummaryGenerated(PublishingJob aggregate) {
        super(aggregate);
    }

    public AiSummaryGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
