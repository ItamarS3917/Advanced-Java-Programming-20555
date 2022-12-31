import java.util.Iterator;

public class MainCustomerInquiries {
    public static void main(String[] args) {
        final int maxNumOfPriorities = 10;

        PriorityQueue<CustomerInquiries> obj = new PriorityQueue<>(maxNumOfPriorities);

        CustomerInquiries firstPerson = new CustomerInquiries("Ayala", 324843952, "The package arrived open");
        CustomerInquiries secondPerson = new CustomerInquiries("Yael", 324843953, "The bottle arrived broken");
        CustomerInquiries thirdPerson = new CustomerInquiries("Chen", 324843955, "The milk arrived spoiled");
        CustomerInquiries fourthPerson = new CustomerInquiries("Dan", 333843956, "The bottle arrived broken");
        CustomerInquiries fifthPerson = new CustomerInquiries("Adi", 324843957, "The package arrived open");
        CustomerInquiries sixthPerson = new CustomerInquiries("Dan", 333843958, "The milk arrived spoiled");

        obj.add(fifthPerson, 1);
        obj.add(thirdPerson, 3);
        obj.add(secondPerson, 0);
        obj.add(firstPerson, 2);
        obj.add(sixthPerson, 0);

        System.out.println("--------- Priority queue after adding elements --------");
        System.out.println("Priority queue size: " + obj.getSize());
        printQueue(obj);
        System.out.println("----------------------------------------------------------");

        /*----contains----*/
        System.out.println(obj.contains(secondPerson)); // The correct answer is true
        System.out.println(obj.contains(thirdPerson)); // The correct answer is true
        System.out.println(obj.contains(fourthPerson)); // The correct answer is false
        System.out.println(obj.contains(thirdPerson)); // The correct answer is true

        /*----remove----*/
        obj.remove(firstPerson);
        obj.remove(thirdPerson);
        obj.remove(sixthPerson);

        System.out.println("--------- Priority queue after removing elements --------");
        System.out.println("Priority queue size: " + obj.getSize());
        printQueue(obj);
        System.out.println("----------------------------------------------------------");


        System.out.println(obj.contains(fourthPerson)); // The correct answer is false
        System.out.println(obj.contains(thirdPerson)); // The correct answer is false
        System.out.println(obj.contains(sixthPerson)); // The correct answer is false
        System.out.println(obj.contains(secondPerson)); // The correct answer is true
        System.out.println("----------------------------------------------------------");


        /*----poll----*/
        System.out.println(obj.poll().toString());
    }

    public static void printQueue(PriorityQueue<CustomerInquiries> queue) {
        Iterator<CustomerInquiries> it = queue.iterator();
        while (it.hasNext()) {
            CustomerInquiries element = it.next();
            System.out.println(element);
        }
    }
}
