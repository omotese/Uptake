import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameObject {
	private double x;
	private double y;
	private double size;
	private double maxSize;
	private boolean mySize;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 30;
		this.x = Math.round((centerPoint.getX()) / 50) * 50 + 10;
		this.y = Math.round((centerPoint.getY()) / 50) * 50 + 10;
		
		this.maxSize = 130;
		if(this.getWorld().getHero().hasExpandBombPowerUp() == true) {
			this.maxSize = 230;
		}
		this.getWorld().bombExists = true;
	}
	public void setMySize(boolean mySize) {
		this.mySize = mySize;
	}
	
	public boolean getMySize() {
		return this.mySize;
	}
	public void superBomb(){
		this.mySize=true;
		if(mySize==true){
			System.out.println("This is my size"+ mySize);
			maxSize= 300;
		}else{
			maxSize= 130;
		}
	}

	@Override
	public Color getColor() {
		return Color.WHITE;
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {
		if (size <= maxSize) {
			x -= .3;
			y -= .3;
		}
		
	}

	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		if (size >= maxSize) {
			Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(x, y));
			System.out.println("max"+maxSize);
			this.getWorld().addGameObject(exp);
			this.die();

		} else {
			size += .6;
		}

	}

	@Override
	public void collide(GameObject m) {
		// TODO Auto-generated method stub.

	}


	@Override
	public void collideWithWall(Wall w) {

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
	}

	@Override
	public void collideWithHero(Hero h) {

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithBomb(this);
	}

	@Override
	public void collideWithSeeker(Seeker s) {
		s.collideWithBomb(this);
		
	}

	@Override
	public void collideWithPowerUp(SpeedUp p) {
		// TODO Auto-generated method stub.
		
	}

}
