	import java.awt.geom.Point2D;
public abstract class Block extends GameObject {

		public Block(GameWorld world) {
			super(world);
		}
		
		public Block(GameWorld world, Point2D centerPoint) {
			super(world, centerPoint);
		}

		
}
