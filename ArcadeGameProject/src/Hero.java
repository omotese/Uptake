import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Hero extends Character {
	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world,centerPoint);
		this.world=world;
		this.size = 50;
		this.y = (int) centerPoint.getY();
		this.x = (int) centerPoint.getX();
		
	}
	
	public void moveUp() {
		if (this.y-10 >= 50) {
			this.y -= 10;
		}
	}

	public void moveDown() {
		if (this.y + 10 <= 550) {
			this.y += 10;
		}
	}

	public void moveLeft() {
		if (this.x - 10 >= 50) {
			this.x -= 10;
		}
	}

	public void moveRight() {
		if (this.x + 10 <= 750) {
			this.x += 10;
		}
	}

	public void setBomb() {
		Bomb newBomb = new Bomb(this.world, new Point2D.Double(this.x, this.y));
		this.world.addGameObject(newBomb);
	}

	public Shape getShape() {
		return new Ellipse2D.Double(this.x, this.y, this.size, this.size);
	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}

	@Override
	public void updatePosition() {
		Point2D.Double myPoint = new Point2D.Double(x, y);
		this.setCenterPoint(myPoint);
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point2D getCenterPoint() {
		return new Point2D.Double(x, y);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
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
