package hw4;

/**
 * The MenuItem interface represents a menu item in a restaurant.
 * It provides methods to get the name, amount, and time required to prepare the menu item,
 * as well as methods to convert the menu item to a string and to compare it with another object.
 */
public interface MenuItem {
    /**
     * Returns the name of the menu item.
     * @return A string representing the name of the menu item.
     */
    String getName();

    /**
     * Returns the amount of the menu item in an order.
     * @return An integer representing the amount of the menu item in an order.
     */
    int getAmount();

    /**
     * Returns the time required to prepare the menu item.
     * @return An integer representing the time required to prepare the menu item.
     */
    int getTimeRequired();

    /**
     * Returns a string representation of the menu item.
     * @return A string representation of the menu item.
     */
    @Override
    String toString();

    /**
     * Compares this MenuItem object to the specified object.
     * The result is true if and only if the argument is not null and is a MenuItem object that represents the same amount of the menu item as this object.
     * @param obj The object to compare this MenuItem against.
     * @return A boolean indicating whether this MenuItem is equal to the specified object.
     */
    @Override
    boolean equals(Object obj);
}