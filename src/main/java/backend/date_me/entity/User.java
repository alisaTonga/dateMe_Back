package backend.date_me.entity;

import backend.date_me.constants.ValidationConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "The field email cannot be empty")
    @Size(max = 3, message = "Min 3 symbols")
    @Pattern(regexp = ValidationConstants.USER_NAME_REGEX, message = "Name must contain only letters, hyphen, and dot")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "The field email cannot be empty")
    @Size(max = 100, message = "Max 100 symbols")
    @Email(message = "Invalid email format!")
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    @NotBlank(message = "The password name cannot be empty")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(regexp = ValidationConstants.PASSWORD_REGEX, message = "The password must contain a minimum of 8 characters, at least one number and one capital letter")
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
