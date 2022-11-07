package main;


// imports selction
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;


public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;

	
	

	


	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);

       // these are all the methods used to create the panel and the methods are below
		importImg();
		loadAnimations();


		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

  	private void loadAnimations() {
	animations = new BufferedImage[9][6];
	for (int j = 0; j < animations.length; j++)
		for (int i = 0; i < animations[j].length; i++)
			animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
}



	// importing player sprites which is characetr and this below is method 
	//acctually the image will be load in buffered image img which is called above 

     //calling in try and catch method to handle error if seen in future 
	 //if error is occur then it throws error
	 //it also help to know why the error occured 
	
	 private void importImg() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    


// this selction is used for setting up the panel of the screen in game which will be used all over the game 
private void setPanelSize() {
	Dimension size = new Dimension(1280, 800);
	setPreferredSize(size);
}


	// this is charcter moment speed which will be changed in future!!
	public void setDirection(int direction) {
		this.playerDir = direction;
		moving = true;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
		}

	}

	private void setAnimation() {
		if (moving)
			playerAction = RUNNING;
		else
			playerAction = IDLE;
	}

	private void updatePos() {
		if (moving) {
			switch (playerDir) {
			case LEFT:
				xDelta -= 5;
				break;
			case UP:
				yDelta -= 5;
				break;
			case RIGHT:
				xDelta += 5;
				break;
			case DOWN:
				yDelta += 5;
				break;
			}
		}
	}

	

	


	// calling the images 
	// sub images is slection the some portion of the image
	// for example there are more the 12differnt charcter style so we will select each portion and make it moviable so the 
	// animation looks smoother will playing it 
		

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateAnimationTick();
		setAnimation();
		updatePos();

		g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
	}
	
			
			
	
		




}

	// Temp
