package com.mygdx.game.musicplay;

public class GradeNum {
	public enum State{
		PLAYING, GAME_OVER, GAME_CLEAR
	}

	public static State state = State.PLAYING;
	public static int perfect;
	public static int great;
	public static int good;
	public static int miss;
	public static int combo;
	public static int score;

	public static int fullCombo;
}
