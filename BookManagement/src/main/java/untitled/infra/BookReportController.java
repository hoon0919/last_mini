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
// @RequestMapping(value="/bookReports")
@Transactional
public class BookReportController {

    @Autowired
    BookReportRepository bookReportRepository;

    @RequestMapping(
        value = "/bookReportscreatebookreport",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public BookReport createBookReport(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateBookReportCommand createBookReportCommand
    ) throws Exception {
        System.out.println("##### /bookReport/createBookReport  called #####");
        BookReport bookReport = new BookReport();
        bookReport.createBookReport(createBookReportCommand);
        bookReportRepository.save(bookReport);
        return bookReport;
    }
}
//>>> Clean Arch / Inbound Adaptor
