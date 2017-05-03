import java.awt.geom.Point2D;

public abstract class GameObject {
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
	
	

}
