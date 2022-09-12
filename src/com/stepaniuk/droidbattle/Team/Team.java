package com.stepaniuk.droidbattle.Team;

import com.stepaniuk.droidbattle.Printer.Printer;
import com.stepaniuk.droidbattle.droids.AttackDroid;
import com.stepaniuk.droidbattle.droids.HealDroid;
import com.stepaniuk.droidbattle.droids.DefendDroid;
import com.stepaniuk.droidbattle.droids.Droid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    private final List<Droid> droids = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public Team(int size)
    {
        fillTeam(size);
    }
    public List<Droid> getDroidList() {
        return droids;
    }
    public void fillTeam(int size)
    {
        for (int i = 0; i < size; i++) {
            Printer.print("Choose droid №" + (i + 1));
            try {
                droids.add(chooseDroid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Droid chooseDroid() throws IOException {
        Printer.print("1. Heal Droid\n2. Attack Droid\n3. Defend Droid");
        Droid droid;
        System.out.print("Your choice: ");
        String value = scanner.nextLine();

        while (!value.equals("1") && !value.equals("2")&& !value.equals("3")) {
            Printer.print("Invalid request");
            value = scanner.nextLine();
        }

        droid = switch (value) {
            case "1" -> new HealDroid();
            case "2" -> new AttackDroid();
            default -> new DefendDroid();
        };

        Printer.printInputValue("Your choice: "+value);
        return droid;
    }
}
