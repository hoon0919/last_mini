package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UsePointForBookCommand {

    private String subscriberId;
    private String bookId;
    private Integer pointRequired;
}
