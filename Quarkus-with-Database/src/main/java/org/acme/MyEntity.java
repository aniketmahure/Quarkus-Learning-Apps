package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
//By Adding PanacheEntity, your MyEntity class automatically gains access
// to the static methods provided by Panache for performing
// database operations like persist(), findById(), listAll(), deleteById(), etc.
public class MyEntity extends PanacheEntity {
    public String name;
    public int age;
}