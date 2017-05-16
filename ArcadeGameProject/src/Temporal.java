

public interface Temporal {

	void timePassed();
	void die();
	void setIsPaused(boolean isPaused);
	boolean getIsPaused();
	
	void updatePosition();
	
	public void updateSize();
	
	public void updateFuse();
}
