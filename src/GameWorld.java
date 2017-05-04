import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;



public class GameWorld implements Temporal, Drawable {
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int width;
	private final int height;
	private final Color backgroundColor;
	
	private final List<GameObject> objectList = new ArrayList<GameObject>();
	private final List<GameObject> objectToAdd = new ArrayList<GameObject>();
	private final List<GameObject> objectToRemove = new ArrayList<GameObject>();
	
	private final Shape background;
	private boolean isPaused = false;

	public GameWorld(int width, int height, Color color){
		this.width=width;
		this.height= height;
		this.backgroundColor= color;
		this.background = new Rectangle2D.Double(0, 0, this.width, this.height);
		
		Runnable tickTock = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(UPDATE_INTERVAL_MS);
						timePassed();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(tickTock).start();
		
	}
	
	@Override
	public Color getColor() {
		return this.backgroundColor;
	}

	@Override
	public Shape getShape() {
		return this.background;
	}

	public Point2D getCenterPoint() {
		double x = this.width / 2;
		double y = this.height / 2;
		return new Point2D.Double(x, y);
	}

	@Override
	public void timePassed() {
		if(!this.isPaused) {
			for(Temporal t : this.objectList) {
				t.timePassed();
			}
		}
		this.objectList.removeAll(this.objectToRemove);
		this.objectToRemove.clear();
		this.objectList.addAll(this.objectToAdd);
		this.objectToAdd.clear();
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
		
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}

	public void removeGameObject(GameObject gameObject) {
		this.objectToRemove.add(gameObject);
	}
	
	public void addGameObject(GameObject gameObject) {
		this.objectToAdd.add(gameObject);
		
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public synchronized List<Drawable> getDrawableParts() {
		return new ArrayList<Drawable>(this.objectList);
	}


}
