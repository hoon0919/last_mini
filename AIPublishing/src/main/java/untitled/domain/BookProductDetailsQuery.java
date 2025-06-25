package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookProductDetailsQuery {

    private String productId;
    private PublishingJobId publishingJobId;
}
