package hw4;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Generates all the orders with or without potatoes and writes them to a file.
 */
public class MakeAllOrders {
	
	private final InsideOneOrder ingredience;
	/**
     * Constructs a MakeAllOrders object with the specified ingredients.
     *
     * @param timeOrder   The time of order.
     * @param timeRequest The time of request.
     * @param pork        The quantity of pork.
     * @param chicken     The quantity of chicken.
     * @param seftalia    The quantity of seftalia.
     * @param mix         The quantity of mix.
     * @param potatoes    The quantity of potatoes.
     */
	private MakeAllOrders(int timeOrder,int timeRequest,int pork,int chicken,int seftalia,int mix,int potatoes) {
		ingredience= new InsideOneOrder(timeOrder,timeRequest,pork,chicken,seftalia,mix,potatoes);
	}
	 /**
     * Gets the ingredients of the order.
     *
     * @return The ingredients of the order.
     */
	public InsideOneOrder getIngredience() {
		return new InsideOneOrder(this.ingredience);
	}
	 /**
     * Generates a random time of order based on a Gaussian distribution.
     *
     * @return The randomly generated time of order.
     */
	private static int generateTimeOrder() {
		
		Random random = new Random();
        return (int)((random.nextGaussian() * Math.sqrt(60)) + 180);
	}
	/**
     * Generates a random time of request based on the time of order and the number of pittas in the order.
     *
     * @param timeOrder   The time of order.
     * @param numPittas   The number of pittas in the order.
     * @return The randomly generated time of request.
     */
	private static int generateTimeRequest(int timeOrder, int numPittas) {
		Random randomNum = new Random();
		int tdelreq;

		if (numPittas < 10) {
			int timeforPittaLess10 = randomNum.nextInt(151) + 30;
			tdelreq = timeforPittaLess10 + timeOrder;
		} else {
			int timeforPittaGreaterEqual10 = randomNum.nextInt(121) + 60;
			tdelreq = timeforPittaGreaterEqual10 + timeOrder;
		}

		return Math.min(tdelreq, 360);
	}

	 /**
     * Chooses the number of pittas for each order based on a random distribution.
     *
     * @param howManyPittas The total number of pittas for all orders.
     * @return An array representing the number of pittas for each order.
     */
	private static int[] choosePittas(int howManyPittas) {
		int[] amount = new int[4];
		Random randomNum = new Random();
		int r;
		for(int i=0;i<howManyPittas;i++) {
			r = randomNum.nextInt(4);
			amount[r]++;
		}
		return amount;

	}
	 /**
     * Creates a single order with a random number of pittas and potatoes.
     *
     * @param numPittas The number of pittas for the order.
     * @param potato    The quantity of potatoes for the order.
     * @return A MakeAllOrders object representing the order.
     */
	private static MakeAllOrders makeOneOrder(int numPittas,int potato) {
		int timeOrder= MakeAllOrders.generateTimeOrder();
		int timeRequest= MakeAllOrders.generateTimeRequest(timeOrder,numPittas);

		int[] amount= MakeAllOrders.choosePittas(numPittas);

		return new  MakeAllOrders(timeOrder,timeRequest,amount[0],amount[1],amount[2],amount[3],potato);
	}
	  /**
     * Generates a specified number of orders without potatoes.
     *
     * @param howManyOrders The number of orders to generate.
     * @return An array of MakeAllOrders objects representing the orders.
     */
	private static  MakeAllOrders[] generateWithNoPotatos(int howManyOrders) {
		MakeAllOrders[] orders = new  MakeAllOrders[howManyOrders];



		int numForOne=0,numForTwo=0,numForThree=0,numForFour=0,numForMult=0;

		float onePitta=(float)(20*howManyOrders)/100;
		float twoPitta=(float)(35*howManyOrders)/100;
		float threePitta=(float)(10*howManyOrders)/100;
		float fourPitta=(float)(20*howManyOrders)/100;
		float multiblePitta=(float)(15*howManyOrders)/100;


		int potato=0;

		Random randomNum = new Random();

		for(int i=0;i<howManyOrders;) {

			int rNumPittes=randomNum.nextInt(5);

			if(rNumPittes==0) {
				if(numForOne<onePitta) {
					orders[i]= MakeAllOrders.makeOneOrder(1,potato);
					numForOne++;
					i++;
				}

			}
			else if(rNumPittes==1) {
				if(numForTwo<twoPitta) {
					orders[i]= MakeAllOrders.makeOneOrder(2,potato);
					numForTwo++;
					i++;
				}
			}

			else if(rNumPittes==2) {
				if(numForThree<threePitta) {
					orders[i]= MakeAllOrders.makeOneOrder(3,potato);
					numForThree++;
					i++;
				}
			}
			else if(rNumPittes==3) {
				if(numForFour<fourPitta) {
					orders[i]= MakeAllOrders.makeOneOrder(4,potato);
					numForFour++;
					i++;
				}
			}
			else if(rNumPittes==4) {
				if(numForMult<multiblePitta) {
					int rNumLargerThan4=randomNum.nextInt(16)+5;
					orders[i]= MakeAllOrders.makeOneOrder(rNumLargerThan4,potato);
					numForMult++;
					i++;
				}
			}
		}
		return orders;
	}
	 /**
     * Generates orders with potatoes based on the provided orders without potatoes.
     *
     * @param orders The orders without potatoes.
     * @return An array of MakeAllOrders objects representing the orders with potatoes.
     */
	private static  MakeAllOrders[] generateWithPotatos( MakeAllOrders[] orders) {
		int getAllPittes=MakeAllOrders.getAllPittes(orders);



		Random randomNum = new Random();

		float onePotato = (float)(60*getAllPittes)/100;
		float noPotato=(float)(35*getAllPittes)/100;
		float doublePotato=(float)(5*getAllPittes)/100;


		int numForOnePotato=0,numForNoPotato=0,numForDoublePotato=0;

		for(int i=0;i<orders.length;i++) {
			MakeAllOrders oneOrder = orders[i];
			int pittesForOneOrder=oneOrder.getPittesForOneOrder();

			int sumForPotato=0;

			for(int j=0;j<pittesForOneOrder;) {
				int rNumPotatos=randomNum.nextInt(3);

				if  (rNumPotatos==0) {
					if(numForOnePotato<onePotato) {
						sumForPotato++;
						numForOnePotato++;
						j++;
					}
				}
				else if(rNumPotatos==1) {
					if(numForNoPotato<noPotato) {
						numForNoPotato++;
						j++;
					}
				}

				else {
					if(numForDoublePotato<doublePotato) {
						sumForPotato+=2;
						numForDoublePotato++;
						j++;
					}
				}


			}
			oneOrder.ingredience.setPotatoes(sumForPotato);

		}

		return orders;

	}
	   /**
     * Generates a specified number of orders with both potatoes and without potatoes, sorts them, and writes them to a file.
     *
     * @param howManyOrders The number of orders to generate.
     */
	public static void generate(int howManyOrders) {


		MakeAllOrders[] filledOrdersWithNoPotatos=MakeAllOrders.generateWithNoPotatos(howManyOrders);

		MakeAllOrders[] filledOrdersWithPotatos=MakeAllOrders.generateWithPotatos(filledOrdersWithNoPotatos);

		Sort.bubbleSort(filledOrdersWithPotatos);
		MakeAllOrders.putInFile(filledOrdersWithPotatos);
	}
	 /**
     * Retrieves the total number of pittas for the current order.
     *
     * @return The total number of pittas for the current order.
     */
	private int getPittesForOneOrder() {
		return this.ingredience.getChicken()+this.ingredience.getMix()+this.ingredience.getPork()+this.ingredience.getSeftalia();
	}
	  /**
     * Retrieves the total number of pittas from the provided orders.
     *
     * @param orders The orders.
     * @return The total number of pittas.
     */
	private static int getAllPittes(MakeAllOrders[] orders) {
		int getAllPittes=0;

		for(int i=0;i<orders.length;i++)
			getAllPittes+=orders[i].ingredience.getChicken()+orders[i].ingredience.getMix()+orders[i].ingredience.getPork()+orders[i].ingredience.getSeftalia();

		return getAllPittes;

	}
	   /**
     * Writes the orders to a file.
     *
     * @param orders The orders to write to the file.
     */
	private static void putInFile(MakeAllOrders[] orders) {
		String fileName = "orders.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			int num=1;
			for(int i=0;i<orders.length;i++) {
				writer.write(num+" "+orders[i].ingredience);
				writer.newLine();
				num++;
			}

		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}
}