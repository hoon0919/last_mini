package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ManuscriptListQuery {

    private AuthorId authorId;
    private ManuscriptStatus status;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
