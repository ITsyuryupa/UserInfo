package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Цена не может быть пустой")
    private double amount;

    @NotBlank(message = "Статус не может быть пустым")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

