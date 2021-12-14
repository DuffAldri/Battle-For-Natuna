package com.duffaldri;

public class StateManager {
	public State[] stateList;
	
	public int currentState;
	public int MENU = 0;
	public int GAME = 1;
	public int TOTALSTATES = 2;
	
	public StateManager() {
		stateList = new State[TOTALSTATES];
		currentState = MENU;
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
}
