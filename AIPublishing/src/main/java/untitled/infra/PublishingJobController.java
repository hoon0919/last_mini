package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/publishingJobs")
@Transactional
public class PublishingJobController {

    @Autowired
    PublishingJobRepository publishingJobRepository;

    @RequestMapping(
        value = "/publishingJobsfailpublishing",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublishingJob failPublishing(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody FailPublishingCommand failPublishingCommand
    ) throws Exception {
        System.out.println("##### /publishingJob/failPublishing  called #####");
        PublishingJob publishingJob = new PublishingJob();
        publishingJob.failPublishing(failPublishingCommand);
        publishingJobRepository.save(publishingJob);
        return publishingJob;
    }

    @RequestMapping(
        value = "/publishingJobsrequestpublishing",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublishingJob requestPublishing(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestPublishingCommand requestPublishingCommand
    ) throws Exception {
        System.out.println(
            "##### /publishingJob/requestPublishing  called #####"
        );
        PublishingJob publishingJob = new PublishingJob();
        publishingJob.requestPublishing(requestPublishingCommand);
        publishingJobRepository.save(publishingJob);
        return publishingJob;
    }

    @RequestMapping(
        value = "/publishingJobscompletepublishing",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublishingJob completePublishing(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CompletePublishingCommand completePublishingCommand
    ) throws Exception {
        System.out.println(
            "##### /publishingJob/completePublishing  called #####"
        );
        PublishingJob publishingJob = new PublishingJob();
        publishingJob.completePublishing(completePublishingCommand);
        publishingJobRepository.save(publishingJob);
        return publishingJob;
    }

    @RequestMapping(
        value = "/publishingJobsgenerateaisummary",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublishingJob generateAiSummary(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GenerateAiSummaryCommand generateAiSummaryCommand
    ) throws Exception {
        System.out.println(
            "##### /publishingJob/generateAiSummary  called #####"
        );
        PublishingJob publishingJob = new PublishingJob();
        publishingJob.generateAiSummary(generateAiSummaryCommand);
        publishingJobRepository.save(publishingJob);
        return publishingJob;
    }

    @RequestMapping(
        value = "/publishingJobsgenerateaicover",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublishingJob generateAiCover(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GenerateAiCoverCommand generateAiCoverCommand
    ) throws Exception {
        System.out.println(
            "##### /publishingJob/generateAiCover  called #####"
        );
        PublishingJob publishingJob = new PublishingJob();
        publishingJob.generateAiCover(generateAiCoverCommand);
        publishingJobRepository.save(publishingJob);
        return publishingJob;
    }
}
//>>> Clean Arch / Inbound Adaptor
