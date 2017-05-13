import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Seeker extends GameObject {
	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Seeker(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.x = (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
		this.size= 40;
		
	}

	@Override
	public Color getColor() {
		return Color.MAGENTA;
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.size, this.size);
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithMonster(Wanderer m) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithWall(Wall w) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithExplosion(Explosion e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void updatePosition() {
		
		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
			}
		}
		
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
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

}
