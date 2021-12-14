package com.duffaldri;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class StateManager {
	public State[] stateList;
	
	public int currentState;
	public int MENU = 0;
	public int GAME = 1;
	public int TOTALSTATES = 2;
	
	public StateManager() {
		stateList = new State[TOTALSTATES];
		currentState = GAME;
		loadState(currentState);
	}
	
	public void loadState(int state) {
		if(state == MENU) {
			stateList[state] = new MenuState();
		}
		
		if(state == GAME) {
			stateList[state] = new GameState();
		}
	}
	
	public void unloadState(int state) {
		stateList[state] = null;
	}
	
	public void setState(int nextState) {
		unloadState(currentState);
		loadState(nextState);
		currentState = nextState;
	}
	
	public void update() {
		stateList[currentState].update();
	}
	
	public void draw(Graphics g) {
		stateList[currentState].draw(g);
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
