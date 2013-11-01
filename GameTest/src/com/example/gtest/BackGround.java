package com.example.gtest;

public class BackGround{
	
	private int x = -400;
	private int y = 0;
	
	private boolean endOfMap = false;
	
	private int mgSpeedX = 0;
	private int mgSpeedY = 0;
	//left out y qualifier for simplicity's sake
	public void update(int speedX, int speedY, boolean xIsNearEdge){
		
		if(this.x >= 0){
			this.x = 0;
		}
		
		if(this.x <= -800){
			this.x = -800;
		}
		
		if(!xIsNearEdge){
			this.mgSpeedX = 0;
			this.mgSpeedY = 0;
		}
		
		else{
			this.mgSpeedX = speedX/2;
			this.mgSpeedY = 0;
			
			this.x -= this.mgSpeedX;
			this.y -= this.mgSpeedY;
		}
		
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}

	
}
