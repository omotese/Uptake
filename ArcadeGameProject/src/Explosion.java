import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Explosion extends Bomb {
	private int size;
	private double x;
	private double y;
	private Color explosionColor;
	private int fuse;
	private GameWorld world;

	public Explosion(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.size = 130;
		if(this.getWorld().getHero().hasExpandBombPowerUp() == true) {
			this.size = 230;
		}
		this.x=this.getCenterPoint().getX();
		this.y=this.getCenterPoint().getY();
		this.explosionColor = Color.pink;
		this.fuse = 50;
	}
	
	
	public void updateFuse(){
		for (int i = 0; i < this.world.getBombList().size(); i++) {
			if ((this.world.getBombList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getBombList().get(i).getShape())) {
				this.collide(this.world.getBombList().get(i));
				//System.out.println("any colide");
			}
		}
		this.fuse--;
		if(fuse<=0){
			this.die();
		}
	}
	
	@Override
	public void updatePosition(){
		updateFuse();
	}
	
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}
	
	public void setSize(int s){
		this.size = s;
	}
	
	@Override
	public Color getColor(){
		return this.explosionColor;
	}
	
	@Override 
	public void collide(GameObject o){
		o.collideWithExplosion(this);
		//System.out.println("ahhhh");
	}
	
	
	@Override
	public void collideWithHero(Hero h ) {
		h.collideWithExplosion(this);
	}
	
	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithExplosion(this);
	}
	
	@Override
	public void collideWithSeeker(Seeker s) {
		s.collideWithExplosion(this);
	}
	
	
	
	@Override
	public void collideWithBreakable(BreakableWall b) {
		b.collideWithExplosion(this);
	}
	
	public void collideWithBomb(Bomb b){
		b.collideWithExplosion(this);
	}
	
	
	

}
