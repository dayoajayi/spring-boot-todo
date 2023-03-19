package com.dayoajayi.springboottodo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Boolean isDone;

}
