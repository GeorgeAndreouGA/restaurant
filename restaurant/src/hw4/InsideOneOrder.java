
package hw4;
/**
 * Represents an order containing details such as the time of order, time of request,
 * quantities of pork, chicken, seftalia, mix, and potatoes.
 */
public class InsideOneOrder {
	private final int timeOrder;
	private final int timeRequest;
	private final int pork;
	private final int chicken;
	private final int seftalia;
	private final int mix;
	private int potatoes;
	 /**
     * Constructs an InsideOneOrder object with the specified details.
     *
     * @param timeOrder   The time of order.
     * @param timeRequest The time of request.
     * @param pork        The quantity of pork.
     * @param chicken     The quantity of chicken.
     * @param seftalia    The quantity of seftalia.
     * @param mix         The quantity of mix.
     * @param potatoes    The quantity of potatoes.
     */
	public InsideOneOrder(int timeOrder,int timeRequest,int pork,int chicken,int seftalia,int mix,int potatoes) {
		this.timeOrder=timeOrder;
		this.timeRequest=timeRequest;
		this.pork=pork;
		this.chicken=chicken;
		this.seftalia=seftalia;
		this.mix=mix;
		this.potatoes=potatoes;
	}
	  /**
     * Constructs an InsideOneOrder object by copying another InsideOneOrder object.
     *
     * @param other The InsideOneOrder object to copy.
     */
	public InsideOneOrder(InsideOneOrder other) {
		this.timeOrder=other.timeOrder;
		this.timeRequest=other.timeRequest;
		this.pork=other.pork;
		this.chicken=other.chicken;
		this.seftalia=other.seftalia;
		this.mix=other.mix;
		this.potatoes=other.potatoes;
	}
	  /**
     * Gets the time of order.
     *
     * @return The time of order.
     */
	public int getTimeOrder() {
		return timeOrder;
	}
	  /**
     * Gets the quantity of pork.
     *
     * @return The quantity of pork.
     */
	 public int getPork() {
	        return pork;
	    }
	 /**
	     * Gets the quantity of chicken.
	     *
	     * @return The quantity of chicken.
	     */
	 public int getChicken() {
	        return chicken;
	    }
	  /**
	     * Gets the quantity of seftalia.
	     *
	     * @return The quantity of seftalia.
	     */
	 public int getSeftalia() {
	        return seftalia;
	    }
	  /**
	     * Gets the quantity of mix.
	     *
	     * @return The quantity of mix.
	     */
	 public int getMix() {
	        return mix;
	    }
	  /**
	     * Sets the quantity of potatoes.
	     *
	     * @param potatoes The quantity of potatoes.
	     */
	 public void setPotatoes(int potatoes) {
	        this.potatoes=potatoes;
	    }
	 /**
	     * Returns a string representation of the InsideOneOrder object.
	     *
	     * @return A string representation of the InsideOneOrder object.
	     */
	public String toString() {
		return  timeOrder+" "+timeRequest+" "+pork+" "+chicken+" "+seftalia+" "+mix+" "+potatoes;
	}
	
}