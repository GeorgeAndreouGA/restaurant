package hw4;

import java.util.List;

/**
 * The Algorithm interface provides a contract for implementing different order processing algorithms.
 * It provides methods to process orders, calculate space required, calculate pans required, calculate time required, and check if an order is removable.
 */
public interface Algorithm {

    /**
     * Processes the orders based on the implemented algorithm.
     * @param pendingOrders The list of orders that are pending to be processed.
     * @param grill The grill object representing the grill.
     * @param tnow The current time.
     * @param currentOrder The current order to be processed.
     */
    void process(List<Order> pendingOrders, Grill grill, int tnow, Order currentOrder);

    /**
     * Calculates the space required for the pending orders on the grill.
     * @param pendingOrders The list of orders that are pending to be processed.
     * @param grill The grill object representing the grill.
     * @return An integer representing the space required for the pending orders on the grill.
     */
    int calculateSpaceRequired(List<Order> pendingOrders, Grill grill);

    /**
     * Calculates the pans required for the pending orders on the grill.
     * @param pendingOrders The list of orders that are pending to be processed.
     * @param grill The grill object representing the grill.
     * @return An integer representing the pans required for the pending orders on the grill.
     */
    int calculatePansRequired(List<Order> pendingOrders, Grill grill);

    /**
     * Calculates the time required to process an order.
     * @param order The order to be processed.
     * @return An integer representing the time required to process the order.
     */
    int calculateTimeRequired(Order order);

    /**
     * Checks if an order is removable from the grill.
     * @param order The order to be checked.
     * @param tnow The current time.
     * @return A boolean indicating whether the order is removable from the grill.
     */
    boolean isOrderRemovable(Order order, int tnow);
}