package hw4;

/**
 * The Fries class represents a menu item in a restaurant.
 * It implements the MenuItem interface.
 */
public class Fries implements MenuItem {
    // The time required to prepare the fries.
    private final int timereq = 20;
    // The amount of fries in an order.
    private final int amount;

    /**
     * Constructs a new Fries object with the specified amount.
     * @param amount The amount of fries in an order.
     */
    public Fries(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the name of the menu item.
     * @return A string representing the name of the menu item.
     */
    @Override
    public String getName() {
        return "Fries";
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
        return "Fries: " + amount;
    }

    /**
     * Compares this Fries object to the specified object.
     * The result is true if and only if the argument is not null and is a Fries object that represents the same amount of fries as this object.
     * @param obj The object to compare this Fries against.
     * @return A boolean indicating whether this Fries is equal to the specified object.
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
        Fries other = (Fries) obj;
        return amount == other.amount;
    }
}