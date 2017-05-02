import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.List;

public class GameWorld implements Temporal, Relocatable, GameEnvironment, Drawable {

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
	public void addCharacter(Character character) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void removeCharacter(Character character) {
		// TODO Auto-generated method stub.

	}

	@Override
	public Character nearestCharacter(Point2D point) {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public boolean isInsideWorldX(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean isInsideWorldY(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean isInsideWorld(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public List<Drawable> getDrawableParts() {
		// TODO Auto-generated method stub.
		return null;
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

}
