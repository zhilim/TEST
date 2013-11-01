package com.example.gtest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

//this is the bitset implementation that allows for very responsive controls
//this also allows detection of multiple key presses.
//this shit is awesome;
public class KeyHandler implements KeyListener {
	
	private BitSet keyBits = new BitSet(256);

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keyBits.set(keyCode);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keyBits.clear(keyCode);
		
	}
	
	public boolean isKeyPressed(int keyCode){
		return keyBits.get(keyCode);
	}
	
	

}
