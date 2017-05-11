import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Hero extends GameObject {
	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.size = 40;
		this.y = (int) centerPoint.getY();
		this.x = (int) centerPoint.getX();
		this.dx = 0;
		this.dy = 0;

	}

	public void stopHero() {
		this.dx = 0;
		this.dy = 0;
	}

	public void moveUp() {
		this.dy = -2;
	}

	public void moveDown() {
		this.dy = 2;

	}

	public void moveLeft() {
		this.dx = -2;

	}

	public void moveRight() {
		this.dx = 2;

	}

	/*public void setBomb() {
		if (!this.getWorld().bombExists) {
			Bomb newBomb = new Bomb(this.world, new Point2D.Double(this.x, this.y));
			this.world.addGameObject(newBomb);
		}
		
	}*/
	
	public void setBomb() {
		Runnable b = new Bomb(this.world,new Point2D.Double(this.x, this.y));
		this.world.getObjectList().add((GameObject) b);
		Thread th = new Thread(b);
		th.start();
		//this.world.removeGameObject((GameObject) b);
	}

	public Shape getShape() {
		return new Rectangle2D.Double(this.x, this.y, this.size, this.size);
	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}

	@Override
	public void updatePosition() {
		Point2D.Double myPoint = new Point2D.Double(x, y);
		this.x += this.dx;
		this.y += this.dy;
		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
				//System.out.println("any colide");
			}
		}

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
		return 0;
	}

	@Override
	public Point2D getCenterPoint() {
		return new Point2D.Double(x, y);
	}

	@Override
	public void collide(GameObject m) {
		m.collideWithHero(this);
	}

	@Override
	public void collideWithHero(Hero h) {

	}

	@Override
	public void collideWithMonster(Monster m) {
		this.die();
	}

	@Override
	public void collideWithWall(Wall w) {
		this.x -= this.dx;
		this.y -= this.dy;
		this.dx = 0;
		this.dy = 0;

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		this.x -= this.dx;
		this.y -= this.dy;
		this.dx = 0;
		this.dy = 0;
	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub
		
	}

	

}
