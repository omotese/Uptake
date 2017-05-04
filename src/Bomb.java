import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class Bomb extends Block {

	private Color blockColor;
	private static final int SIZE = 30;
	
	public Bomb(GameWorld world) {
		super(world);
		this.blockColor = Color.red;
	}


	@Override
	public Color getColor() {
		return this.blockColor;
	}

	@Override
	public void updateSize() {
		
	}


	@Override
	public void updateColor() {
		
	}


	@Override
	public double getDiameter() {
		return SIZE;
	}


	@Override
	public void updatePosition() {
		
	}

	

}
