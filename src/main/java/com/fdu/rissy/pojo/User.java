package com.fdu.rissy.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lins13 on 3/21/17.
 */
@Entity
@Table(name = "user2")
public class User implements Serializable{

    private static final long serialVersionUID = 6682783604824499377L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
