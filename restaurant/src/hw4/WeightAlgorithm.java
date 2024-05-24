package hw4;

import java.util.*;

/**
 * The WeightAlgorithm class represents the Weighted algorithm for processing orders.
 * It extends the AbstractAlgorithm class.
 * It uses a PriorityQueue to keep the orders with the highest weight at the top.
 * It also uses a Set to ensure that the same order is not added to the queue multiple times.
 * The weight of an order is calculated based on the current time and the order's properties.
 */
public class WeightAlgorithm extends AbstractAlgorithm {
    // PriorityQueue ensures that the order with the highest weight is always at the top.
    // This allows us to efficiently process orders in a weighted manner.
    private PriorityQueue<Order> pendingOrders = new PriorityQueue<>(Comparator.comparingDouble(order -> calculateWeight((Order) order, 0)).reversed());

    // Set is used to keep track of the orders that are already in the PriorityQueue.
    // This prevents the same order from being added to the queue multiple times.
    private Set<Order> pendingOrdersSet = new HashSet<>();

    /**
     * Processes the orders based on the Weighted algorithm.
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
        if (isOrderNull(currentOrder)) {
            return;
        }
        if (!pendingOrders.isEmpty()) {
            // Recalculate the weights of the pending orders based on the current time
            List<Order> pendingOrdersCopy = new ArrayList<>(pendingOrders);
            pendingOrders.clear();
            pendingOrders = new PriorityQueue<>(Comparator.comparingDouble(order -> calculateWeight((Order) order, tnow)).reversed());
            pendingOrders.addAll(pendingOrdersCopy);
            // If the weight of the first pending order is greater than the weight of the current order, make the first pending order the current order
            if(calculateWeight(pendingOrders.peek(), tnow) > calculateWeight(currentOrder, tnow)) {
                if (!pendingOrdersSet.contains(currentOrder)) {
                    pendingOrders.add(currentOrder);
                    pendingOrdersSet.add(currentOrder);
                }
                currentOrder = pendingOrders.poll();
            }
        }
        if (hasEnoughSpaceAndPans(ordersCurrentlyProcessed, grill, currentOrder)) {
            if (currentOrder != null && tnow + calculateTimeRequired(currentOrder) > 360) {
                return;
            }
            addOrderToGrill(grill, currentOrder, tnow);
            addOrderToProcessingList(ordersCurrentlyProcessed, currentOrder);
        } else {
            if (!pendingOrdersSet.contains(currentOrder)) {
                pendingOrders.add(currentOrder);
                pendingOrdersSet.add(currentOrder);
            }
        }
    }
}