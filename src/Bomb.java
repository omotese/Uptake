import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameObject {
	private double x;
	private double y;
	private double maxSize;
	private boolean mySize;
	private boolean hitExplosion;
	private double bombSize;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.bombSize = 30;
		this.maxSize = 130;
		this.hitExplosion = false;
		setColor(Color.WHITE);

		this.x = Math.round((this.getCenterPoint().getX()) / 50) * 50 + 10;
		this.y = Math.round((this.getCenterPoint().getY()) / 50) * 50 + 10;

		//need to be moved to somewhere else
		//created method increaseMaxSize
		if (this.getWorld().getHero().getHasExpandBomb() == true) {
			this.maxSize = 230;
		}

		//should not be implemented here
		this.getWorld().bombExists = true;
	}

	//super-----------------------------------------
	@Override 
	public String getName(){
		return "bomb";
	}
	// Drawable--------------------------------------
	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.bombSize, this.bombSize);
		return myRect;
	}
	
	// Temporal--------------------------------------
	@Override
	public void updateSize() {
		if (this.bombSize >= maxSize || this.hitExplosion) {
			System.out.println(this.hitExplosion);
			Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(x, y));
			// System.out.println("max"+maxSize);
			this.getWorld().addGameObject(exp);
			this.die();
			this.getWorld().bombExists = false;

		} else {
			this.bombSize += .6;
		}

	}

	@Override
	public void updatePosition() {
		if (this.bombSize <= maxSize) {
			x -= .3;
			y -= .3;
		}
	}
	
	// Relocatable------------------------------------

	// Collision--------------------------------------

	@Override
	public void collideWithExplosion(Explosion e) {
		//Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(x,y)); this.getWorld().addGameObject(exp);
		// System.out.println("bomb collide with explosion");
		this.hitExplosion = true;
		// System.out.println("hitExplosion " + this.hitExplosion);
		this.die();
	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub
		this.die();
	}

	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithBomb(this);
	}

	@Override
	public void collideWithSeeker(Seeker s) {
		s.collideWithBomb(this);

	}
	
	//------------------------------------------------
	public void increaseMaxSize(){
		this.maxSize = 230;
	}

}
