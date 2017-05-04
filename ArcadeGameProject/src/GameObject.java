import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public abstract class GameObject implements Drawable, Temporal, Relocatable{
	private Point2D centerPoint;
	private GameWorld world;
	private boolean isPaused = false;
	
	public GameObject(GameWorld world) {
		this(world, world.getCenterPoint());
	}

	public GameObject(GameWorld world2, Point2D centerPoint2) {
		this.centerPoint= centerPoint;
		this.world= world;
	}
	
	protected void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}
	
	protected GameWorld getWorld() {
		return this.world;
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
	public void die() {
		this.world.removeGameObject(this);
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
	public Shape getShape() {
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		double size = getDiameter();
		return new Ellipse2D.Double(x - size / 2, y - size / 2, size, size);
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
