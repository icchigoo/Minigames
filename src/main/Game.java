package main;

public class Game implements Runnable {


	//creating game loop to run chracter and render and to know about the fps of the game 
    
	// creatd private method for game window, panela and fps
	// fps is set to maximun final 120 fps and the higher the fps the smoother the game will be 
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
     

	//so here i am creating a game loop 
	// game panel 
	public Game() {

		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();

	}

	//here will the game panel be start

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}


	@Override
	public void run() {

		// setting th timer per sec and last frame 

		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();

		int frames = 0;
		long lastCheck = System.currentTimeMillis();

		while (true) {

			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}

	}

}
