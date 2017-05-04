import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

public class PowerUp extends Block {

	private Color powerColor;
	private static final int SIZE = 30;
	
	public PowerUp(GameWorld world) {
		super(world);
		this.powerColor = Color.BLUE;
	}


	@Override
	public Color getColor() {
		return this.powerColor;
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
