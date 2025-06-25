package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AiPublishingApplication;

@Entity
@Table(name = "PublishingJob_table")
@Data
//<<< DDD / Aggregate Root
public class PublishingJob {

    @Id
    private String publishingJobId;

    private String contentId;

    private PublishingJobStatus status;

    private String coverImageUrl;

    private String summaryText;

    private String productId;

    private Date requestedAt;

    private Date completedAt;

    @Embedded
    private AuthorId authorId;

    @Embedded
    private ManuscriptId manuscriptId;

    public static PublishingJobRepository repository() {
        PublishingJobRepository publishingJobRepository = AiPublishingApplication.applicationContext.getBean(
            PublishingJobRepository.class
        );
        return publishingJobRepository;
    }

    //<<< Clean Arch / Port Method
    public void failPublishing(FailPublishingCommand failPublishingCommand) {
        //implement business logic here:

        PublishingFailed publishingFailed = new PublishingFailed(this);
        publishingFailed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void requestPublishing(
        RequestPublishingCommand requestPublishingCommand
    ) {
        //implement business logic here:

        PublishRequested publishRequested = new PublishRequested(this);
        publishRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completePublishing(
        CompletePublishingCommand completePublishingCommand
    ) {
        //implement business logic here:

        PublishingCompleted publishingCompleted = new PublishingCompleted(this);
        publishingCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void generateAiSummary(
        GenerateAiSummaryCommand generateAiSummaryCommand
    ) {
        //implement business logic here:

        AiSummaryGenerated aiSummaryGenerated = new AiSummaryGenerated(this);
        aiSummaryGenerated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void generateAiCover(GenerateAiCoverCommand generateAiCoverCommand) {
        //implement business logic here:

        AiCoverGenerated aiCoverGenerated = new AiCoverGenerated(this);
        aiCoverGenerated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
