package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateBookReportCommand {

    private BookId bookId;
    private Long reporterId;
    private String reason;
}
