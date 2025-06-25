package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GrantDefaultPointCommand {

    private String subscriberId;
    private Integer amount;
}
