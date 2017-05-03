import java.awt.geom.Point2D;



public abstract class Character implements Temporal,Relocatable, Drawable {
//	private double dx;
//	private double dy;
	private Point2D centerPoint;
	private GameEnvironment world;
	private boolean isPaused = false;
	public Character(GameEnvironment world) {
		this(world, world.getCenterPoint());
	}
	public Character(GameEnvironment world, Point2D centerPoint) {
		// TODO Auto-generated constructor stub.
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
		world.removeCharacter(Character.this);
	}

	@Override
	public boolean getIsPaused() {
		// not yet implemented
		return false;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused= isPaused;
	}

}
