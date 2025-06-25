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
// @RequestMapping(value="/books")
@Transactional
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(
        value = "/booksreviewbook",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Book reviewBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReviewBookCommand reviewBookCommand
    ) throws Exception {
        System.out.println("##### /book/reviewBook  called #####");
        Book book = new Book();
        book.reviewBook(reviewBookCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/bookssetbookhidden",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Book setBookHidden(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SetBookHiddenCommand setBookHiddenCommand
    ) throws Exception {
        System.out.println("##### /book/setBookHidden  called #####");
        Book book = new Book();
        book.setBookHidden(setBookHiddenCommand);
        bookRepository.save(book);
        return book;
    }
}
//>>> Clean Arch / Inbound Adaptor
