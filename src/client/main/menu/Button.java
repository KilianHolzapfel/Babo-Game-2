package client.main.menu;

import java.awt.image.BufferedImage;

public class Button {
	
	private int width;
	private int height;
	
	private BufferedImage image = null;
	
	public Button(int left, int top, int width, int height, String file){
		this.width = width;
		this.height = height;
	}
}
