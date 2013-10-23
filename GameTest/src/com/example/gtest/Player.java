package com.example.gtest;

public class Player {
	private int centerX = 100;
	private int centerY = 380;
	
	private boolean jumped = false;
	
	private int speedX = 0;
	private int speedY = 1;
	
	public void update(){
		
		if(centerX < 800){
			centerX += speedX;
		}
		
		
		
		//Y position updates
		
		if(centerY + speedY >= 382){
			centerY = 382;
		}
		else{
			centerY += speedY;
		}
		
		if(jumped==true){
			speedY += 1;
			//stops the jump when it reaches the ground(of y = 382)
			if(centerY + speedY >= 382){
				centerY = 381;
				speedY = 0;
				jumped = false;
			}
		}
		//stops movement out of left screen
		if(centerX + speedX <= 60){
			centerX = 61;
		}
		//anti-clipping
		if(centerX >= 800){
			centerX = 799;
		}
		
		
	}
	
	public void moveRight(){
		speedX = 3;
	}
	
	public void moveLeft(){
		speedX = -3;
	}
	
	public void stop(){
		speedX = 0;
	}
	
	public void jump(){
		if(jumped==false){
			speedY = -15;
			jumped = true;
		}
	}
	
	public int getCenterX(){
		return centerX;
	}
	
	public int getCenterY(){
		return centerY;
	}
}
