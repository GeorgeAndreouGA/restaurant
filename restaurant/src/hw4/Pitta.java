package hw4;

/**
 * The Pitta class represents a pitta bread menu item in a restaurant.
 * It implements the MenuItem interface.
 */
public class Pitta implements MenuItem{
    // The amount of pitta breads in an order.
    private final int amount;
    // The time required to prepare the pitta bread. It is a constant value of 5.
    private final int timeRequired = 5;

    /**
     * Constructs a new Pitta object with the specified amount.
     * @param amount The amount of pitta breads in an order.
     */
    public Pitta(int amount){
        this.amount = amount;
    }

    /**
     * Returns the name of the menu item.
     * @return A string representing the name of the menu item.
     */
    @Override
    public String getName() {
        return "Pitta";
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
     * Returns the time required to prepare the menu item.
     * @return An integer representing the time required to prepare the menu item.
     */
    @Override
    public int getTimeRequired() {
        return timeRequired;
    }

    /**
     * Compares this Pitta object to the specified object.
     * The result is true if and only if the argument is not null and is a Pitta object that represents the same amount of pitta breads and the same time required as this object.
     * @param obj The object to compare this Pitta against.
     * @return A boolean indicating whether this Pitta is equal to the specified object.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pitta pitta)) {
            return false;
        }
        return amount == pitta.amount;
    }

    /**
     * Returns a string representation of the menu item.
     * @return A string representation of the menu item.
     */
    @Override
    public String toString() {
        return "Pitta: " + amount;
    }
}