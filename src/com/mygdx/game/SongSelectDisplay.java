package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SongSelectDisplay extends MyScreenAdapter {
	private static final String LOG_TAG = SongSelectDisplay.class.getSimpleName();
	SpriteBatch batch;
    Texture img1;
    Texture img2;
    Texture img3;
    Texture img4;
    BitmapFont font;
    ShapeRenderer renderer;
    private OrthographicCamera cam;
	private Viewport viewport;

	public SongSelectDisplay(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        img1 = new Texture("res/hidari.png");
        img2 = new Texture("res/mae.png");
        img3 = new Texture("res/migi.png");
        img4 = new Texture("res/usiro.png");
        font = new BitmapFont();
        renderer = new ShapeRenderer();
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
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img1, 50, 80);
        batch.draw(img2, 50, 280);
        batch.draw(img3, 450, 80);
        batch.draw(img4, 450, 280);

        font.getData().setScale(1f);
        font.draw(batch, "kyokumei", 130, 110);
        font.draw(batch, "kyokumei", 130, 310);
        font.draw(batch, "kyokumei", 530, 110);
        font.draw(batch, "kyokumei", 530, 310);
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.rect(120, 90, 270,30);
        renderer.rect(120, 290, 270,30);
        renderer.rect(520, 90, 270,30);
        renderer.rect(520, 290, 270,30);
        renderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
			if(120<touchPoint.x && touchPoint.x<390){
				if(90>touchPoint.y && 60<touchPoint.y){
					game.setScreen(new DifficultySelectDisplay(game));
				}
			}
			if(120<touchPoint.x && touchPoint.x<390){
				if(260>touchPoint.y && 230<touchPoint.y){
					System.out.println("bbb");
				}
			}
			if(520<touchPoint.x && touchPoint.x<790){
				if(90>touchPoint.y && 60<touchPoint.y){
					System.out.println("bbb");
				}
			}
			if(520<touchPoint.x && touchPoint.x<790){
				if(260>touchPoint.y && 230<touchPoint.y){
					System.out.println("bbb");
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
    	 Gdx.app.log(LOG_TAG, "hide");
    	 font.dispose();
    	 batch.dispose();
    	 renderer.dispose();
    }

}
