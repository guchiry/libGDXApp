package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.LibGdxsample;
import com.mygdx.game.musicplay.Setting;


public class SongSelectDisplay extends MyScreenAdapter {
	private static final String LOG_TAG = SongSelectDisplay.class.getSimpleName();
	SpriteBatch batch;
    Texture img1;
    Texture img2;
    Texture img3;
    Texture img4;
    ShapeRenderer debugRenderer;
    private OrthographicCamera cam;
	private Viewport viewport;

	public SongSelectDisplay(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        img1 = new Texture("res/songselect.png");
        img2 = new Texture("res/songselect.png");
        img3 = new Texture("res/songselect.png");
        img4 = new Texture("res/songselect.png");        debugRenderer = new ShapeRenderer();
    
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
    	this.cam.update();
    	batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(img1, 40, 450);
        batch.draw(img2, 40, 320);
        batch.draw(img3, 40, 190);
        batch.draw(img4, 40, 60);
        batch.end();
        debugRenderer.end();
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
        dispose();
    }
    @Override
    public void dispose() {
    	 Gdx.app.log(LOG_TAG, "hide");
    	 batch.dispose();
    	 debugRenderer.dispose();
    }

}
