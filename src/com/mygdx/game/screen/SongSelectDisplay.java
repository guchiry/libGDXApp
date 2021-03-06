package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    Texture img5;
    Texture img6;
    Texture img7;
    Texture img8;
    Texture img9;
    
    TextureRegion[] front1;
    TextureRegion[] front2;
    TextureRegion[] front3;
    TextureRegion[] front4;
    
    ShapeRenderer debugRenderer;
    private OrthographicCamera cam;
	private Viewport viewport;

	public SongSelectDisplay(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();

        img1 = new Texture("res/songselect.png");
        img2 = new Texture("res/hearttales.png");
        img3 = new Texture("res/preciousperson.png");
        img4 = new Texture("res/secretthings.png");
        img5 = new Texture("res/dailyworks1.png");
        img6 = new Texture("res/kaede2.png");
        img7 = new Texture("res/sinon2.png");
        img8 = new Texture("res/visyunu2.png");
        img9 = new Texture("res/rusifa.png");
        debugRenderer = new ShapeRenderer();
        front1 = new TextureRegion(img6).split(16, 16)[0];
        front2 = new TextureRegion(img7).split(16, 16)[0];
        front3 = new TextureRegion(img8).split(16, 16)[0];
        front4 = new TextureRegion(img9).split(16, 16)[0];

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
        batch.draw(img1, 94, 370, 612, 109);
        batch.draw(img1, 94, 250, 612, 109);
        batch.draw(img1, 94, 130, 612, 109);
        batch.draw(img1, 94, 10, 612, 109);
        batch.draw(img2, 330, 430);
        batch.draw(img3, 320, 310);
        batch.draw(img4, 320, 190);
        batch.draw(img5, 335, 70);
        batch.draw(front1[1], 135, 390, 64, 64);
        batch.draw(front2[1], 135, 270, 64, 64);
        batch.draw(front3[1], 135, 150, 64, 64);
        batch.draw(front4[1], 135, 30, 64, 64);
        batch.end();
        debugRenderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
			if(94<touchPoint.x && touchPoint.x<94+img1.getWidth()*0.85){
				if(370<touchPoint.y && touchPoint.y<370+img1.getHeight()*0.85){
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
    	 batch.dispose();
    	 debugRenderer.dispose();
    }

}
