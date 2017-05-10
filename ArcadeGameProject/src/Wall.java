import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends GameObject {
	private Color wallColor;
	private double x;
	private double y;
	private GameWorld world;
	private Point2D centerPoint;
	private int wallSize;
	
	public Wall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.wallColor = Color.gray;
		this.x= this.getCenterPoint().getX();
		this.y= this.getCenterPoint().getY();
		this.wallSize=50;
	}
	
	public Shape getShape(){
		Rectangle2D.Double myRect= new Rectangle2D.Double(x,y,wallSize,wallSize);
		return myRect ;
	}
	
	public boolean isWithin(double xCheck, double yCheck){
		if(this.x<=xCheck && xCheck<=this.x+50 && this.y<=yCheck && yCheck <=this.y+50) {
			return true;
		}
		return false;
		
	}
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return wallColor;
	}
	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateSize() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateColor() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void collide(GameObject m) {
		m.collideWithWall(this);
				//System.out.println("wall2 colide");
		
	}
	@Override
	public void collideWithHero(Hero h) {
		h.collideWithWall(this);
		
	}
	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithWall(this);
		
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
	


}
