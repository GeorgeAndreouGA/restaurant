package hw4;

/**
 * The SheftaliaSkewer class represents a sheftalia skewer menu item in a restaurant.
 * It implements the MenuItem interface.
 */
public class SheftaliaSkewer implements MenuItem {
    // The amount of sheftalia skewers in an order.
    private final int amount;
    // The time required to prepare the sheftalia skewer. It is a constant value of 25.
    private final int timereq = 25;

    /**
     * Constructs a new SheftaliaSkewer object with the specified amount.
     * @param amount The amount of sheftalia skewers in an order.
     */
    public SheftaliaSkewer(int amount) {
        this.amount = amount;
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
     * Returns the name of the menu item.
     * @return A string representing the name of the menu item.
     */
    @Override
    public String getName() {
        return "SheftaliaSkewer";
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
        return "SheftaliaSkewer: " + amount;
    }

    /**
     * Compares this SheftaliaSkewer object to the specified object.
     * The result is true if and only if the argument is not null and is a SheftaliaSkewer object that represents the same amount of sheftalia skewers as this object.
     * @param obj The object to compare this SheftaliaSkewer against.
     * @return A boolean indicating whether this SheftaliaSkewer is equal to the specified object.
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
        SheftaliaSkewer other = (SheftaliaSkewer) obj;
        return amount == other.amount;
    }
}