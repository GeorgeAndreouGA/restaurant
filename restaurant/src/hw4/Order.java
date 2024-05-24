package hw4;

import java.util.List;

/**
 * The Order class is an abstract class that represents an order in a restaurant.
 * It provides methods to add a menu item to the order, get the order execution time, convert the order to a string, and compare it with another object.
 * It also provides a method to get the amount of each menu item in the order.
 */
public abstract class Order {
    // The ID of the order.
    protected int orderId;
    // The time the order was placed.
    protected int orderTime;
    // The time the order is expected to be picked up.
    protected int pickUpTime;
    // The list of menu items in the order.
    protected List<MenuItem> items;
    // The order execution time. It is initialized to the order time.
    protected int orderExecution;

    /**
     * Constructs a new Order object with the specified order ID, order time, pick-up time, and list of menu items.
     * @param orderId The ID of the order.
     * @param orderTime The time the order was placed.
     * @param pickUpTime The time the order is expected to be picked up.
     * @param items The list of menu items in the order.
     */
    public Order(int orderId, int orderTime, int pickUpTime, List<MenuItem> items){
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.pickUpTime = pickUpTime;
        this.items = items;
        this.orderExecution = orderTime;
    }

    /**
     * Adds a menu item to the order.
     * @param item The menu item to be added to the order.
     */
    public abstract void addMenuItem(MenuItem item);

    /**
     * Returns the order execution time.
     * @return An integer representing the order execution time.
     */
    public abstract int getOrderExecution();

    /**
     * Returns a string representation of the order.
     * @return A string representation of the order.
     */
    @Override
    public abstract String toString();

    /**
     * Returns a string representing the amount of each menu item in the order.
     * @return A string representing the amount of each menu item in the order.
     */
    public String getMenuItemAmount(){
        StringBuilder result = new StringBuilder();
        for(MenuItem item : items){
            result.append(item.getAmount()).append(" ");
        }
        return result.toString();
    }

    /**
     * Compares this Order object to the specified object.
     * The result is true if and only if the argument is not null and is an Order object that represents the same order ID, order time, pick-up time, and list of menu items as this object.
     * @param obj The object to compare this Order against.
     * @return A boolean indicating whether this Order is equal to the specified object.
     */
    @Override
    public abstract boolean equals(Object obj);
}