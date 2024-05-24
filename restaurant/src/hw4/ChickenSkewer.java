package hw4;

/**
 * The ChickenSkewer class represents a specific type of menu item in a restaurant.
 * It implements the MenuItem interface and provides methods to get the name, amount, and time required to prepare the menu item,
 * as well as methods to convert the menu item to a string and to compare it with another object.
 */
public class ChickenSkewer implements MenuItem {
    // The time required to prepare the menu item. It is a random number between 15 and 20.
    private final int timereq = (int)((Math.random()*6) + 15);
    // The amount of the menu item in an order.
    private final int amount;

    /**
     * Constructs a new ChickenSkewer object with the specified amount.
     * @param amount The amount of the menu item in an order.
     */
    public ChickenSkewer(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the name of the menu item.
     * @return A string representing the name of the menu item.
     */
    @Override
    public String getName() {
        return "ChickenSkewer";
    }

    /**
     * Returns the time required to prepare the menu item.
     * @return An integer representing the time required to prepare the menu item.
     */
    @Override
    public int getTimeRequired() {
        return timereq;
    }

    /**
     * Returns the amount of the menu item in an order.
     * @return An integer representing the amount of the menu item in an order.
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Returns a string representation of the menu item.
     * @return A string representation of the menu item.
     */
    @Override
    public String toString() {
        return "ChickenSkewer: " + amount;
    }

    /**
     * Compares this ChickenSkewer object to the specified object.
     * The result is true if and only if the argument is not null and is a ChickenSkewer object that represents the same amount of the menu item as this object.
     * @param obj The object to compare this ChickenSkewer against.
     * @return A boolean indicating whether this ChickenSkewer is equal to the specified object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ChickenSkewer other = (ChickenSkewer) obj;
        return amount == other.amount;
    }
}