import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MemoryGame {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        int lenOfArray = 7; // amount of nums that will be shown
        int numRange = 5; // range of nums (if its 10, then the range will be 1-10)
        int showSecDelay = 4; // time needed to memorize then nums (avoiding hardcode) - in seconds
        int countOfBlankLines = 10; // terminal clear

        ArrayList<Integer> randomNumberArrList = new ArrayList<Integer>();
        ArrayList<Integer> guessesArrList = new ArrayList<Integer>();

        int rightAnswerCount = 0;

        // create random numbers
        InitNums(lenOfArray, randomNumberArrList, numRange, random);

        // show the numbers and add delay
        ShowNumbers(showSecDelay, randomNumberArrList);
        Thread.sleep(showSecDelay * 1000);

        // clear terminal
        TerminalClear(countOfBlankLines);

        // user input
        guessesArrList = GenerateInput(sc, lenOfArray, guessesArrList);

        // match and check
        rightAnswerCount = MatchResults(lenOfArray, randomNumberArrList, guessesArrList, rightAnswerCount); 

        // result
        ShowResults(randomNumberArrList, guessesArrList);

        // stats
        StatMaker(rightAnswerCount, lenOfArray);

        sc.close();
    }

    public static void InitNums(int count, ArrayList<Integer> randomNumbers, int range, Random r) {
        for (int i = 0; i < count; i++) {
            randomNumbers.add(r.nextInt(range) + 1); // added +1 in order not to get 0 value
        }
    }

    public static void ShowNumbers(int delay, ArrayList<Integer> arr) {
        System.out.println("Try to remember following numbers. The numbers will be shown for " + delay + " seconds.");
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    public static void TerminalClear(int lineCount) {
        for (int i = 0; i < lineCount; i++) {
            System.out.println();
        }
    }

    public static ArrayList<Integer> GenerateInput(Scanner sc, int count, ArrayList<Integer> arr) {
        for (int i = 0; i < count; i++) {
            System.out.println("Type number " + (i + 1) + ":");
            arr.add(Integer.parseInt(sc.nextLine()));
        }
        return arr;
    }

    public static int MatchResults(int arrLen, ArrayList<Integer> arrL1, ArrayList<Integer> arrL2, int intToIncrement) {
        for (int i = 0; i < arrLen; i++) {
            if (arrL1.get(i) == arrL2.get(i)) {
                intToIncrement++;
                System.out.println(intToIncrement);

            }
        }
        return intToIncrement;
    }

    public static void ShowResults(ArrayList<Integer> arrList1, ArrayList<Integer> arrList2) {
        System.out.println("The numbers were:");
        for (Integer num : arrList1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Your guesses were:");
        for (Integer num : arrList2) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void StatMaker(int rightAnsCount, int arrLen) {
        float percentage = (float) rightAnsCount * 100 / arrLen;
        String formattedPercentage = String.format("%.2f", percentage); // to shorten decimals
        System.out.println("You have got " + rightAnsCount + " numbers right out of " + arrLen + ".");
        System.out.println("The percentage of correct answers is %" + formattedPercentage + ".");
    }
}