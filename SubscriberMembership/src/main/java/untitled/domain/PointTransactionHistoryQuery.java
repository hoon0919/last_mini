package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PointTransactionHistoryQuery {

    private String subscriberId;
    private PointTransactionType type;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
