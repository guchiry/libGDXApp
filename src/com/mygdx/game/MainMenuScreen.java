package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends MyScreenAdapter {
    private static final String LOG_TAG = MainMenuScreen.class.getSimpleName();
	SpriteBatch batch;
	float alpha;
    BitmapFont font;
	public MainMenuScreen(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
		}
    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG, "resize");
    }
    @Override
    public void show(){
    	Gdx.app.log(LOG_TAG, "show");
    }
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // カラーバッファをクリア
        batch.begin(); // 描画の開始
        //font.setColor(Color.RED);
        font.getData().setScale(1f); 
        font.draw(batch, "play", 130, 110); 
        font.draw(batch, "normal", 230, 110);
        font.draw(batch, "hard", 340, 110);
        batch.end(); // 描画の終了
        Gdx.app.log(LOG_TAG, "render");
		//if (Gdx.input.justTouched()) {
			//game.setScreen(new GameScreen(game));
		//}
		
	}

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG, "hide");
        dispose();
    }

    @Override
    public void dispose() {
    	Gdx.app.log(LOG_TAG, "dispose");
    	batch.dispose();
        font.dispose();
    }
}