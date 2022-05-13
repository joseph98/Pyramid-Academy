package genspark.projects.dragoncave;

import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final String PROMPT="You are in a land full of dragon. In front of you,\nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.\nWhich cave will you go into? (1 or 2)";
    private static final String ERROR="Please enter a cave number (1 or 2)";
    public static void main(String[]args)
    {
        DragonCavern oneGoodOneBad = new DragonCavern(2,1);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println(PROMPT);
        while (scanner.hasNext())
        {
            if (scanner.hasNextInt())
            {
                int i = scanner.nextInt();
                if (i >= 1 && i <=2)
                {
                    System.out.println(oneGoodOneBad.nthCave(i));
                    break;
                }
                else System.out.println(ERROR);
            }
            else {System.out.println(ERROR); scanner.next();}
        }
    }
}
