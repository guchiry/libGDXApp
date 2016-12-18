package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Setting {
	public static final float LOGICAL_WIDTH = 800;
	public static final float LOGICAL_HEIGHT = 480;

	public static final float NOTES_SPEED = 2.4f;

	public static final float DICISION_FADE_TIME = 0.5f;

	public static final float MAX_DISTANCE = 1000f;
	public static final float SUCCESS_DISTANCE = 30f;
	public static final float MISS_DISTANCE = 50f;
	public static final float GOOD_DISTANCE = SUCCESS_DISTANCE;
	public static final float GREAT_DISTANCE = 20f;
	public static final float PERFECT_DISTANCE = 10f;
	private static final String NAME = "com.zarudama.fishcatch";
    private static final String KEY_SE_ON = "seOn";
    private static final String KEY_BGM_ON = "bgmOn";
    private static final String KEY_HISCORE = "hiscore";
    private static final boolean DEFAULT_SE_ON = true;
    private static final boolean DEFAULT_BGM_ON = true;
    private static final int DEFAULT_HISCORE = 0;

	public static final int ALL_NUMBER = 1;
	private Preferences mPrefs;
	public boolean seOn() {
        return mPrefs.getBoolean(KEY_SE_ON, DEFAULT_SE_ON);
    }
    public boolean bgmOn() {
        return mPrefs.getBoolean(KEY_BGM_ON, DEFAULT_BGM_ON);
    }
    public int hiscore() {
        return mPrefs.getInteger(KEY_HISCORE, DEFAULT_HISCORE);
    }
    public void toggleSeOn() {
        mPrefs.putBoolean(KEY_SE_ON, !seOn());
        mPrefs.flush();
    }
    public void toggleBgmOn() {
        mPrefs.putBoolean(KEY_BGM_ON, !bgmOn());
        mPrefs.flush();
    }
    public void hiscore(final int aScore) {
        mPrefs.putInteger(KEY_HISCORE, aScore);
        mPrefs.flush();
    }
}
