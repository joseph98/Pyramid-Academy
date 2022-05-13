package genspark.projects.dragoncave;

import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final String SUCCESS="You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nCompliments you on your courage!\nAs a reward, you can take as much treasure back to your village as you can carry.";
    private static final String FAILURE="You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you! He opens his jaws and...\nGobbles you down in one bite!";
    private static final String PROMPT="You are in a land full of dragon. In front of you,\nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.\nWhich cave will you go into? (1 or 2)";
    private static final String ERROR="Please enter a cave number (1 or 2)";
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int goodCave = random.nextInt(2) +1;
        System.out.println("Goodcave is: " + goodCave);
        System.out.println(PROMPT);
        while (scanner.hasNext())
        {
            if (scanner.hasNextInt())
            {
                int i = scanner.nextInt();
                if (i >= 1 && i <=2)
                {
                    System.out.println(i==goodCave? SUCCESS : FAILURE);
                    break;
                }
                else System.out.println(ERROR);
            }
            else {System.out.println(ERROR); scanner.next();}
        }
    }
}
