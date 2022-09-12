package com.stepaniuk.droidbattle.droids;

import java.util.Random;
/**
 * Клас,що представляє тип Defend дроїда
 * @author Volodymyr Stepaniuk
 */
public class DefendDroid extends Droid{
    protected final int chanceToAbsorbe;
    /**Конструктор без параметрів,що визиває конструктор у батьківського класу*/
    public DefendDroid() {
        super("Defend Droid", 150, 10);
        this.chanceToAbsorbe = 25;
    }

    /**
     * Метод для отримання урону дроїдом
     * @param damage урон,що наніс ворожий дроїд
     * @return false or true
     */
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
