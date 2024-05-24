package hw4;

import java.util.*;

/**
 * The STSAlgorithm class represents the Shortest Time Served algorithm for processing orders.
 * It extends the AbstractAlgorithm class.
 * It uses a PriorityQueue to keep the orders with the shortest processing time at the top.
 * It also uses a Set to ensure that the same order is not added to the queue multiple times.
 */
public class STSAlgorithm extends AbstractAlgorithm{
    // PriorityQueue ensures that the order with the shortest processing time is always at the top.
    // This allows us to efficiently process orders in the shortest time first manner.
    private PriorityQueue<Order> pendingOrders = new PriorityQueue<>(Comparator.comparingInt(this::calculateTimeRequired));

    // Set is used to keep track of the orders that are already in the PriorityQueue.
    // This prevents the same order from being added to the queue multiple times.
    private Set<Order> pendingOrdersSet = new HashSet<>();

    /**
     * Processes the orders based on the Shortest Time Served algorithm.
     * If the current order is null, the method returns.
     * If there is enough space and pans for the current order and the grill is not near closing time, the current order is added to the grill and the processing list.
     * If there is not enough space and pans for the current order, the current order is added to the pending orders queue.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param grill The grill object representing the grill.
     * @param tnow The current time.
     * @param currentOrder The current order to be processed.
     */
    @Override
    public void process(List<Order> ordersCurrentlyProcessed, Grill grill, int tnow, Order currentOrder) {
        List<Order> ordersCurrentlyProcessedCopy = new ArrayList<>(ordersCurrentlyProcessed);
        if (isOrderNull(currentOrder)) {
            return;
        }
        // check if pendingOrders is not empty
        if (!pendingOrders.isEmpty()) {
            // check if the current order can be processed faster than the first pending order
            if(calculateTimeRequired(pendingOrders.peek()) > calculateTimeRequired(currentOrder)) {
                // if yes the make the currentOrder the first in the line from the pendingOrders list and add the currentOrder to pendingOrders
                pendingOrders.add(currentOrder);
                pendingOrdersSet.add(currentOrder);
                currentOrder = pendingOrders.poll();
            }
            if (!pendingOrdersSet.contains(currentOrder)) {
                pendingOrders.add(currentOrder);
                pendingOrdersSet.add(currentOrder);
            }
            currentOrder = pendingOrders.poll();
        }
        if (hasEnoughSpaceAndPans(ordersCurrentlyProcessed, grill, currentOrder)) {
            if (currentOrder != null && tnow + calculateTimeRequired(currentOrder) > 360) {
                return;
            }
            addOrderToGrill(grill, currentOrder, tnow);
            addOrderToProcessingList(ordersCurrentlyProcessedCopy, currentOrder);
        } else {
            pendingOrders.add(currentOrder);
            pendingOrdersSet.add(currentOrder);
        }
        ordersCurrentlyProcessed.clear();
        ordersCurrentlyProcessed.addAll(ordersCurrentlyProcessedCopy);
    }
}