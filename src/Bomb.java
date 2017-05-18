import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameObject {
	private double x;
	private double y;
//	private double maxSize;
//	private boolean mySize;
	private boolean hitExplosion;
//	private double bombSize;
	private int fuse;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(50);
//		this.bombSize = 30;
//		this.maxSize = 130;
		this.hitExplosion = false;
		setColor(Color.WHITE);
		this.fuse = 200;
		this.x = Math.round((this.getCenterPoint().getX()) / 50) * 50;
		this.y = Math.round((this.getCenterPoint().getY()) / 50) * 50;
		
		this.setCenterPoint(new Point2D.Double(x,y));

		

		//need to be moved to somewhere else
		//created method increaseMaxSize
//		if (this.getWorld().getHero().getHasExpandBomb() == true) {
//			this.maxSize = 230;
//		}

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
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
		return myRect;
	}
	
// 	Temporal--------------------------------------
	
	@Override
	public void updateFuse() {
		this.fuse--;
		if(fuse <=0){
			this.createExplosion();
			this.die();
			this.getWorld().bombExists = false;
		}
	}
	
	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
		this.getWorld().removeFromBombList(this);
	}
	
	// Relocatable------------------------------------

	// Collision--------------------------------------

	@Override
	public void collideWithExplosion(Explosion e) {
		//Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(x,y)); this.getWorld().addGameObject(exp);
//		this.hitExplosion = true;
		this.createExplosion();
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
//	public void increaseMaxSize(){
//		this.maxSize = 230;
//	}
	
	public void createExplosion() {
		Explosion mid = new Explosion(this.getWorld(), new Point2D.Double(x, y));
		Explosion up = new Explosion(this.getWorld(), new Point2D.Double(x, y-50));
		Explosion down = new Explosion(this.getWorld(), new Point2D.Double(x, y+50));
		Explosion left = new Explosion(this.getWorld(), new Point2D.Double(x-50, y));
		Explosion right = new Explosion(this.getWorld(), new Point2D.Double(x+50, y));

		this.getWorld().addGameObject(mid);
		this.getWorld().addGameObject(up);
		this.getWorld().addGameObject(down);
		this.getWorld().addGameObject(left);
		this.getWorld().addGameObject(right);
		
		if (this.getWorld().getHero().getHasExpandBomb()) {
			Explosion up2 = new Explosion(this.getWorld(), new Point2D.Double(x, y-100));
			Explosion down2 = new Explosion(this.getWorld(), new Point2D.Double(x, y+100));
			Explosion left2 = new Explosion(this.getWorld(), new Point2D.Double(x-100, y));
			Explosion right2 = new Explosion(this.getWorld(), new Point2D.Double(x+100, y));
			
			this.getWorld().addGameObject(up2);
			this.getWorld().addGameObject(down2);
			this.getWorld().addGameObject(left2);
			this.getWorld().addGameObject(right2);
		}
	}
	

}
