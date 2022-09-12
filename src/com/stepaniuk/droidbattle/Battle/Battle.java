package com.stepaniuk.droidbattle.Battle;

import com.stepaniuk.droidbattle.Printer.Printer;
import com.stepaniuk.droidbattle.Team.Team;
import com.stepaniuk.droidbattle.droids.Droid;

public class Battle {

    public Team firstTeam;
    public Team secondTeam;
    private int currentRound = 1;

    public Battle(Team firstTeam,Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public void start() {
        battle();
    }

    private void fight(Team first,Team second,int myDroidIndex,int enemyDroidIndex)
    {
        if(!first.getDroidList().isEmpty())
        {
            Droid firstDroid=first.getDroidList().get(myDroidIndex);
            Droid secondDroid=second.getDroidList().get(enemyDroidIndex);
            int damage = firstDroid.attack();
            boolean isDamaged = secondDroid.getHit(damage);

            if(isDamaged)
                Printer.print(first.getDroidList().get(myDroidIndex).getName()+" give "+damage+ " damage to "+secondDroid.getName());

            if(second.getDroidList().get(enemyDroidIndex).getHealth()<=0) second.getDroidList().remove(enemyDroidIndex);
        }
        else Printer.print("Team is empty\n");

    }
    private void battle()
    {
        int myDroidIndex=0;
        int enemyDroidIndex=0;
        while (!firstTeam.getDroidList().isEmpty() && !secondTeam.getDroidList().isEmpty()) {
            Printer.print("\n----------------------------Round №" + currentRound++ +"----------------------------");

            Printer.print("First team turn:");
            fight(firstTeam,secondTeam,myDroidIndex,enemyDroidIndex);
            Printer.print("\nSecond team turn:");
            fight(secondTeam,firstTeam,enemyDroidIndex,myDroidIndex);
            showInfo();

            myDroidIndex++;
            enemyDroidIndex++;

            if(myDroidIndex>=firstTeam.getDroidList().size()-1) myDroidIndex=0;

            if(enemyDroidIndex>=secondTeam.getDroidList().size()-1) enemyDroidIndex=0;

        }
        if(firstTeam.getDroidList().isEmpty()) Printer.print("\nSecond team win\n");
        else Printer.print("\nFirst team win\n");
    }
    private void showInfo()
    {
        Printer.print("\nFirst team:");
        printList(firstTeam);

        Printer.print("\nSecond team:");
        printList(secondTeam);
    }
    private void printList(Team team)
    {
        if(team.getDroidList().isEmpty()) Printer.print("Empty");

        for (int i = 0;i<team.getDroidList().size();i++)
            Printer.print(team.getDroidList().get(i).toString());
    }

}
