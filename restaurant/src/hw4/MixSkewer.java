package hw4;

/**
 * The MixSkewer class represents a mixed skewer menu item in a restaurant.
 * It implements the MenuItem interface.
 */
public class MixSkewer implements MenuItem {
    // The time required to prepare the mixed skewer.
    private  final int timereq = 25;
    // The amount of mixed skewers in an order.
    private final int amount;

    /**
     * Constructs a new MixSkewer object with the specified amount.
     * @param amount The amount of mixed skewers in an order.
     */
    public MixSkewer(int amount) {
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
        return "MixSkewer";
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
        return "MixSkewer: " + amount;
    }

    /**
     * Compares this MixSkewer object to the specified object.
     * The result is true if and only if the argument is not null and is a MixSkewer object that represents the same amount of mixed skewers as this object.
     * @param obj The object to compare this MixSkewer against.
     * @return A boolean indicating whether this MixSkewer is equal to the specified object.
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
        MixSkewer other = (MixSkewer) obj;
        return amount == other.amount;
    }
}