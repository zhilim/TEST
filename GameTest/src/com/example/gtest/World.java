package com.example.gtest;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class World extends Applet implements Runnable, KeyListener{
	
	private Player player;
	private Image image, character;
	private Graphics second;
	private URL base;

	@Override
	public void init(){
		//set up the window, size, bg, attach listener etc.
		setSize(800,480);
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame)this.getParent().getParent();
		frame.setTitle("New Game");
		//create URL base so we can access URL addresses programmatically.
		try{
			base = getDocumentBase();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		character = getImage(base, "drawable/redwin.png");
		
	}
	
	@Override
	public void start(){
		player = new Player();
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true){
			player.update();
			repaint();
			try{
				Thread.sleep(17);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void update(Graphics g){
		if(image == null){
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		g.drawImage(image, 0, 0, this);
		
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(character, player.getCenterX() - 61, player.getCenterY() - 63, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
		
		case KeyEvent.VK_W:
			break;
		
		case KeyEvent.VK_S:
			break;
		
		case KeyEvent.VK_A:
			player.moveLeft();
			break;
			
		case KeyEvent.VK_D:
			player.moveRight();
			break;
			
		case KeyEvent.VK_SPACE:
			player.jump();
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()){
		
		case KeyEvent.VK_W:
			break;
		
		case KeyEvent.VK_S:
			break;
		
		case KeyEvent.VK_A:
			player.stop();
			break;
			
		case KeyEvent.VK_D:
			player.stop();
			break;
			
		case KeyEvent.VK_SPACE:
			
			break;
		}
		
	}

	
}