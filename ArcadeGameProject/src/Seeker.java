import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Seeker extends Monster {
	private Point2D centerPoint;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int size;
	//private int cx;
	//private int cy;
	private boolean movingX;


	public Seeker(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.x = (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
		this.dx=0;
		this.dy=0;
		this.size = 40;
		
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}
	
	/*public Point2D reset(){
		return new Point2D.Double(this.x, this.y);
	}*/
	
	@Override
	public void updatePosition() {
		System.out.println("update position seeker");
		movingX=!movingX;

		this.detectHero();
		
		
		if(movingX){
		this.x += this.dx;
		}
		else{
		this.y += this.dy;
		}
		Point2D newPoint = new Point2D.Double(this.x, this.y);
		super.setCenterPoint(newPoint);

		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
			}
		}
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, this.size, this.size);
	}

	

	
	public void detectHero(){
		Point2D heroPosition = this.world.getHero().getCenterPoint();

		if(Math.abs(heroPosition.getX()-this.getCenterPoint().getX()) < 150
				&& (Math.abs(heroPosition.getY()-this.getCenterPoint().getY()) < 150)){
			if(heroPosition.getX()<this.getCenterPoint().getX()){
				this.dx = -1;
			}else{
				this.dx = 1;
			}
			if(heroPosition.getY()-this.getCenterPoint().getY()<0){
				this.dy = -1;
			}
			else{
				this.dy = 1;
			}
		}else{
//				this.dx = 0;
//				this.dy = 0;
			}
		System.out.println(x+" "+ y);	

		System.out.println(dy+" "+ dx);	
	}
	@Override
	public void collideWithWall(Wall w) {
		
		if(movingX){
			this.x -= this.dx;
			this.dx = 0;
		}
		else{
		this.y -= this.dy;
	
		this.dy = 0;}
		
		//System.out.println("m+w " + dx + " " + dy);

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		collideWithWall(b);

	}
	

}
