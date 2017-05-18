import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Heart extends GameObject {

	public Heart(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(50);
	}

	@Override
	public String getName() {
		System.out.println("get heart name");
		return "heart";
	}
	
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(this.getCenterPoint().getX(), this.getCenterPoint().getY(), this.getSize(), this.getSize());
	}

}
