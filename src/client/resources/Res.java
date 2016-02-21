package client.resources;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Res {
	public static class draw {
		public static final String title = "Babo Game 2.0"; 
	}
	
	public static class string {
		public static final String ok = "Ok";
	}
	
	public static class error {
		public static final String errorFileNotFound = "Error: file not found ";
		public static final String errorFileNotRead = "Error: could not read File ";
	}
	
	public static class screen {
		
		public static int monitorWidth = 0;
		public static int monitorHeight = 0;
		
		static {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			monitorWidth = (int) screenSize.getWidth();
			monitorHeight = (int) screenSize.getHeight();
		}
	}
}
