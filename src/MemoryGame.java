import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class MemoryGame {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int tempRandomNum;
        int tempAnswer;

        int numOfNumbers = 7; // amount of nums that will be shown
        int numRange = 5; // range of nums (if its 10, then the range will be 1-10)
        int showSecDelay = 4; // time needed to memorize then nums (avoiding hardcode) - in seconds
        int countOfBlankLines = 10; // terminal clear

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> guesses = new ArrayList<Integer>();

        int rightAnswerCount = 0;

        // create random numbers
        for (int i = 0; i < numOfNumbers; i++) {
            tempRandomNum = random.nextInt(numRange) + 1; // added +1 in order not to get 0 value
            nums.add(tempRandomNum);
        }
    
        // show the numbers and add delay
        System.out.println("Try to remember following numbers. The numbers will be shown for " + showSecDelay + " seconds.");
        for (Integer integer : nums) {
            System.out.print(integer + " ");
        }

        Thread.sleep(showSecDelay * 1000);

        // clear terminal
        for (int i = 0; i < countOfBlankLines; i++) {
            System.out.println();
        }

        // user input
        for (int i = 0; i < numOfNumbers; i++) {
            System.out.println("Type number " + (i+1) + ":");
            tempAnswer = Integer.parseInt(sc.nextLine());
            guesses.add(tempAnswer);
        }

        // match and check
        for (int i = 0; i < numOfNumbers; i++) {
            if (nums.get(i).equals(guesses.get(i))){
                rightAnswerCount++;
            }
        }

        //result
        System.out.println("The numbers were:");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Your guesses were:");
        for (Integer num : guesses) {
            System.out.print(num + " ");
        }
        System.out.println();

        //stats
        float percentage = (float) rightAnswerCount * 100 / numOfNumbers;
        String formattedPercentage = String.format("%.2f", percentage); // to shorten decimals
        System.out.println("You have got " + rightAnswerCount + " numbers right out of " + numOfNumbers + ".");
        System.out.println("The percentage of correct answers is %" + formattedPercentage + ".");

        sc.close(); 
    }
}
