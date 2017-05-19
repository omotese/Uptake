import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**

 * @author Explosions in the sky caught my eye. I watched them go by, bye.
 *         Created May 18, 2017.
 */

public class Bomb extends GameObject {
	private double x;
	private double y;
	private boolean hitExplosion;
	private int fuse;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(50);
		this.hitExplosion = false;
		setColor(Color.WHITE);
		this.fuse = 200;
		this.x = Math.round((this.getCenterPoint().getX()) / 50) * 50;
		this.y = Math.round((this.getCenterPoint().getY()) / 50) * 50;
		this.setCenterPoint(new Point2D.Double(x, y));
	}

	@Override
	public String getName() {
		return "bomb";
	}

	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
		return myRect;
	}

	/**
	 * TODO
	 */
	@Override
	public void updateFuse() {
		if (!this.getWorld().getHero().getHasDetonator()) {
			this.fuse--;
			if (fuse <= 0) {
				this.createExplosion();
				this.die();
			}
		}
	}

	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
		this.getWorld().removeFromBombList(this);
		this.getWorld().setBombExists(false);

	}

	@Override
	public void collideWithExplosion(Explosion e) {
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

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	public void createExplosion() {
		Explosion mid = new Explosion(this.getWorld(), new Point2D.Double(x, y));
		Explosion up = new Explosion(this.getWorld(), new Point2D.Double(x, y - 50));
		Explosion down = new Explosion(this.getWorld(), new Point2D.Double(x, y + 50));
		Explosion left = new Explosion(this.getWorld(), new Point2D.Double(x - 50, y));
		Explosion right = new Explosion(this.getWorld(), new Point2D.Double(x + 50, y));

		this.getWorld().addGameObject(mid);
		this.getWorld().addGameObject(up);
		this.getWorld().addGameObject(down);
		this.getWorld().addGameObject(left);
		this.getWorld().addGameObject(right);

		if (this.getWorld().getHero().getHasExpandBomb()) {
			Explosion up2 = new Explosion(this.getWorld(), new Point2D.Double(x, y - 100));
			Explosion down2 = new Explosion(this.getWorld(), new Point2D.Double(x, y + 100));
			Explosion left2 = new Explosion(this.getWorld(), new Point2D.Double(x - 100, y));
			Explosion right2 = new Explosion(this.getWorld(), new Point2D.Double(x + 100, y));

			this.getWorld().addGameObject(up2);
			this.getWorld().addGameObject(down2);
			this.getWorld().addGameObject(left2);
			this.getWorld().addGameObject(right2);
		}
	}

}
