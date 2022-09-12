package com.stepaniuk.droidbattle.droids;

import java.util.Random;

public class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        if (health>0) return true;
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int attack()
    {
        Random random = new Random();
        return random.nextInt(damage-1)+1;
    }

    public boolean getHit(int damage)
    {
        this.health -= damage;
        if (health < 0) {
            health = 0;
            System.out.println("The "+name+" was killed!");
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "\n(HP: " + health + " Maximal Damage: " + damage+")";
    }
}
