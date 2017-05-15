import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Hero extends GameObject {
	private Point2D centerPoint;
	private double size;
	private GameWorld world;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private boolean isFaster;
	private boolean hasMultiBomb;
	private int lives;
	private boolean hasExpandBombPowerUp;

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.size = 30;
		this.y = centerPoint.getY();
		this.x = centerPoint.getX();
		this.dx = 0;
		this.dy = 0;
		this.lives = 3;
		this.isFaster = false;
		this.hasMultiBomb= false;
		this.hasExpandBombPowerUp=false;

	}

	public void reset() {
		this.y = 50;
		this.x = 50;
		this.isFaster = false;
		this.hasExpandBombPowerUp = false;
		this.hasMultiBomb= false;
	}

	public void stopHero() {
		this.dx = 0;
		this.dy = 0;
	}

	public void setIsFaster(boolean isFaster) {
		this.isFaster = isFaster;
		// System.out.println("hero is set faster " + this.getIsFaster());
	}
	public void setMultiBomb(boolean multiBomb) {
		this.hasMultiBomb = multiBomb;
	} 
	
	public void setHasExpandBombPowerUp(boolean hasExpandBombPowerUp) {
		this.hasExpandBombPowerUp = hasExpandBombPowerUp;
	}
	
	public boolean getHasMultiBomb() {
		return this.hasMultiBomb;
	}
	
	public boolean getHasExpandBombPowerUp() {
		return this.hasExpandBombPowerUp;
	}
	
	public boolean getIsFaster() {
		return this.isFaster;
	}

	public void moveUp() {
		if (isFaster == true) {
			this.dy = -5;
		} else {
			this.dy = -2.5;
		}

	}

	public void moveDown() {
		if (isFaster == true) {
			this.dy = 5;
		} else {
			this.dy = 2.5;
		}

	}

	public void moveLeft() {
		if (isFaster == true) {
			this.dx = -5;
		} else {
			this.dx = -2.5;
		}

	}

	public void moveRight() {
		if (isFaster == true) {
			this.dx = 5;
			// System.out.println("dx is " +dx);
		} else {
			this.dx = 2.5;
		}

	}

	public void setBomb() {
		if(this.world.bombExists==false){
		Bomb b = new Bomb(this.world, new Point2D.Double(this.x, this.y));
		this.world.addGameObject(b);
		this.world.addBombList(b);
		}
		if(hasMultiBomb){
			this.world.bombExists=false;
		}
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
				// System.out.println("any colide");
			}
		}

		this.setCenterPoint(myPoint);
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
	public void collideWithWall(Wall w) {
		this.x -= this.dx;
		this.y -= this.dy;
		stopHero();

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		collideWithWall(b);
	}

	@Override
	public void die() {
		this.y = 50;
		this.x = 50;
		this.lives--;
		this.getWorld().resetAllMonsters();
		if (this.lives == 0) {
			this.lives = 3;
			this.getWorld().restart();

		}

	}

	@Override
	public void collideWithBomb(Bomb b) {
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
	public void collideWithMonster(Monster m) {
		this.die();
	}

	@Override
	public void collideWithSeeker(Seeker s) {
		// TODO Auto-generated method stub.
		this.die();
	}

	@Override
	public void collideWithPowerUp(PowerUp p) {
		// TODO Auto-generated method stub.
		
	}

}
