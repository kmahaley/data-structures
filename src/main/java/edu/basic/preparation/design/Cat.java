package edu.basic.preparation.design;

import lombok.Data;

@Data
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
