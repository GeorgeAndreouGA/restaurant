package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * The OrderFactory class is a factory class for creating different types of orders.
 */
public class OrderFactory {

    /**
     * Creates a new Order object with the specified order number, order time, delivery request time, and amounts of different menu items.
     * The menu items are created based on the provided amounts and added to the order.
     *
     * @param num The order number.
     * @param tord The time the order was placed.
     * @param tdelreq The time the order is expected to be delivered.
     * @param npp The amount of PorkSkewer in the order.
     * @param npc The amount of ChickenSkewer in the order.
     * @param nps The amount of SheftaliaSkewer in the order.
     * @param npm The amount of MixSkewer in the order.
     * @param npf The amount of Fries in the order.
     * @return An Order object with the specified order number, order time, delivery request time, and list of menu items.
     */
    public static Order createOrder(int num, int tord, int tdelreq, int npp, int npc, int nps, int npm, int npf){
        List<MenuItem> items = new ArrayList<>();
        items.add(createMenuItem("PorkSkewer", npp));
        items.add(createMenuItem("ChickenSkewer", npc));
        items.add(createMenuItem("SheftaliaSkewer", nps));
        items.add(createMenuItem("MixSkewer", npm));
        items.add(createMenuItem("Fries", npf));
        items.add(createMenuItem("Pitta", npp + npc + nps + npm));
        return new ConcreteOrder(num, tord, tdelreq, items);
    }

    /**
     * Creates a new MenuItem object with the specified name and amount.
     * The name is case-sensitive.
     *
     * @param name The name of the menu item. It can be one of the following: "PorkSkewer", "ChickenSkewer", "SheftaliaSkewer", "MixSkewer", "Fries", "Pitta".
     * @param amount The amount of the menu item in an order.
     * @return A MenuItem object of the specified type and amount. If the name does not match any of the known types, it returns null.
     */
    public static MenuItem createMenuItem(String name, int amount){
        return MenuItemFactory.createMenuItem(name, amount);
    }
}