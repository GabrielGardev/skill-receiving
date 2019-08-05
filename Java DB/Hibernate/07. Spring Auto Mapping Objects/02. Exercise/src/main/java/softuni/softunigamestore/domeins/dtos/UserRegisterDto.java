package softuni.softunigamestore.domeins.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserRegisterDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
}
