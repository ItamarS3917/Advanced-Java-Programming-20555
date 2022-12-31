import java.util.Iterator;

public class MainString {
    public static void main(String[] args) {
        final int maxNumOfPriorities = 10;
        PriorityQueue<String> obj = new PriorityQueue<>(maxNumOfPriorities);

        obj.add("duck", 10);
        obj.add("cat", 6);
        obj.add("mouse", 1);
        obj.add("cow", 0);
        obj.add("ant", 5);
        obj.add("donkey", 9);
        obj.add("giraffe", 7);
        obj.add("monkey", 6);
        obj.add("fox", 3);
        System.out.println("--------- Priority queue after adding elements --------");
        System.out.println("Priority queue size: " + obj.getSize());
        printQueue(obj);

        // Insert organs with different priorities
        obj.add("dog", 1);
        obj.add("cockroach", 9);
        obj.add("parrot", 5);
        obj.add("owl", 2);
        obj.add("snake", 1);
        obj.add("rabbit", 0);

        System.out.println("--------- Priority queue after adding elements --------");
        System.out.println("Priority queue size: " + obj.getSize());
        printQueue(obj);

        /* The result of the priority queue after adding the strings:
                   0              1            2     3        5             6            7                9
           [cow, rabbit | mouse, dog, snake | owl | fox | ant, parrot | cat, monkey | giraffe | duck, donkey, cockroach] */

        // Remove strings with different priorities
        obj.remove("cow"); // true
        obj.remove("donkey"); // true
        obj.remove("donkey"); // false
        obj.remove("duck"); // true
        obj.remove("cow"); // false

        System.out.println("-------- Queue priorities after removing data ---------");
        System.out.println("Priority queue size: " + obj.getSize());
        printQueue(obj);
    }

    public static void printQueue(PriorityQueue<String> queue) {
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            String element = it.next();
            System.out.println(element);
        }
    }
}
