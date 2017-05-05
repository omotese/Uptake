import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroListener implements KeyListener {
	private GameWorldComponent component;
	private Hero myHero;

	
	public HeroListener(Hero hero, GameWorldComponent comp) {
		this.myHero = hero;
		this.component = comp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub.
		if (e.getKeyCode() == KeyEvent.VK_W) {
			myHero.moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			myHero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			myHero.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			myHero.moveUp();
		}
	}

	//need a listener for setting bomb
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
