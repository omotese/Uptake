import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall implements Drawable {
	private Color wallColor;
	private double x;
	private double y;
	private GameWorld world;
	
	private int wallSize;
	
	public Wall(GameWorld world, double x, double y) {
		this.wallColor = Color.gray;
		this.x= x;
		this.y= y;
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
	


}
