import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public abstract class GameObject implements Drawable, Temporal, Relocatable{
	private Point2D centerPoint;
	private boolean isPaused = false;
	
	public GameObject() {
	}

	public GameObject(Point2D centerPoint) {
		this.centerPoint= centerPoint;
	}
	
	protected void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}
	
	@Override
	public void timePassed() {
		if(!isPaused){
			updateColor();
			updateSize();
			updatePosition();
		}
	}


	@Override
	public boolean getIsPaused() {
		return isPaused;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		isPaused = isPaused;
	}
	
	@Override
	public void moveTo(Point2D point) {
		this.setCenterPoint(point);
	}
	
	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}
	
	public abstract void updatePosition();
	
	public abstract void updateSize();

	public abstract void updateColor();

	public abstract double getDiameter();
	

}
