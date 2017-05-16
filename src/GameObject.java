import java.awt.Color;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public abstract class GameObject implements Drawable, Temporal, Relocatable, Collision{
	private Point2D centerPoint;
	private boolean isPaused;
	private GameWorld world;
	private String name;
	private Color color;
	private int size;
	private Rectangle2D shape;
	

	public GameObject(GameWorld world,Point2D centerPoint) {
		this.centerPoint= centerPoint;
		this.world=world;
		this.name = "";
		this.isPaused = false;
		this.color = null;
		this.size = 0;
		this.shape= new Rectangle2D.Double(this.centerPoint.getX(), this.centerPoint.getY(), this.size, this.size);
	}
	//super methods----------------------------------------
		
	public String getName(){
		return this.name;
	}
	
	public void setColor(Color myColor) {
		this.color = myColor;
	}
	
	public GameWorld getWorld() {
		return this.world;
	}
	
	public void detectCollision(){
		for (int i = 0; i < this.getWorld().getObjectList().size(); i++) {
			if ((this.getWorld().getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.getWorld().getObjectList().get(i));
			}
		}
	}
	
	
	//Drawable----------------------------------------
	@Override
	public Color getColor() {
		return this.color;
	}

	
	@Override
	public Shape getShape() {
		return this.shape;
	}

	@Override
	public BufferedImage getImage() {
		String fileName = "images/" + this.getName();
		fileName += ".png";
		BufferedImage img = new BufferedImage(this.getSize(), this.getSize(), Transparency.OPAQUE);
		
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException e) {}
		return img;
		
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	//Temporal----------------------------------------

	@Override
	public void timePassed() {
		if(!isPaused){
			updateFuse();
			updateSize();
			updatePosition();
		}
	}


	@Override
	public boolean getIsPaused() {
		return isPaused;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
	@Override
	public void die() {
		this.getWorld().removeGameObject(this);
	}
	
	@Override
	public void updatePosition() {
		
	}
	
	@Override
	public void updateSize() {
		
	}
	
	@Override
	public void updateFuse() {
		
	}
	
	//Relocatable----------------------------------------
	@Override
	public void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}
	

	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}
	
	//Collision----------------------------------------
	@Override
	public void collide(GameObject o) {
	}

	@Override
	public void collideWithHero(Hero h) {
	}

	@Override
	public void collideWithPowerUp(PowerUp p) {
	}

	@Override
	public void collideWithMonster(Monster m) {
	}

	@Override
	public void collideWithSeeker(Seeker s) {
	}

	@Override
	public void collideWithWall(Wall w) {
	}

	@Override
	public void collideWithBomb(Bomb b) {
	}

	@Override
	public void collideWithExplosion(Explosion e) {
	}
}
