
/**
 * Keeps track of time in the game, to help with animation and honestly just making things happen.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public interface Temporal {

	void timePassed();

	void die();

	void setIsPaused(boolean isPaused);

	boolean getIsPaused();

	void updatePosition();

	/**
	 * Fuses keep track of how long objects are allowed to exist.
	 *
	 */
	public void updateFuse();
}
