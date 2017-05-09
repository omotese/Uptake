import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Monster extends Character {

	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;

	public Monster(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.x= (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
	}
	

	@Override
	public void timePassed() {
		// TODO Auto-generated method stub.
		updatePosition();
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public void moveTo(Point2D point) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public Point2D getCenterPoint() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.PINK;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		int[] xpoints = new int[3];
		int[] ypoints = new int[3];
		xpoints[0] = x;
		xpoints[1] = x + 25;
		xpoints[2] = x + 50;
		ypoints[0] = y;
		ypoints[1] = y-50;
		ypoints[2] = y;
		Polygon myMonster= new Polygon(xpoints, ypoints, 3);
		return myMonster;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
		this.x=this.x;
		this.y+=1;
		
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
