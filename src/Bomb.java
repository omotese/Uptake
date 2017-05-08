import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Bomb extends Block {
	private double x;
	private double y;
	private double size;
	private int fuse;

	public Bomb(GameWorld world, Point2D centerPoint){
		super(world,centerPoint);
		this.size = 30;
		//maybe for a fun extra thing we could make the bombs grow before they explode
		this.x = centerPoint.getX()+10;
		this.y = centerPoint.getY()+10;
		this.fuse = 300;
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public double getDiameter() {
		return this.size;
	}

	@Override
	public void updatePosition() {

	}

	public void updateFuse() {
		fuse--;
		if(fuse==0) {
			this.die();
		}
	}
	
	public Shape getShape() {
		return new Ellipse2D.Double(x, y, size, size);
	}

	@Override
	public void updateSize() {
		updateFuse();
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}



	@Override
	void collide(GameObject m) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	void collideWithHero(Hero m) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.
		
	}

}
