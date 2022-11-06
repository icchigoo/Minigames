package main;

import java.awt.Graphics;


import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100;
	private int frames = 0;
	private long lastCheck = 0;
	
	public GamePanel() {
     
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		
	}
	
	public void setReactPos (int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		
		
	}
	
	public void paintComponenet(Graphics g ) {
		super.paintComponent(g);
		
		g.fillRect( xDelta,  yDelta, 200, 50);

		frames++;
		if(System.currentTimeMillis() - lastCheck >= 1000){
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS:" + frames);
			frames = 0;

		}
		repaint();
	}

	private void updateRectange(){
		
	}

}
