import java.awt.geom.Point2D;



public abstract class Character implements Temporal, Relocatable, Drawable {
	private double xPosition;
	private double yPosition;
	private GameWorld world;
	
	public Character(GameWorld world) {
		this(world, world.getCenterPoint());
	}
	public Character(GameWorld world, Point2D centerPoint) {
		this.centerPoint= centerPoint;
		this.world= world;
	}
	protected void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	@Override
	public void timePassed() {
		updateColor();
		updateSize();
		updatePosition();
	}

	@Override
	public void die() {
		this.world.removeCharacter(Character.this);
	}

	@Override
	public void moveTo(Point2D point) {
		double x= point.getX();
		double y= point.getY();
		this.centerPoint = new Point2D.Double(x,y);

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



