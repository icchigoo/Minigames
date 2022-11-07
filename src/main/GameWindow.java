// package main;

// import javax.swing.JFrame;

// public class GameWindow {
// 	private JFrame jframe;

// 	public GameWindow(GamePanel gamePanel) {

// 		jframe = new JFrame();
//  // this class is used for giving the order to the sceen to do waht after each proess
		
// 		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		//app will be closed after pressing exit will not run on background 

// 		jframe.add(gamePanel);

// 		// game panel is added in j frame.
// 		jframe.setLocationRelativeTo(null);

// 		//location is set fixed 
// 		jframe.setResizable(false);

// 		//size resizable is set to false so that sccreeen cannot be reizse as it will be fixed 
// 		jframe.pack();

// 		//ecevrything will be visible from here
// 		jframe.setVisible(true);

// 	}

// }

package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;

	public GameWindow(GamePanel gamePanel) {

		jframe = new JFrame();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);
		jframe.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}

