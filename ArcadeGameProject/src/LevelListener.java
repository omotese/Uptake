import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LevelListener implements KeyListener {
	private int levelNum;
	
	public LevelListener(int level){
		this.levelNum= level;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub.
		if (e.getKeyCode() == KeyEvent.VK_U) {
			if(levelNum>=1&&levelNum<3){
			this.levelNum++;
			System.out.println(levelNum);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if(levelNum>1 && levelNum <= 3){
				
			this.levelNum--;
			System.out.println(levelNum);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

}