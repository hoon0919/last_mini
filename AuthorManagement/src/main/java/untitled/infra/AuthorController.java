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
// @RequestMapping(value="/authors")
@Transactional
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(
        value = "/authorsapproveauthor",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Author approveAuthor(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ApproveAuthorCommand approveAuthorCommand
    ) throws Exception {
        System.out.println("##### /author/approveAuthor  called #####");
        Author author = new Author();
        author.approveAuthor(approveAuthorCommand);
        authorRepository.save(author);
        return author;
    }

    @RequestMapping(
        value = "/authorsrequestauthorregistration",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Author requestAuthorRegistration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestAuthorRegistrationCommand requestAuthorRegistrationCommand
    ) throws Exception {
        System.out.println(
            "##### /author/requestAuthorRegistration  called #####"
        );
        Author author = new Author();
        author.requestAuthorRegistration(requestAuthorRegistrationCommand);
        authorRepository.save(author);
        return author;
    }

    @RequestMapping(
        value = "/authorsrejectauthor",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Author rejectAuthor(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RejectAuthorCommand rejectAuthorCommand
    ) throws Exception {
        System.out.println("##### /author/rejectAuthor  called #####");
        Author author = new Author();
        author.rejectAuthor(rejectAuthorCommand);
        authorRepository.save(author);
        return author;
    }
}
//>>> Clean Arch / Inbound Adaptor
