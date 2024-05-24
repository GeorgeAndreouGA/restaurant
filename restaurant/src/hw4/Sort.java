package hw4;

import java.util.*;
/**
 * Provides methods for sorting orders.
 */
public class Sort {

    /**
     * Sorts an array of orders using the bubble sort algorithm based on order time.
     * 
     * @param orders The array of orders to be sorted.
     */
	public static void bubbleSort(MakeAllOrders[] orders) {
		int i, j;
		MakeAllOrders temp;
		boolean swapped;
		for (i = 0; i < orders.length - 1; i++) {
			swapped = false;
			for (j = 0; j < orders.length - i - 1; j++) {
				if (orders[j].getIngredience().getTimeOrder() > orders[j + 1].getIngredience().getTimeOrder()) {

					temp = orders[j];
					orders[j] = orders[j + 1];
					orders[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}

	}
	/**
     * Sorts a HashMap of orders based on order ID.
     * 
     * @param orders The HashMap of orders to be sorted.
     * @return The sorted HashMap.
     */
	public static HashMap<Order, Integer> HashSort(HashMap<Order, Integer> orders) {

		List<Map.Entry<Order, Integer>> list = new ArrayList<>(orders.entrySet());

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - i - 1; j++) {
				if (list.get(j).getKey().orderId > list.get(j + 1).getKey().orderId) {
					// Swap elements
					Map.Entry<Order, Integer> temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}

		HashMap<Order, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Order, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

}
