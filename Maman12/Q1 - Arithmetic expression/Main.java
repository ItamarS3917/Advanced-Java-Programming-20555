import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int toDouble = 1000;
        final int NUM_OF_ELEMENT = 15;
        ArrayList<Expression> arrayList = new ArrayList<>();
        Random rand = new Random();

        int randRange, index, i;
        for (index = 0; index < NUM_OF_ELEMENT; index++) {

            randRange = rand.nextInt(10); //random integers in range 0 to 10
            if ((index < 2 || randRange <= 3))
                arrayList.add(new AtomicExpression(Math.round(rand.nextDouble() * toDouble)));
            else if (randRange > 3 && randRange <= 6)
                arrayList.add(new AdditionExpression(arrayList.get(rand.nextInt(index)), arrayList.get(rand.nextInt(index))));
            else
                arrayList.add(new SubtractionExpression(arrayList.get(rand.nextInt(index)), arrayList.get(rand.nextInt(index))));

            System.out.println("The expression in index " + index + " is: " + arrayList.get(index) + "\n The calculation of the expression is: "
                    + arrayList.get(index).calculate());

            // Check if there are indeed equals expressions
            for (i = 0; i < arrayList.size(); i++)
                if (arrayList.get(index).equals(arrayList.get(i)) && index != i)
                    System.out.println(" Found equal expression! This expression equals the Expression in index: " + i + " which is: " + arrayList.get(i)
                            + " = " + arrayList.get(index).calculate());
            System.out.println(" --------------------------------------------------------- ");
        }
    }
}
