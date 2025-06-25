package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AuthorRegistrationListQuery {

    private AuthorRegistrationStatus registrationStatus;
    private Date registeredAtFrom;
    private Date registeredAtTo;
    private Integer page;
    private Integer size;
}
