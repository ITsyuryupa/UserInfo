package itsyuryupa.userinfo.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @JsonView(Views.UserSummary.class)
    private String name;

    @JsonView(Views.UserSummary.class)
    @NotBlank(message = "Почта не может быть пустой")
    @Email(message = "Некорректный формат email")
    private String email;

    @JsonView(Views.UserDetails.class)
    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}

