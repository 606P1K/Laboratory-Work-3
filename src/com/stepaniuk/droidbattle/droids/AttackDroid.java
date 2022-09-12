package com.stepaniuk.droidbattle.droids;

import java.util.Random;

public class AttackDroid extends Droid{
    private int chanceCrit;
    private int critAttack;

    public AttackDroid() {
        super("Attack Droid",70,20);
        critAttack=25;
        chanceCrit=25;
    }

    @Override
    public int attack() {
        Random random = new Random();
        if (random.nextInt(100) > chanceCrit) return random.nextInt(damage-1)+1;
        else{
            System.out.println("Critical attack!");
            return critAttack;}
    }

    public int getChanceCrit() {
        return chanceCrit;
    }

    public void setChanceCrit(int chanceCrit) {
        this.chanceCrit = chanceCrit;
    }

    public int getCritAttack() {
        return critAttack;
    }

    public void setCritAttack(int critAttack) {
        this.critAttack = critAttack;
    }
}
