import java.util.Comparator;
import java.util.PriorityQueue;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    public Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return "Ticket: " + name + " | Urgency: " + urgency;
    }
}

public class Main {
    public static void main(String[] args) {


        PriorityQueue<Ticket> ticketQueue = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

      
        ticketQueue.offer(new Ticket("Printer", 3, 1));
        ticketQueue.offer(new Ticket("Network", 1, 2));
        ticketQueue.offer(new Ticket("Login", 2, 3));

    
        System.out.println("Help-Desk Ticket Queue");
        System.out.println("----------------------");

        while (!ticketQueue.isEmpty()) {
            Ticket ticket = ticketQueue.poll();
            System.out.println(ticket);
        }

        System.out.println("----------------------");
        System.out.println("All tickets processed.");
    }
}