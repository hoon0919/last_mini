package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookAdminListQuery {

    private BookStatus status;
    private BookVisibility visibility;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
