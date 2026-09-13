package com.questforge.model;

import java.util.Objects;

public final class Reward {
    private final String name;
    private final int amount;

    public Reward (String name, int amount){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Reward name must not be blank");
        }
        if (amount <= 0){
            throw new IllegalArgumentException("Reward amount misy be positive");
        }
        this.name = name;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }
    public int getAmount(){
        return amount;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, amount);
    }

    @Override
    public String toString(){
        return amount + "x " + name;
    }
}
