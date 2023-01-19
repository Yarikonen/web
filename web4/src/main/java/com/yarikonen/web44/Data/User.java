package com.yarikonen.web44.Data;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "user_id_generator", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String login;
    private String password;


}
