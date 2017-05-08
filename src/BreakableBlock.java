import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class BreakableBlock extends Block {
	
	private GameWorld world;
	private Point2D centerPoint;
	private int wallSize;
	
	public BreakableBlock(GameWorld world, Point2D centerPoint){
		super(world, centerPoint);
		this.world= world;
		this.wallSize=50;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.blue;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		Rectangle2D.Double myRect= new Rectangle2D.Double(centerPoint.getX(),centerPoint.getY(),wallSize,wallSize);
		
		return myRect ;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	void collide(GameObject m) {
		// TODO Auto-generated method stub.

	}

	@Override
	void collideWithHero(Hero m) {
		// TODO Auto-generated method stub.

	}

	@Override
	void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.

	}

}
