package client;

import client.main.menu.MainMenu;

public class MainClass {
	public static void main(String[] args){
		initialize();
	}
	
	private static void initialize(){
		MainMenu mainMenu = new MainMenu();
		mainMenu.initialize();
	}
}
