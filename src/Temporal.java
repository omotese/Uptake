
/**
 * TODO Put here a description of what this class does.
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
