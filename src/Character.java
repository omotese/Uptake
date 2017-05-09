import java.awt.geom.Point2D;

public abstract class Character extends GameObject {
	
	public Character(GameWorld world) {
		super(world);
	}
	
	public Character(GameWorld world,Point2D centerPoint) {
		super(world, centerPoint);
	}
	

}



