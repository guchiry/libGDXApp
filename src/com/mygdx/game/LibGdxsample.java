package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class LibGdxsample extends Game {
    public static final String LOG_TAG = LibGdxsample.class.getSimpleName();
    private Screen nextScreen;

    @Override
    public void create() {
        Gdx.app.log(LOG_TAG, "create");
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