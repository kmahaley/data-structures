package edu.basic.preparation.design;

import lombok.Data;

@Data
public abstract class Animal {
    String name;
    int order;

    public Animal(String name) {
        this.name = name;
    }

    public boolean isOlderThan(Animal animal) {
        return this.getOrder() < animal.getOrder();
    }

    @Override
    public String toString() {
        return "Animal{" + name + ", order=" + order + "}";
    }
}


