package com.example.gtest;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class World extends Applet implements Runnable{
	
	private Player player;
	private MiddleGround mG;
	private BackGround bg;
	private Image image, character, middleGround, backGround;
	private Graphics second;
	private URL base;
	private KeyHandler key;

	@Override
	public void init(){
		//set up the window, size, bg, attach listener etc.
		setSize(800,480);
		setBackground(Color.WHITE);
		setFocusable(true);
		key = new KeyHandler();
		addKeyListener(key);//so we add a keylistener to key instead of the applet;
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
		
		
	}
	
	@Override
	public void start(){
		
		player = new Player();
		player.initialize(base, this);
		character = player.currentAnimator.getImage();
		bg = new BackGround();
		mG = new MiddleGround();
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true){
			checkKeyHandler();
			player.update();
			character = player.currentAnimator.getImage();
			bg.update(player.getSpeedX(), player.getSpeedY(), player.getxNearEdge());
			mG.update(player.getSpeedX(), player.getSpeedY(), player.getxNearEdge());
			animate();
			repaint();
			try{
				Thread.sleep(17);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void animate(){
		player.currentAnimator.update(10);
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

	
	private void checkKeyHandler(){
		
		if(key.isKeyPressed(KeyEvent.VK_SHIFT)){
			player.setRunning(true);
		}
		
		if(!key.isKeyPressed(KeyEvent.VK_SHIFT)){
			player.setRunning(false);
			
		}
		
		if(key.isKeyPressed(KeyEvent.VK_A) && !key.isKeyPressed(KeyEvent.VK_D)){
				player.moveLeft();
			
		}
		
		if(key.isKeyPressed(KeyEvent.VK_D) && !key.isKeyPressed(KeyEvent.VK_A)){			
				player.moveRight();
			
		}
		
		if(key.isKeyPressed(KeyEvent.VK_SPACE)){		
			player.jump();
		}
		
		if(!key.isKeyPressed(KeyEvent.VK_A) && !key.isKeyPressed(KeyEvent.VK_D)){		
			player.stop();
			
		}
		
		
	}

	
}