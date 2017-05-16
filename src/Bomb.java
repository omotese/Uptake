import java.awt.Color;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bomb extends GameObject {
	private double x;
	private double y;
	private double size;
	private String name;
	private Color color;

	private double maxSize;
	private boolean mySize;
	private boolean hitExplosion;

	public Bomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.name = "bomb";
		this.size = 30;
		this.maxSize = 130;
		this.hitExplosion = false;
		this.color = Color.WHITE;

		this.x = Math.round((this.getCenterPoint().getX()) / 50) * 50 + 10;
		this.y = Math.round((this.getCenterPoint().getY()) / 50) * 50 + 10;

		//need to be moved to somewhere else
		//created method increaseMaxSize
		if (this.getWorld().getHero().getHasExpandBombPowerUp() == true) {
			this.maxSize = 230;
		}

		//should not be implemented here
		this.getWorld().bombExists = true;
	}

	// Drawable--------------------------------------
	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.size, this.size);
		return myRect;
	}
	
	// Temporal--------------------------------------
	@Override
	public void updateSize() {
		if (size >= maxSize || this.hitExplosion) {
			System.out.println(this.hitExplosion);
			Explosion exp = new Explosion(this.getWorld(), new Point2D.Double(x, y));
			// System.out.println("max"+maxSize);
			this.getWorld().addGameObject(exp);
			this.die();
			this.getWorld().bombExists = false;

		} else {
			size += .6;
		}

	}

	@Override
	public void updatePosition() {
		if (size <= maxSize) {
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
