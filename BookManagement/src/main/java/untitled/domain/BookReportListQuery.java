package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookReportListQuery {

    private BookId bookId;
    private Long reporterId;
    private ReportStatus status;
    private Date reportedAtFrom;
    private Date reportedAtTo;
    private Integer page;
    private Integer size;
}
