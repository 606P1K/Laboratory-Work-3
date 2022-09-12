package com.stepaniuk.droidbattle.droids;

import java.util.Random;

public class HealDroid extends Droid{
    private int chanceToHeal;
    private final int healHp;
    public HealDroid(){
        super("Heal Droid",100,15);
        this.chanceToHeal = 25;
        this.healHp = 10;
    }

    @Override
    public boolean getHit(int damage) {
        Random random = new Random();
        this.health -= damage;
        if(random.nextInt(100) < chanceToHeal) {
            this.health += healHp;
            System.out.println("The heal droid recovered "+healHp+" HP");
        }
        if (health<0) {
            health = 0;
            System.out.println("The "+name+" droid was killed!");
        }
        return true;
    }

    public int getChanceToHeal() {
        return chanceToHeal;
    }

    public void setChanceToHeal(int chanceToHeal) {
        this.chanceToHeal = chanceToHeal;
    }
}
