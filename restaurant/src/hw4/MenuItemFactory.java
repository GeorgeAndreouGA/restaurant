package hw4;

/**
 * The MenuItemFactory class is a factory class for creating different types of menu items.
 */
public class MenuItemFactory {

    /**
     * Creates a new MenuItem object based on the provided name and amount.
     * The name is case insensitive.
     *
     * @param name The name of the menu item. It can be one of the following: "porkskewer", "chickenskewer", "sheftaliaskewer", "mixskewer", "fries", "pitta".
     * @param amount The amount of the menu item in an order.
     * @return A MenuItem object of the specified type and amount. If the name does not match any of the known types, it returns null.
     */
    public static MenuItem createMenuItem(String name, int amount){
        name = name.toLowerCase();
        return switch (name) {
            case "porkskewer" -> new PorkSkewer(amount);
            case "chickenskewer" -> new ChickenSkewer(amount);
            case "sheftaliaskewer" -> new SheftaliaSkewer(amount);
            case "mixskewer" -> new MixSkewer(amount);
            case "fries" -> new Fries(amount);
            case "pitta" -> new Pitta(amount);
            default -> null;
        };
    }
}