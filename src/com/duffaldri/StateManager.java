package com.duffaldri;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class StateManager {
	public State[] stateList;
	
	public int currentState;
	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int TOTALSTATES = 2;
	
	private int highscore;
	
	public StateManager() {
		stateList = new State[TOTALSTATES];
		currentState = MENU;
		this.highscore = 0;
		loadState(currentState);
	}
	
	public void loadState(int state) {
		if(state == MENU) {
			stateList[state] = new MenuState(this);
		}
		
		if(state == GAME) {
			stateList[state] = new GameState(this);
		}
	}
	
	public void unloadState(int state) {
		stateList[state] = null;
	}
	
	public void setState(int nextState) {
		if(this.currentState == nextState) {
			unloadState(currentState);
			loadState(nextState);			
		} else {
			loadState(nextState);
			unloadState(currentState);
		}
		this.currentState = nextState;
	}
	
	public void update() {
		stateList[currentState].update();
	}
	
	public void draw(Graphics g) {
		stateList[currentState].draw(g);
	}
	
	public int getHighscore() {
		return this.highscore;
	}
	
	public void mouseDragged(MouseEvent e) {
		stateList[currentState].mouseDragged(e);
		
	}

	public void mouseMoved(MouseEvent e) {
		stateList[currentState].mouseMoved(e);
	}

	
	public void mouseClicked(MouseEvent e) {
		stateList[currentState].mouseClicked(e);
	}

	
	public void mousePressed(MouseEvent e) {
		stateList[currentState].mousePressed(e);
	}

	
	public void mouseReleased(MouseEvent e) {
		stateList[currentState].mouseReleased(e);
	}

	
	public void mouseEntered(MouseEvent e) {
		stateList[currentState].mouseEntered(e);
	}

	
	public void mouseExited(MouseEvent e) {
		stateList[currentState].mouseExited(e);
	}
}
