package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublishingStatusQuery {

    private Long manuscriptId;
    private ManuscriptStatus status;
    private Date publishedAt;
    private Integer page;
    private Integer size;
}
