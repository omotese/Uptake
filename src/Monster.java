import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Monster extends Character {


	public Monster() {
	}
	
	public Monster(Point2D centerPoint) {
		this.setCenterPoint(centerPoint);
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
	public void updatePosition() {
		// TODO Auto-generated method stub.
		//randomize the position of the monsters
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
