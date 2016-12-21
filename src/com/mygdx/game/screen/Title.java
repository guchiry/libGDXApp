package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.LibGdxsample;
import com.mygdx.game.musicplay.Setting;
import com.mygdx.game.play.GameScreen;

public class Title extends MyScreenAdapter {
	private static final String LOG_TAG = Title.class.getSimpleName();
    SpriteBatch batch;
    Texture img1;
    Texture img2;
    BitmapFont font;
    ShapeRenderer debugRenderer;
    private OrthographicCamera cam;
	private Viewport viewport;

    public Title(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
        debugRenderer = new ShapeRenderer();
        img1 = new Texture("res/start.png");
        img2 = new Texture("res/exit.png");
		}
    @Override
    public void resize(int width, int height) {
		viewport.update(width, height);
	}

    @Override
    public void show () {
    	Gdx.app.log(LOG_TAG, "show");
    	this.cam = new OrthographicCamera(Setting.LOGICAL_WIDTH, Setting.LOGICAL_HEIGHT);
		this.cam.position.set(Setting.LOGICAL_WIDTH/2, Setting.LOGICAL_HEIGHT/2, 0);
		viewport = new FitViewport(Setting.LOGICAL_WIDTH, Setting.LOGICAL_HEIGHT, cam);

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // カラーバッファをクリア
        this.cam.update();
    	batch.setProjectionMatrix(cam.combined);
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			game.setScreen(new GameScreen(game));
        }
        batch.begin(); // 描画の開始
        font.getData().setScale(3f);
        font.draw(batch, "kimiyasu", 280, 410);
        batch.draw(img1, 330, 150);
        batch.draw(img2, 330, 100);
        font.getData().setScale(1f);
        batch.end(); // 描画の終了
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.rect(150, 350, 500,100);

        debugRenderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
			if(345<touchPoint.x && touchPoint.x<435){
				if(185>touchPoint.y && 150<touchPoint.y){
					game.setScreen(new SongSelectDisplay(game));
				}
			}
			if(360<touchPoint.x && touchPoint.x<430){
				if(140>touchPoint.y && 105<touchPoint.y){
					System.out.println("aaa");
					Gdx.app.exit();
				}
			}

		}
    }
    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG, "hide");
        dispose();
    }
    @Override
    public void dispose() {
    	 Gdx.app.log(LOG_TAG, "dispose");
    font.dispose();
    batch.dispose();
    debugRenderer.dispose();
    }

}
