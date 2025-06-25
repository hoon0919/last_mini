package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestPublishingCommand {

    private AuthorId authorId;
    private String contentId;
}
