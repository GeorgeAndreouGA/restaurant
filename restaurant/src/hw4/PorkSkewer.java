package hw4;

/**
 * The PorkSkewer class represents a pork skewer menu item in a restaurant.
 * It implements the MenuItem interface.
 */
public class PorkSkewer implements MenuItem {
    // The time required to prepare the pork skewer. It is a random value between 20 and 25.
    private final int timereq = (int)((Math.random()*6) + 20);
    // The amount of pork skewers in an order.
    private final int amount;

    /**
     * Constructs a new PorkSkewer object with the specified amount.
     * @param amount The amount of pork skewers in an order.
     */
    public PorkSkewer(int amount) {
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
        return "PorkSkewer";
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
        return "PorkSkewer: " + amount;
    }

    /**
     * Compares this PorkSkewer object to the specified object.
     * The result is true if and only if the argument is not null and is a PorkSkewer object that represents the same amount of pork skewers as this object.
     * @param obj The object to compare this PorkSkewer against.
     * @return A boolean indicating whether this PorkSkewer is equal to the specified object.
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
        PorkSkewer other = (PorkSkewer) obj;
        return amount == other.amount;
    }
}