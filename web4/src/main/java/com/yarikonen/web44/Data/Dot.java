package com.yarikonen.web44.Data;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Dot {
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
    private Long id;
    private double x;
    private double y;
    private double r;
    private LocalTime birthTime;
    private boolean hit = false;
    private long exTime;

}
