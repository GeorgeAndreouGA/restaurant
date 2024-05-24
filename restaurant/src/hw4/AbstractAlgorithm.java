package hw4;


import java.util.List;
/**
 * The AbstractAlgorithm class provides a template for implementing different order processing algorithms.
 * It implements the Algorithm interface and provides default implementations for some of the methods.
 */
public abstract class AbstractAlgorithm implements Algorithm {

    /**
     * Processes the orders based on the implemented algorithm.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param grill The grill object representing the grill.
     * @param tnow The current time.
     * @param currentOrder The current order to be processed.
     */
    @Override
    public abstract void process(List<Order> ordersCurrentlyProcessed, Grill grill, int tnow, Order currentOrder);

    /**
     * Calculates the space required for the orders currently being processed on the grill.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param grill The grill object representing the grill.
     * @return An integer representing the space required for the orders currently being processed on the grill.
     */
    @Override
    public int calculateSpaceRequired(List<Order> ordersCurrentlyProcessed, Grill grill) {
        int spaceRequired = 0;
        for (Order order : ordersCurrentlyProcessed) {
            for (int i = 0; i < order.items.size(); i++) {
                MenuItem item = order.items.get(i);
                if (item instanceof MixSkewer) {
                    spaceRequired += (item.getAmount() * grill.getPittaSpace()) + (item.getAmount() * grill.getSeftaliaSpace())+ (item.getAmount() * grill.getSouvlakiSpace());
                } else if (item instanceof PorkSkewer|| item instanceof ChickenSkewer) {
                    spaceRequired += ((item.getAmount() * (2 * grill.getSouvlakiSpace())) + (item.getAmount() * grill.getPittaSpace()));
                } else  if (item instanceof SheftaliaSkewer) {
                    spaceRequired += ((item.getAmount() * (2 * grill.getSeftaliaSpace())) + (item.getAmount() * grill.getPittaSpace()));
                }
            }
        }
        return spaceRequired;
    }
    @Override
    public int calculatePansRequired(List<Order> ordersCurrentlyProcessed, Grill grill) {
        int totalAmount= 0;
        for (Order order : ordersCurrentlyProcessed) {
            for (int i = 0; i < order.items.size(); i++) {
                MenuItem item = order.items.get(i);
                if (item instanceof Fries) {
                    totalAmount += item.getAmount();
                }
            }
        }
        return (int)Math.ceil((double)totalAmount / grill.getPanSpace());
    }
    public boolean isOrderRemovable(Order order, int tnow){
        return order.orderExecution + calculateTimeRequired(order) <= tnow;
    }

    /**
     * Calculates the time required to process an order.
     * @param order The order to be processed.
     * @return An integer representing the time required to process the order.
     */
    @Override
    public int calculateTimeRequired(Order order) {
        int timeRequired = 0;
        for (int i = 0; i < order.items.size(); i++) {
            MenuItem item = order.items.get(i);
            if (timeRequired < item.getTimeRequired()) {
                timeRequired = item.getTimeRequired();
            }
        }
        return timeRequired;
    }
    public double calculateWeight(Order order, int currentTime){
        double weight;
        weight = (double) (calculateTimeRequired(order)- (order.pickUpTime - currentTime))/calculateTimeRequired(order);
        return weight;
    }

    /**
     * Checks if the current order is null.
     * @param currentOrder The current order to be checked.
     * @return A boolean indicating whether the current order is null.
     */
    protected boolean isOrderNull(Order currentOrder) {
        return currentOrder == null;
    }

    /**
     * Checks if there is enough space and pans for the current order.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param grill The grill object representing the grill.
     * @param currentOrder The current order to be checked.
     * @return A boolean indicating whether there is enough space and pans for the current order.
     */
    protected boolean hasEnoughSpaceAndPans(List<Order> ordersCurrentlyProcessed, Grill grill, Order currentOrder) {
        return calculateSpaceRequired(ordersCurrentlyProcessed, grill) + calculateSpaceRequired(List.of(currentOrder), grill) <= grill.getGrillSpace()
                && calculatePansRequired(ordersCurrentlyProcessed, grill) + calculatePansRequired(List.of(currentOrder), grill) <= grill.getMaxPanNum();
    }

    /**
     * Adds the current order to the grill.
     * @param grill The grill object representing the grill.
     * @param currentOrder The current order to be added to the grill.
     * @param tnow The current time.
     */
    protected void addOrderToGrill(Grill grill, Order currentOrder, int tnow) {
        grill.setPanNum(grill.getPanNum() + calculatePansRequired(List.of(currentOrder), grill));
        currentOrder.orderExecution = tnow;
    }

    /**
     * Adds the current order to the list of orders currently being processed.
     * @param ordersCurrentlyProcessed The list of orders currently being processed.
     * @param currentOrder The current order to be added to the list of orders currently being processed.
     */
    protected void addOrderToProcessingList(List<Order> ordersCurrentlyProcessed, Order currentOrder) {
        ordersCurrentlyProcessed.add(currentOrder);
    }
}