package com.mygdx.game;

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

public class Title extends MyScreenAdapter {
	private static final String LOG_TAG = Title.class.getSimpleName();
    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    ShapeRenderer debugRenderer;
    private OrthographicCamera cam;
	private Viewport viewport;

    public Title(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
        debugRenderer = new ShapeRenderer();

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
    	//Gdx.app.log(LOG_TAG, "render");
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // カラーバッファをクリア
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			game.setScreen(new GameScreen(game));
        }
        batch.begin(); // 描画の開始
        font.getData().setScale(3f);
        font.draw(batch, "kimiyasu", 280, 410);
        font.getData().setScale(1f);
        font.draw(batch, "Game start", 365, 175);
        font.draw(batch, "Exit", 390, 115);
        batch.end(); // 描画の終了
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.rect(150, 350, 500,100);
        debugRenderer.rect(300, 150, 200,50);
        debugRenderer.rect(300, 90, 200,50);

        debugRenderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
			if(300<touchPoint.x && touchPoint.x<500){
				if(160>touchPoint.y && 115<touchPoint.y){
					game.setScreen(new Chara(game));
				}
			}
			if(300<touchPoint.x && touchPoint.x<500){
				if(110>touchPoint.y && 65<touchPoint.y){
					Gdx.app.exit();
					//System.out.println("bbb");
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
