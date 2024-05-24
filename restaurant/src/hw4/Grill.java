package hw4;

/**
 * Represents a grill with various characteristics such as grill space, grill
 * time, pan space, souvlaki space, seftalia space, pitta space, and maximum pan
 * number.
 */
public class Grill {
	private final int grillSpace; // The total space of the grill
	private final int grillTime; // The time required to grill items
	private final int panSpace; // The space occupied by each pan
	private final int souvlakiSpace; // The space occupied by each souvlaki
	private final int seftaliaSpace; // The space occupied by each seftalia
	private final int pittaSpace; // The space occupied by each pitta
	private final int maxPanNum; // The maximum number of pans that can be used simultaneously
	private int panNum = 0; // The current number of pans on the grill

	/**
	 * Constructs a Grill object with the specified characteristics.
	 *
	 * @param grillSpace    The total space of the grill.
	 * @param grillTime     The time required to grill items.
	 * @param panNum        The maximum number of pans that can be used
	 *                      simultaneously.
	 * @param panSpace      The space occupied by each pan.
	 * @param souvlakiSpace The space occupied by each souvlaki.
	 * @param seftaliaSpace The space occupied by each seftalia.
	 * @param pittaSpace    The space occupied by each pitta.
	 */
	public Grill(int grillSpace, int grillTime, int panNum, int panSpace, int souvlakiSpace, int seftaliaSpace,
			int pittaSpace) {
		this.grillSpace = grillSpace;
		this.grillTime = grillTime;
		this.maxPanNum = panNum;
		this.panSpace = panSpace;
		this.souvlakiSpace = souvlakiSpace;
		this.seftaliaSpace = seftaliaSpace;
		this.pittaSpace = pittaSpace;
	}

	/**
	 * Gets the total space of the grill.
	 *
	 * @return The total space of the grill.
	 */
	public int getGrillSpace() {
		return grillSpace;
	}

	/**
	 * Gets the time required to grill items.
	 *
	 * @return The time required to grill items.
	 */
	public int getGrillTime() {
		return grillTime;
	}

	/**
	 * Gets the current number of pans on the grill.
	 *
	 * @return The current number of pans on the grill.
	 */
	public int getPanNum() {
		return panNum;
	}

	/**
	 * Sets the current number of pans on the grill.
	 *
	 * @param panNum The current number of pans on the grill.
	 */
	public void setPanNum(int panNum) {
		this.panNum = panNum;
	}

	/**
	 * Gets the space occupied by each pan.
	 *
	 * @return The space occupied by each pan.
	 */
	public int getPanSpace() {
		return panSpace;
	}

	/**
	 * Gets the space occupied by each souvlaki.
	 *
	 * @return The space occupied by each souvlaki.
	 */
	public int getSouvlakiSpace() {
		return souvlakiSpace;
	}

	/**
	 * Gets the space occupied by each seftalia.
	 *
	 * @return The space occupied by each seftalia.
	 */
	public int getSeftaliaSpace() {
		return seftaliaSpace;
	}

	/**
	 * Gets the space occupied by each pitta.
	 *
	 * @return The space occupied by each pitta.
	 */
	public int getPittaSpace() {
		return pittaSpace;
	}

	/**
	 * Gets the maximum number of pans that can be used simultaneously.
	 *
	 * @return The maximum number of pans that can be used simultaneously.
	 */
	public int getMaxPanNum() {
		return maxPanNum;
	}
}
