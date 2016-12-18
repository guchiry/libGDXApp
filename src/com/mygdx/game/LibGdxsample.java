package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import java.util.Set;
import java.util.HashSet;

public class LibGdxsample extends Game {
    public static final String LOG_TAG = LibGdxsample.class.getSimpleName();
    // 16:9
    public static int LOGICAL_WIDTH = 256;
    public static int LOGICAL_HEIGHT = 144;
    // 4:3
    // public static int LOGICAL_WIDTH = 256;
    // public static int LOGICAL_HEIGHT = 192;
    private Screen nextScreen;
    private Setting settings;
    //NullPointerException null;
    public boolean seOn() {
        return settings.seOn();
    }

    public boolean bgmOn() {
        return settings.bgmOn();
    }

    public int hiscore() {
        return settings.hiscore();
    }

    public void toggleSeOn() {
        settings.toggleSeOn();
    }

    public void toggleBgmOn() {
        settings.toggleBgmOn();
    }

    public void hiscore(int score) {
        settings.hiscore(score);
    }

    @Override
    public void create() {
       // null = new NullPointerException();
        Gdx.app.log(LOG_TAG, "create");
        settings = new Setting();
        setScreen(new Title(this));
    }

    @Override
    public void render() {
        super.render();
        if (nextScreen != null) {
            super.setScreen(nextScreen);
            nextScreen = null;
        }
    }

    @Override
    public void setScreen (Screen screen) {
        Gdx.app.log(LOG_TAG, "setScreen");
        try{
        	nextScreen = screen;
        }catch(NullPointerException e){
        	
        }
    }

    @Override
    public void dispose() {
        //super.dispose();
        Gdx.app.log(LOG_TAG, "dispose");
    }
}