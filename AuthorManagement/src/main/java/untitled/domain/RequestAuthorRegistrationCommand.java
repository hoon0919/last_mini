package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestAuthorRegistrationCommand {

    private String name;
    private String email;
    private AuthorBio bio;
    private PortfolioUrl portfolioUrl;
}
