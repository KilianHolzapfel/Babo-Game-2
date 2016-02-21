package client.main.menu;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import client.resources.Res;

public class MainMenu implements MouseListener{
	
	private JFrame frame = null;
	
	public void initialize(){
		if (frame == null){
			frame = new JFrame();
			frame.setSize(Res.screen.monitorWidth, Res.screen.monitorHeight);
			frame.setResizable(false);
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			frame.setVisible(true);
			frame.addMouseListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.exit(0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
