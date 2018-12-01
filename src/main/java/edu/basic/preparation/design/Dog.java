package edu.basic.preparation.design;

import lombok.Data;

@Data
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dog{" + name + ", order=" + order + "}";
    }
}
