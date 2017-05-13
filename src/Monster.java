import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Monster extends GameObject {

	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Monster(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.x = (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
		Random ran = new Random();
		if(ran.nextBoolean()){
			this.dx = 1;
		}else{
			this.dx = -1;
		}
		if(ran.nextBoolean()){
			this.dy = 1;
		}else{
			this.dy = -1;
		
		}
		this.size = 40;
	}


	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

	@Override
	public Color getColor() {
		return Color.red;
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.size, this.size);
	}

	@Override
	public void updatePosition() {
		// System.out.println(this.world.getObjectList().size());
		this.x += dx;
		this.y += dy;
		Point2D newPoint = new Point2D.Double(x, y);
		this.setCenterPoint(newPoint);

		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
			}
		}


	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}
	
	public Point2D reset(){
		return new Point2D.Double(this.x, this.y);
	}
	
	@Override
	public double getDiameter() {
		return size;
	}

	@Override
	public void collide(GameObject m) {
		m.collideWithMonster(this);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithMonster(this);
	}

	@Override
	public void collideWithMonster(Monster m) {
		
	}

	@Override
	public void collideWithWall(Wall w) {
		Random ran = new Random();
		this.x -= this.dx;
		this.y -= this.dy;
		do {
			this.dx = (ran.nextInt(3) - 1) ;
			this.dy = (ran.nextInt(3) - 1) ;
		} while (this.dx == 0 && this.dy == 0);
		//System.out.println("m+w " + dx + " " + dy);

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		collideWithWall(b);

	}
	
	@Override
	public void updateSize() {
		// TODO Auto-generated method stub

	}


	@Override
	public void collideWithBomb(Bomb b) {
		Random ran = new Random();
		this.x -= this.dx;
		this.y -= this.dy;
		do {
			this.dx = (ran.nextInt(3) - 1) ;
			this.dy = (ran.nextInt(3) - 1) ;
		} while (this.dx == 0 && this.dy == 0);
		
	}


	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
		
	}


	@Override
	public void collideWithSeeker(Seeker s) {
		// TODO Auto-generated method stub.
		
	}


}
