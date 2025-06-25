package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublishingJobStatusListQuery {

    private AuthorId authorId;
    private PublishingJobStatus status;
    private Date requestedAtFrom;
    private Date requestedAtTo;
    private Integer page;
    private Integer size;
}
