package hw4;
/**
 * Generates orders based on the given input.
 */
public abstract class OrderGenerator {
	/**
     * Entry point of the order generation process.
     * 
     * @param args Command line arguments. Expects the number of orders to generate.
     */
public static void main(String[] args) {
	
	 if (args.length !=1) {
         System.out.println("Please provide the number of orders to generate.");
         return;
     }
	int howManyOrders = Integer.parseInt(args[0]);
	MakeAllOrders.generate(howManyOrders);
    System.out.println(args[0] + " orders generated successfully.");
}
}