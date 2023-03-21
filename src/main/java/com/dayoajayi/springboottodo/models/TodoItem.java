package com.dayoajayi.springboottodo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private boolean isDone;


    public TodoItem(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }
}
