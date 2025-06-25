package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SaveManuscriptDraftCommand {

    private AuthorId authorId;
    private String title;
    private String content;
}
