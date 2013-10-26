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
	private MiddleGround mG;
	private BackGround bg;
	private Image image, character, middleGround, backGround;
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
		
		backGround = getImage(base, "drawable/bluesky0000.png");
		middleGround = getImage(base, "drawable/tatlandscape0000.png");
		character = getImage(base, "drawable/warrior0000.png");
		
	}
	
	@Override
	public void start(){
		player = new Player();
		bg = new BackGround();
		mG = new MiddleGround();
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true){
			player.update();
			bg.update(player.getSpeedX(), player.getSpeedY(), player.getxNearEdge());
			mG.update(player.getSpeedX(), player.getSpeedY(), player.getxNearEdge());
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
		g.drawImage(backGround, bg.getX(), bg.getY(), this);
		g.drawImage(middleGround, mG.getX(), mG.getY(), this);
		g.drawImage(character, player.getCenterX(), player.getCenterY(), this);
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