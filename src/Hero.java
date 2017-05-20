import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * The hero moves around the board and can be killed by monsters or the bombs it drops
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class Hero extends GameObject {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private int lives;
	private boolean isFaster;
	private boolean hasMultiBomb;
	private boolean hasExpandBomb;
	private boolean hasDetonator;
	private String name;

	public Hero(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(30);
		this.x = centerPoint.getX();
		this.y = centerPoint.getY();
		this.dx = 0;
		this.dy = 0;
		this.lives = 3;
		this.isFaster = false;
		this.hasMultiBomb = false;
		this.hasExpandBomb = false;
		this.hasDetonator = false;
		setColor(Color.YELLOW);
		this.name = "hero";
		loadImage();
	}

	/**
	 * Resets the hero to its starting position and removes any power ups
	 *
	 */
	public void reset() {
		this.y = 50;
		this.x = 50;
		this.isFaster = false;
		this.hasExpandBomb = false;
		this.hasMultiBomb = false;
		this.hasDetonator = false;
	}

	public void stopHero() {
		this.dx = 0;
		this.dy = 0;
	}

	public void setIsFaster(boolean isFaster) {
		this.isFaster = isFaster;

	}

	public void setMultiBomb(boolean multiBomb) {
		this.hasMultiBomb = multiBomb;
	}

	public void setHasExpandBomb(boolean hasExpandBomb) {
		this.hasExpandBomb = hasExpandBomb;
	}

	public void setHasDetonator(boolean hasDetonator) {
		this.hasDetonator = hasDetonator;
	}

	public boolean getHasMultiBomb() {
		return this.hasMultiBomb;
	}

	public boolean getHasExpandBomb() {
		return this.hasExpandBomb;
	}

	public boolean getIsFaster() {
		return this.isFaster;
	}

	public boolean getHasDetonator() {
		return this.hasDetonator;
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
		} else {
			this.dx = 2.5;
		}

	}

	public void setBomb() {
		if (!this.getWorld().getBombExists() || this.hasMultiBomb) {
			Bomb b = new Bomb(this.getWorld(), new Point2D.Double(this.x, this.y));
			this.getWorld().addGameObject(b);
			this.getWorld().addBombList(b);
			this.getWorld().setBombExists(true);
		}

	}

	/**
	 * Gives the hero another life and displays that life as a heart
	 *
	 */
	public void addLife() {
		this.lives++;
		int lastHeartX = (int) this.getWorld().getHearts().get(this.getWorld().getHearts().size() - 1).getCenterPoint()
				.getX();
		Heart h = new Heart(this.getWorld(), new Point2D.Double(lastHeartX + 50, 0));
		this.getWorld().addGameObject(h);
		this.getWorld().addHeart(h);

	}

	@Override
	public void updatePosition() {

		Point2D.Double myPoint = new Point2D.Double(x, y);

		this.x += this.dx;
		this.y += this.dy;

		this.setCenterPoint(myPoint);
		this.detectCollision();
	}

	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
		return myRect;
	}

	@Override
	public void die() {
		this.lives--;
		this.getWorld().removeGameObject(this.getWorld().getHearts().get(0));
		this.getWorld().removeHeart();
		this.getWorld().resetAllMonsters();
		this.reset();
		if (this.lives == 0) {
			this.lives = 3;
			this.getWorld().restart();
		}

	}

	@Override
	public void collide(GameObject m) {
		m.collideWithHero(this);
	}

	@Override
	public void collideWithWall(Wall w) {
		this.x -= this.dx;
		this.y -= this.dy;
		stopHero();
	}

	@Override
	public void collideWithBomb(Bomb b) {
		this.x -= this.dx;
		this.y -= this.dy;
		stopHero();
	}

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
		this.setName("hero");
	}

	@Override
	public void collideWithMonster(Monster m) {
		this.die();
		this.setName("hero");
	}

	@Override
	public void collideWithSpeedUp(SpeedUp s) {
		this.setIsFaster(true);
		this.setName("herospeedup");
	}

	@Override
	public void collideWithBombExpand(BombExpand b) {
		this.setHasExpandBomb(true);
		this.setName("herobombexpand");
	}

	@Override
	public void collideWithMultiBomb(MultiBomb m) {
		this.setMultiBomb(true);
		this.setName("heromultibomb");
	}

	@Override
	public void collideWithDetonator(Detonator d) {
		this.setHasDetonator(true);
		this.setName("herodetonator");
	}

	public void collideWithLifeUp(LifeUp l) {
		this.addLife();
		this.setName("hero");
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
		loadImage();
	}

}
