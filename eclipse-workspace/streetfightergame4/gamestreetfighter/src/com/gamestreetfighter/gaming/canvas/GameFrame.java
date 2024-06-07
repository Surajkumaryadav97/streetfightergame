package com.gamestreetfighter.gaming.canvas;

import java.io.IOException;

import javax.swing.JFrame;

import com.gamestreetfighter.gaming.utils.GameContants;

public class GameFrame extends JFrame implements GameContants {
	public GameFrame() throws IOException {
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(GWIDTH,GHEIGHT);
		setLocationRelativeTo(null);
		Board board=new Board();
		add(board);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		try {
			GameFrame obj=new GameFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
