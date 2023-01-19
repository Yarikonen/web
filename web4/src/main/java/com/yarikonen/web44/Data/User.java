package com.yarikonen.web44.Data;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "dot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dot_sequence"
    )
    private  Long id;
    private String userName;
    private String password;
}
