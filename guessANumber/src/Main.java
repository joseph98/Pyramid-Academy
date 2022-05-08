import java.text.MessageFormat;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static final String PROMPT1 = "Hello!  What is your name?";
    public static final String PROMPT2 = "Well, {0}, I am thinking of a number between 1 and 20";
    public static final String GUESS = "Take a guess.";
    public static final String SUCCESS = "Good job {0}, you got my number in {1} guesses!";
    public static final String TOOHIGH = "Your guess is too high, you have {0} guesses remaining";
    public static final String TOOLOW = "Your guess is too low, you have {0} guesses remaining";
    public static final String FAILURE = "Sorry {0}, you didn't guess my number, better luck next time.";
    public static final String NAN = "Please enter a number between 1 and 20";
    public static final String AGAIN = "Would you like to play again (y or n)";

    public static void main(String[] args)
    {
        System.out.println(PROMPT1);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        while (true) {
            doGuessingGame(name);
            while (true) {
                System.out.println(AGAIN);
                String s = scanner.next();
                if (s.toLowerCase().equals("y")) break;
                if (s.toLowerCase().equals("n")) {System.out.println("Goodbye " + name); return;}
                System.out.println("I didn't understand, please answer (y or n)");
            }
        }

    }

    public static void doGuessingGame(String name)
    {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int guesses_remaining = 6;
        int number = r.nextInt(20) + 1;
        System.out.println(MessageFormat.format(PROMPT2,name));
        System.out.println(GUESS);
        while (scanner.hasNext())
        {
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess < 1 || guess > 20 ) System.out.println(NAN);
                else {
                    if (guess == number) {System.out.println(MessageFormat.format(SUCCESS,name,7-guesses_remaining)); return; }
                    else {
                        guesses_remaining--;
                        if (guesses_remaining == 0) {System.out.println(MessageFormat.format(FAILURE,name,number)); return;}
                        else
                        {
                            if (guess > number) {System.out.println(MessageFormat.format(TOOHIGH,guesses_remaining));}
                            else {System.out.println(MessageFormat.format(TOOLOW,guesses_remaining));}
                        }
                    }

                }
            }
            else {
                System.out.println(NAN);
                scanner.next();
            }
            System.out.println(GUESS);
        }
    }
}
