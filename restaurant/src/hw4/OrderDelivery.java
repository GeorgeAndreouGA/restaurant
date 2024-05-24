package hw4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
/**
 * Manages the delivery process of orders using different algorithms.
 */
public class OrderDelivery {
    private static Algorithm algorithm;
    private static  int evxarisimeneoiPel=0;
    private static int MesiApoklisi=0;
    private static final HashMap <Order, Integer> finishedOrders= new HashMap<>();
    private static int allOrders;
    private static final int GRILL_CLOSE_TIME = 360;

    /**
     * Entry point of the program.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        long  timeMillis = System.currentTimeMillis();
        if (args.length != 8)
            throw new IllegalArgumentException("Please provide 8 arguments");

        List<Order> orders = readFile();
        allOrders = orders.size();
        Grill grill = new Grill(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));
        List<Order> ordersCurrentlyProcessed = new ArrayList<>();
        int startTime = grill.getGrillTime()-30;
        if(startTime<0)
        	startTime = 0;
        ProgressBar pb = new ProgressBar(360 - startTime);
        int algonum= Integer.parseInt(args[7]);
        for (int i = startTime; i < GRILL_CLOSE_TIME; i++) {
            pb.update();
            processOrders(ordersCurrentlyProcessed, i);
            processNewOrders(orders, ordersCurrentlyProcessed, grill, i,algonum);
        }
        System.out.println("\nFinished processing orders");
        System.out.println("Total time taken: " + (System.currentTimeMillis() - timeMillis) + "ms");
        outputFile(finishedOrders);

    }
    /**
     * Processes the orders that are currently being prepared.
     * 
     * @param ordersCurrentlyProcessed The orders currently being prepared.
     * @param currentTime              The current time.
     */
    private static void processOrders(List<Order> ordersCurrentlyProcessed, int currentTime) {
        ordersCurrentlyProcessed.removeIf(order -> {
            if (algorithm.isOrderRemovable(order, currentTime)) {
                finishedOrders.put(order, currentTime);
                evxarisimeneoiPel += currentTime <= order.pickUpTime ? 1 : 0;
                MesiApoklisi += currentTime > order.pickUpTime ? Math.abs(order.pickUpTime - currentTime) : 0;
                return true;
            }
            return false;
        });
    }
    /**
     * Processes new orders that are received.
     * 
     * @param orders                  The list of all orders.
     * @param ordersCurrentlyProcessed The orders currently being prepared.
     * @param grill                   The grill object.
     * @param currentTime             The current time.
     * @param algorithmNumber         The number representing the selected algorithm.
     */
    private static void processNewOrders(List<Order> orders, List<Order> ordersCurrentlyProcessed, Grill grill, int currentTime, int algorithmNumber) {
        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            if (order.orderTime <= currentTime) {
                selectAlgorithm(algorithmNumber, ordersCurrentlyProcessed, grill, currentTime, order);
            }
            // check if current order is in the pending orders list and if yes then remove it from the orders list
            if (ordersCurrentlyProcessed.contains(order)) {
                orderIterator.remove();
            }
        }
    }

    /**
     * Reads the orders from the file.
     * 
     * @return A list of orders read from the file.
     */
    public static List<Order> readFile() {
        List<Order> orders = new ArrayList<>();
        try (Scanner get = new Scanner(new File("/home/george/Documents/orders.txt"))) {
            ArrayList<Integer> makeAnOrder = new ArrayList<>();
            while (get.hasNextInt()) {
                makeAnOrder.add(get.nextInt());
                if (makeAnOrder.size() == 8) {
                    orders.add(OrderFactory.createOrder(makeAnOrder.get(0), makeAnOrder.get(1), makeAnOrder.get(2), makeAnOrder.get(3), makeAnOrder.get(4), makeAnOrder.get(5), makeAnOrder.get(6), makeAnOrder.get(7)));
                    makeAnOrder.clear();
                }
            }
            if (!makeAnOrder.isEmpty()) {
                orders.add(OrderFactory.createOrder(makeAnOrder.get(0), makeAnOrder.get(1), makeAnOrder.get(2), makeAnOrder.get(3), makeAnOrder.get(4), makeAnOrder.get(5), makeAnOrder.get(6), makeAnOrder.get(7)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            System.exit(0);
        }
        return orders;
    }
    /**
     * Writes the processed orders to the output file.
     * 
     * @param orders The processed orders.
     */
    public static void outputFile(HashMap<Order, Integer> orders) {
        String fileName = "deliveries.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            orders = Sort.HashSort(orders);
            double mo = (double) MesiApoklisi / orders.size();
            evxarisimeneoiPel = calculateHappyCustomers(orders);
            writer.write(allOrders+" ");
            writer.write(String.format("%.2f", mo));
            writer.write(" "+evxarisimeneoiPel);
            writer.newLine();
            for(Order order : orders.keySet()) {
                int pites = 0;
                int fries = 0;
                for(MenuItem item : order.items)
                    if (!(item instanceof Fries))
                        pites += item.getAmount();
                    else
                        fries += item.getAmount();
                writer.write(order.orderId + " " + order.orderTime + " " + orders.get(order) +" "+ Math.abs(orders.get(order)- order.pickUpTime) + " " + pites + " " + fries );
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }
    /**
     * Selects the appropriate algorithm based on the algorithm number.
     * 
     * @param algonum                The number representing the selected algorithm.
     * @param orders                 The orders currently being prepared.
     * @param grill                  The grill object.
     * @param currentTime            The current time.
     * @param currentOrder           The current order being processed.
     */
    public static void selectAlgorithm(int algonum, List<Order> orders, Grill grill, int currentTime, Order currentOrder) {
    	if (algorithm == null)
            switch (algonum) {
            case 1:
                algorithm = new FCFSAlgorithm();
                break;
            case 2:
                algorithm = new STSAlgorithm();
                break;
            case 3:
            	algorithm = new WeightAlgorithm();
            	break;
            default:
                throw new IllegalArgumentException("Please provide a valid algorithm number");
            }
        algorithm.process(orders, grill, currentTime, currentOrder);
    }
    /**
     * Calculates the number of happy customers among the processed orders.
     * 
     * @param orders The processed orders.
     * @return The number of happy customers.
     */
    private static int calculateHappyCustomers(HashMap<Order, Integer> orders) {
        int happyCustomers = 0;
        for (Order order : orders.keySet()) {
            if (orders.get(order) <= order.pickUpTime) {
                happyCustomers++;
            }
        }
        return happyCustomers;
    }
}


