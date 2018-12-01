package edu.basic.preparation.design;

import java.util.LinkedList;

import lombok.Data;

/**
 * Animal shelter problem by cracking the coding interview
 */
@Data
public class AnimalShelter {

    LinkedList<Dog> dogs = new LinkedList<>();

    LinkedList<Cat> cats = new LinkedList<>();

    int order = 0;


    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogs.add((Dog) animal);
        } else {
            cats.add((Cat) animal);
        }

    }

    public Animal dequeueAny() {
        if(dogs.isEmpty() && cats.isEmpty()){
            System.out.println("Shelter has no cats or dogs");
            throw new UnsupportedOperationException("No animals");
        }

        if (dogs.isEmpty()) {
            return dequeueCat();
        }

        if (cats.isEmpty()) {
            return dequeueDog();
        }

        final Dog dog = dogs.peek();
        final Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }


    public Dog dequeueDog() {
        return dogs.remove();
    }

    public Cat dequeueCat() {
        return cats.remove();
    }
}
