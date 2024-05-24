package hw4;

import java.util.List;

/**
 * The ConcreteOrder class represents a specific type of order in a restaurant.
 * It extends the Order class and provides methods to add a menu item to the order, get the order execution time, convert the order to a string, and compare it with another object.
 */
public class ConcreteOrder extends Order{

    /**
     * Constructs a new ConcreteOrder object with the specified order ID, order time, pick-up time, and list of menu items.
     * @param orderId The ID of the order.
     * @param orderTime The time the order was placed.
     * @param pickUpTime The time the order is expected to be picked up.
     * @param items The list of menu items in the order.
     */
    public ConcreteOrder(int orderId, int orderTime, int pickUpTime, List<MenuItem> items) {
        super(orderId, orderTime, pickUpTime, items);
    }

    /**
     * Adds a menu item to the order.
     * @param item The menu item to be added to the order.
     */
    @Override
    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Returns the order execution time.
     * @return An integer representing the order execution time.
     */
    @Override
    public int getOrderExecution() {
        return orderExecution;
    }

    /**
     * Returns a string representation of the order.
     * @return A string representation of the order.
     */
    @Override
    public String toString() {
        return super.orderId + " " + super.orderTime + " " + super.pickUpTime + " " + getMenuItemAmount();
    }

    /**
     * Compares this ConcreteOrder object to the specified object.
     * The result is true if and only if the argument is not null and is a ConcreteOrder object that represents the same order ID, order time, pick-up time, and list of menu items as this object.
     * @param obj The object to compare this ConcreteOrder against.
     * @return A boolean indicating whether this ConcreteOrder is equal to the specified object.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConcreteOrder order)) {
            return false;
        }
        if(items.size() != order.items.size()){
            return false;
        }
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).equals(order.items.get(i))) {
                return false;
            }
        }
        return super.orderId == order.orderId && super.orderTime == order.orderTime && super.pickUpTime == order.pickUpTime;
    }
}