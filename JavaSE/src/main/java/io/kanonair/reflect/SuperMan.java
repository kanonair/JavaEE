package io.kanonair.reflect;

public class SuperMan implements Human {
    @Override
    public void eat(String food) {
        System.out.println("I want to eat" + food);
    }

    @Override
    public String belief() {
        return "I believe I can fly!";
    }
}
