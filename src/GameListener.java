import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {

	private GameWorld world;
	
	public GameListener( GameWorld gameWorld){
		
		this.world = gameWorld;
	}
	

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.world.getHero().moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.world.getHero().moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.world.getHero().moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.world.getHero().moveDown();
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			this.world.getHero().setBomb();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_U) {
			this.world.levelUp();
			}
		
		if (e.getKeyCode() == KeyEvent.VK_D) {
			this.world.levelDown();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_P) {
			this.world.togglePause();
		}
		
		if(this.world.getHero().getHasDetonator()) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				for(Bomb b: this.world.getBombList()){
					b.createExplosion();
					b.die();
				}
				
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		this.world.getHero().stopHero();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

}
