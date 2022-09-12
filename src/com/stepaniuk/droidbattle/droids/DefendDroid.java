package com.stepaniuk.droidbattle.droids;

import java.util.Random;

public class DefendDroid extends Droid{
    protected int chanceToAbsorbe;
    public DefendDroid() {
        super("Defend Droid", 150, 10);
        this.chanceToAbsorbe = 25;
    }

    public int getChanceToAbsorbe() {
        return chanceToAbsorbe;
    }

    public void setChanceToAbsorbe(int chanceToAbsorbe) {
        this.chanceToAbsorbe = chanceToAbsorbe;
    }

    @Override
    public boolean getHit(int damage) {
        Random random = new Random();
        if(random.nextInt(100) > chanceToAbsorbe) {
            this.health -=damage;
            if (health<0) {
                health = 0;
                System.out.println("The "+name+" was killed!");
            }
            return true;
        }
        else{
            System.out.println("The attack was blocked!");
            return false;
        }
    }
}
