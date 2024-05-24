package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * The FCFSAlgorithm class represents the First-Come-First-Serve algorithm for processing orders.
 * It extends the AbstractAlgorithm class.
 */
public class FCFSAlgorithm  extends AbstractAlgorithm{

    /**
     * Processes the orders based on the First-Come-First-Serve algorithm.
     * If the current order is null or there is not enough space and pans for the current order, the method returns.
     * If there is enough space and pans for the current order and the grill is not near closing time, the current order is added to the grill and the processing list.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param grill The grill object representing the grill.
     * @param tnow The current time.
     * @param currentOrder The current order to be processed.
     */
    @Override
    public void process(List<Order> ordersCurrentlyProcessed, Grill grill, int tnow, Order currentOrder) {
        // Create a copy of the list of orders currently being processed
        // also used to avoid concurrent modification exception
        List<Order> ordersCurrentlyProcessedCopy = new ArrayList<>(ordersCurrentlyProcessed);

        // If the current order is null, return
        if (isOrderNull(currentOrder)) {
            return;
        }

        // If there is not enough space and pans for the current order, return
        if (!hasEnoughSpaceAndPans(ordersCurrentlyProcessed, grill, currentOrder)) {
            return;
        }

        // If there is enough space and pans for the current order, add the current order to the grill and the processing list
        if (hasEnoughSpaceAndPans(ordersCurrentlyProcessed, grill, currentOrder)) {
            // If the grill is near closing time, return
            if (tnow + calculateTimeRequired(currentOrder) > 360) {
                return;
            }

            // Add the pans used currently plus the ones used by the current order
            addOrderToGrill(grill, currentOrder, tnow);
            addOrderToProcessingList(ordersCurrentlyProcessedCopy, currentOrder);
        }

        // Clear the list of orders currently being processed and add all elements from the copy
        ordersCurrentlyProcessed.clear();
        ordersCurrentlyProcessed.addAll(ordersCurrentlyProcessedCopy);
    }
}