import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Hero extends Character {
	private double x;
	private double y;
	private double xVelocity;
	private double yVelocity;
	
	public Hero(GameEnvironment world) {
		super(world);
		this.x= 50;
		this.y=50;
		
	}
	
	@Override
	public void timePassed() {
		// TODO Auto-generated method stub.

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
		return null;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void updatePosition(double dx, double dy) {
		Point2D.Double newPos = new Point2D.Double(this.x, this.y);
		
	}

	
	
	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.
		
	}





}
