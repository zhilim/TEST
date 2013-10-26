package com.example.gtest;

public class Player {
	private int centerX = 100;
	private int centerY = 360;
	
	private boolean jumped = false;
	private boolean xIsNearEdge = false;
	private boolean yIsNearEdge = false;
	
	private int speedX = 0;
	private int speedY = 1;
	
	public void update(){
		
		if(centerX + speedX < 648){
			centerX += speedX;
		}
		//Y position updates
		
		if(centerY + speedY >= 360){
			centerY = 360;
		}
		else{
			centerY += speedY;
		}
		
		if(jumped==true){
			speedY += 1;
			//stops the jump when it reaches the ground(of y = 382)
			if(centerY + speedY >= 360){
				centerY = 360;
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
		speedX = 6;
	}
	
	public void moveLeft(){
		speedX = -6;
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
	
	public boolean getxNearEdge(){
		return xIsNearEdge;
		
	}
	
	public int getSpeedX(){
		return speedX;
	}
	
	public int getSpeedY(){
		return speedY;
	}
}
