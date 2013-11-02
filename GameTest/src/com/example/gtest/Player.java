package com.example.gtest;

import java.applet.Applet;
import java.awt.Image;
import java.net.URL;

public class Player {
	
    int GROUND = 316;
	final int MOVESPEED = 3;
	final int JUMPSPEED = -20;
	final int RUNSPEED = 7;
	
	
	private int centerX = 100;
	private int centerY = GROUND;
	
	private boolean jumped = false;
	private boolean xIsNearEdge = false;
	private boolean yIsNearEdge = false;
	private boolean isRunning = false;
	
	private int speedX = 0;
	private int speedY = 1;
	
	private Image stand0, stand1, walk0, walk1, walk2, walk3, walk4, walk5, walk6, walk7, walk8, walk9, crouch0, crouch1; 
	private Image run0, run1, run2, run3, run4, run5, run6, run7, run8, run9, run10, run11;
	private Image runleft0, runleft1, runleft2, runleft3, runleft4, runleft5, runleft6, runleft7, runleft8, runleft9, runleft10, runleft11;
	private Animator walking, standing, walkingLeft, standingLeft, running, runningLeft, crouching, crouchingLeft;
	public Animator currentAnimator;
	
	
	public void initialize(URL base, Applet applet){
		//gathering of assets.
		crouch0 = applet.getImage(base, "drawable/warriorcrouch0000.png");
		crouch1 = applet.getImage(base, "drawable/warriorcrouchleft0000.png");
		stand0 = applet.getImage(base, "drawable/warrior0000.png");
		walk0 = applet.getImage(base, "drawable/warrior0001.png");
		walk1 = applet.getImage(base, "drawable/warrior0002.png");
		walk2 = applet.getImage(base, "drawable/warrior0003.png");
		walk3 = applet.getImage(base, "drawable/warrior0004.png");
		walk4 = applet.getImage(base, "drawable/warrior0005.png");
		
		walk5 = applet.getImage(base, "drawable/warriorleft0001.png");
		walk6 = applet.getImage(base, "drawable/warriorleft0002.png");
		walk7 = applet.getImage(base, "drawable/warriorleft0003.png");
		walk8 = applet.getImage(base, "drawable/warriorleft0004.png");
		walk9 = applet.getImage(base, "drawable/warriorleft0005.png");
		stand1 = applet.getImage(base, "drawable/warriorleft0000.png");
		
		run0 = applet.getImage(base, "drawable/warriorRun/warriorrun0000.png");
		run1 = applet.getImage(base, "drawable/warriorRun/warriorrun0001.png");
		run2 = applet.getImage(base, "drawable/warriorRun/warriorrun0002.png");
		run3 = applet.getImage(base, "drawable/warriorRun/warriorrun0003.png");
		run4 = applet.getImage(base, "drawable/warriorRun/warriorrun0004.png");
		run5 = applet.getImage(base, "drawable/warriorRun/warriorrun0005.png");
		run6 = applet.getImage(base, "drawable/warriorRun/warriorrun0006.png");
		run7 = applet.getImage(base, "drawable/warriorRun/warriorrun0007.png");
		run8 = applet.getImage(base, "drawable/warriorRun/warriorrun0008.png");
		run9 = applet.getImage(base, "drawable/warriorRun/warriorrun0009.png");
		run10 = applet.getImage(base, "drawable/warriorRun/warriorrun0010.png");
		run11 = applet.getImage(base, "drawable/warriorRun/warriorrun0011.png");
		
		runleft0 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0000.png");
		runleft1 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0001.png");
		runleft2 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0002.png");
		runleft3 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0003.png");
		runleft4 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0004.png");
		runleft5 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0005.png");
		runleft6 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0006.png");
		runleft7 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0007.png");
		runleft8 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0008.png");
		runleft9 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0009.png");
		runleft10 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0010.png");
		runleft11 = applet.getImage(base, "drawable/warriorRun/warriorrunleft0011.png");
		
		
		standingLeft = new Animator();
		standingLeft.addFrame(stand1, 100);
		
		walkingLeft = new Animator();
		walkingLeft.addFrame(walk5, 100);
		walkingLeft.addFrame(walk6, 100);
		walkingLeft.addFrame(walk7, 100);
		walkingLeft.addFrame(walk8, 100);
		walkingLeft.addFrame(walk9, 100);
		
		
		standing = new Animator();
		standing.addFrame(stand0, 100);
		standing.addFrame(stand0, 100);
		
		
		walking = new Animator();
		walking.addFrame(walk0, 100);
		walking.addFrame(walk1, 100);
		walking.addFrame(walk2, 100);
		walking.addFrame(walk3, 100);
		walking.addFrame(walk4, 100);
		
		running = new Animator();
		running.addFrame(run0, 30);
		running.addFrame(run1, 30);
		running.addFrame(run2, 30);
		running.addFrame(run3, 30);
		running.addFrame(run4, 30);
		running.addFrame(run5, 30);
		running.addFrame(run6, 30);
		running.addFrame(run7, 30);
		running.addFrame(run8, 30);
		running.addFrame(run9, 30);
		running.addFrame(run10, 30);
		running.addFrame(run11, 30);
		
		runningLeft = new Animator();
		runningLeft.addFrame(runleft0, 30);
		runningLeft.addFrame(runleft1, 30);
		runningLeft.addFrame(runleft2, 30);
		runningLeft.addFrame(runleft3, 30);
		runningLeft.addFrame(runleft4, 30);
		runningLeft.addFrame(runleft5, 30);
		runningLeft.addFrame(runleft6, 30);
		runningLeft.addFrame(runleft7, 30);
		runningLeft.addFrame(runleft8, 30);
		runningLeft.addFrame(runleft9, 30);
		runningLeft.addFrame(runleft10, 30);
		runningLeft.addFrame(runleft11, 30);
		
		crouching = new Animator();
		crouching.addFrame(crouch0, 100);
		
		crouchingLeft = new Animator();
		crouchingLeft.addFrame(crouch1, 100);
	
		//current sprite is set here.
		currentAnimator = standing;
		
	}
	//coordinate updates.
	public void update(){
		
		if(centerX + speedX < 648){
			centerX += speedX;
		}
		//Y position updates
		
		if(centerY + speedY >= GROUND){
			centerY = GROUND;
		}
		else{
			centerY += speedY;
		}
		
		if(jumped==true){
			speedY += 1;
			//stops the jump when it reaches the ground(of y = 382)
			if(centerY + speedY >= GROUND){
				centerY = GROUND;
				speedY = 0;
				jumped = false;
			}
		}
		//stops movement out of left screen
		if(centerX + speedX <= 60){
			centerX = 61;
		}
		//anti-clipping
		if(centerX + speedX >= 648){
			centerX = 647;
		}
		
		if(centerX + speedX <= 70 || centerX + speedX >= 648){
			xIsNearEdge = true;
		}
		
		else if(centerX + speedX > 70 && centerX + speedX < 648){
			xIsNearEdge = false;
		}
		
		
	}
	
	public void moveRight(){
		if(!isRunning){
			speedX = MOVESPEED;
			currentAnimator = walking;
		}
		
		if(isRunning){
			speedX = RUNSPEED;
			currentAnimator = running;
		}
		
		
	}
	
	
	public void moveLeft(){
		if(!isRunning){
			speedX = -MOVESPEED;
			currentAnimator = walkingLeft;
		}
		
		if(isRunning){
			speedX = -RUNSPEED;
			currentAnimator = runningLeft;
			
		}
		
		
	}
	
	//this prevents player from cocking himself up with contradicting keypresses.
	public void stop(){
		
			speedX = 0;
			if(currentAnimator == walking || currentAnimator == running || currentAnimator == crouching)
				currentAnimator = standing;
			if(currentAnimator == walkingLeft || currentAnimator == runningLeft || currentAnimator == crouchingLeft)
				currentAnimator = standingLeft;
	
			walking.resetFrames();
			walkingLeft.resetFrames();
			running.resetFrames();
			runningLeft.resetFrames();
		
		
		
	}
	
	public void jump(){
		if(jumped==false){
			speedY = JUMPSPEED;
			jumped = true;
		}
	}
	
	public void crouch(){
		speedX = 0;
	
		if(currentAnimator == walking || currentAnimator == running || currentAnimator == standing || currentAnimator == crouching){
			currentAnimator = crouching;
		}
		
		if(currentAnimator == walkingLeft || currentAnimator == runningLeft || currentAnimator == standingLeft || currentAnimator == crouchingLeft){
			currentAnimator = crouchingLeft;
		}
	}
	
	public void crouchRight(){
		speedX = 0;
		currentAnimator = crouching;
	}
	
	public void crouchLeft(){
		speedX = 0;
		currentAnimator = crouchingLeft;
	}
	
	
	//standard getters and setters.
	public int getCenterX(){
		return centerX;
	}
	
	public int getCenterY(){
		return centerY;
	}
	
	public boolean getxNearEdge(){
		return xIsNearEdge;
		
	}
	
	public int getSpeedX(){
		return speedX;
	}
	
	public int getSpeedY(){
		return speedY;
	}
	
	
	public void setRunning(boolean bool){
		this.isRunning = bool;
	}
	
	public boolean getRunning(){
		return isRunning;
	}
	
}
