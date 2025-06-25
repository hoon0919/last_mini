package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookProductListQuery {

    private PublishingJobId publishingJobId;
    private Date registrationDateFrom;
    private Date registrationDateTo;
    private Integer page;
    private Integer size;
}
