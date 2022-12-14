
/*This is the logic department of the game, in this department there are methods for checking the correctness of the input, drawing a number,
 updating the history of stamps and vulnerabilities... these methods are called the sorter during the running of the program*/
import java.util.*;

public class GameLogic {
    private static final int LEN_NUM = 4;
    private static final int SIZE_ARRAY = 10;

    private int numToGuess;

    public GameLogic() {
        this.numToGuess = Integer.parseInt(randNumber());
    }

    public int getNum() {
        return numToGuess;
    }

    public void reset() { this.numToGuess = Integer.parseInt(randNumber());}

    //This method generates a 4-digit number without repetitions.
    public static String randNumber() {
        Random rand = new Random();
        int randNum, sum = 0, rangeNum = 1000;
        ;
        boolean[] temp = new boolean[SIZE_ARRAY];
        String sumFinal;

        for (int i = 0; i < LEN_NUM; i++) {
            randNum = rand.nextInt(9); //random integers in range 0 to 9
            if (temp[randNum] == true)
                while (temp[randNum] == true)
                    randNum = rand.nextInt(9); //random integers in range 0 to 9
            temp[randNum] = true;
            sum += randNum * rangeNum;
            rangeNum /= 10;

        }
        sumFinal = Integer.toString(sum);
        if (sumFinal.length() == 3)
            return "0" + sumFinal;
        return sumFinal;
    }

    //This method checks that the number entered by the user is correct.
    public static boolean checkInput(String num) {
        boolean[] temp = new boolean[SIZE_ARRAY];

        if (num.equals(" ") || num.equals(null) || num.length() != LEN_NUM)
            return false;

        if (num.matches("\\d+") != true) //Checking that the entered characters are numbers only.
            return false;

        for (int i = 0; i < num.length(); i++) //Checking that the number does not contain non-numeric characters.
        {
            if (temp[num.charAt(i) - '0'] == true) //Checking that there are indeed no duplicate numbers.
                return false;
            temp[num.charAt(i) - '0'] = true;
        }
        return true;
    }

    /*This method returns to the user the number of bulls he had and the number of cows he had.*/
    public String bullsAndCows(int num, int randNumber) {
        String input = Integer.toString(num);
        String randNum = Integer.toString(randNumber);
        int numOfBulls = 0, numOfCows = 0;
        for (int i = 0; i < LEN_NUM; i++) {
            if (input.charAt(i) == randNum.charAt(i))
                numOfBulls++;

            else
                for (int j = 0; j < LEN_NUM; j++)
                    if (input.charAt(i) == randNum.charAt(j))
                        numOfCows++;
        }
        return "num Of Bulls: " + numOfBulls + " num Of Cows: " + numOfCows;
    }
}

