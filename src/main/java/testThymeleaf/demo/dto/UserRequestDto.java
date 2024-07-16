package testThymeleaf.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String email;
    private String fullname;
    private String gender;
    private String country;
}
