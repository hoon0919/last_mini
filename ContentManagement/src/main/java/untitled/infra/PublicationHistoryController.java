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
// @RequestMapping(value="/publicationHistories")
@Transactional
public class PublicationHistoryController {

    @Autowired
    PublicationHistoryRepository publicationHistoryRepository;

    @RequestMapping(
        value = "/publicationHistoriescreatepublicationhistory",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationHistory createPublicationHistory(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreatePublicationHistoryCommand createPublicationHistoryCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationHistory/createPublicationHistory  called #####"
        );
        PublicationHistory publicationHistory = new PublicationHistory();
        publicationHistory.createPublicationHistory(
            createPublicationHistoryCommand
        );
        publicationHistoryRepository.save(publicationHistory);
        return publicationHistory;
    }

    @RequestMapping(
        value = "/publicationHistoriesupdatepublicationstatus",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationHistory updatePublicationStatus(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationStatusCommand updatePublicationStatusCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationHistory/updatePublicationStatus  called #####"
        );
        PublicationHistory publicationHistory = new PublicationHistory();
        publicationHistory.updatePublicationStatus(
            updatePublicationStatusCommand
        );
        publicationHistoryRepository.save(publicationHistory);
        return publicationHistory;
    }
}
//>>> Clean Arch / Inbound Adaptor
