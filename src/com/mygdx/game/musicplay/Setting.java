package com.mygdx.game.musicplay;

public class Setting {
	public static final float LOGICAL_WIDTH = 800;
	public static final float LOGICAL_HEIGHT = 480;

	public static final float NOTES_SPEED = 2.4f;

	public static final float DICISION_FADE_TIME = 0.5f;

	public static final float MAX_DISTANCE = 1000f;
	public static final float SUCCESS_DISTANCE = 20f;
	public static final float MISS_DISTANCE = 35f;
	public static final float GOOD_DISTANCE = SUCCESS_DISTANCE;
	public static final float GREAT_DISTANCE = 10f;
	public static final float PERFECT_DISTANCE = 5f;

	public static final float BEFORE_PLAY_TIME = 3f;

	public static final float SCORE_UI_WIDTH =740-(80+72);

	public static final float ARRIVAL_TIME = SCORE_UI_WIDTH/NOTES_SPEED/60;
}
