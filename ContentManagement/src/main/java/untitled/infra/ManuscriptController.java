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
// @RequestMapping(value="/manuscripts")
@Transactional
public class ManuscriptController {

    @Autowired
    ManuscriptRepository manuscriptRepository;

    @RequestMapping(
        value = "/manuscriptssavemanuscriptdraft",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Manuscript saveManuscriptDraft(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveManuscriptDraftCommand saveManuscriptDraftCommand
    ) throws Exception {
        System.out.println(
            "##### /manuscript/saveManuscriptDraft  called #####"
        );
        Manuscript manuscript = new Manuscript();
        manuscript.saveManuscriptDraft(saveManuscriptDraftCommand);
        manuscriptRepository.save(manuscript);
        return manuscript;
    }

    @RequestMapping(
        value = "/manuscriptssavemanuscriptfinal",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Manuscript saveManuscriptFinal(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveManuscriptFinalCommand saveManuscriptFinalCommand
    ) throws Exception {
        System.out.println(
            "##### /manuscript/saveManuscriptFinal  called #####"
        );
        Manuscript manuscript = new Manuscript();
        manuscript.saveManuscriptFinal(saveManuscriptFinalCommand);
        manuscriptRepository.save(manuscript);
        return manuscript;
    }
}
//>>> Clean Arch / Inbound Adaptor
