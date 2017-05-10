import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Bomb extends GameObject {
	private double x;
	private double y;
	private double size;
	private int fuse;
	private int explosion;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
			this.size = 30;
			this.x = Math.round((centerPoint.getX())/50)*50+10;
			this.y = Math.round((centerPoint.getY())/50)*50+10;
			this.fuse = 400;
			this.explosion = 5;
			this.getWorld().bombExists = true;

		
	}

	@Override
	public Color getColor() {
		if (fuse < 10) {
			return Color.white;
		}
		return new Color(250 - fuse * 250 / 400, 10, 10);
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {
		x -= .03;
		y -= .03;
		if (fuse < 120) {
			x -= .3;
			y -= .3;
		}

	}
	
	

	public void updateFuse() {
		fuse--;
		if (fuse == 0) {
			this.die();
			//this.getWorld().bombExists = false;
			Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(this.x*40, this.y*40));
		}
	}
	
	

	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		updateFuse();
		size += .06;
		if (fuse < 120) {
			size += .6;
		}
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collide(GameObject m) {
		// TODO Auto-generated method stub.

	}


	@Override
	public void collideWithMonster(Monster m) {

	}

	@Override
	public void collideWithWall(Wall w) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void collideWithBreakable(BreakableBlock b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithBomb(Explosion e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub
		
	}


}
