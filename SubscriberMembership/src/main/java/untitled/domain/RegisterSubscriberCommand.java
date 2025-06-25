package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterSubscriberCommand {

    private String name;
    private String phoneNumber;
}
