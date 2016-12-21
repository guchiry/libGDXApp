package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.LibGdxsample;
import com.mygdx.game.musicplay.Setting;
import com.mygdx.game.play.GameScreen;

public class DifficultySelectDisplay extends MyScreenAdapter {
	private static final String LOG_TAG = DifficultySelectDisplay.class.getSimpleName();
    SpriteBatch batch;
    Texture img1;
    Texture img2;
    Texture img3;
    Texture img4;
    Texture img5;
    Texture img6;
    Texture img7;
    Texture img8;
    TextureRegion[] front1;
    TextureRegion[] front2;
    TextureRegion[] front3;
    private OrthographicCamera cam;
	private Viewport viewport;

    BitmapFont font;
    ShapeRenderer renderer;

    public DifficultySelectDisplay(LibGdxsample game) {
        super(game);
        img1 = new Texture("res/kaede2.png");
        img2 = new Texture("res/sinon2.png");
        img3 = new Texture("res/visyunu2.png");
        img4 = new Texture("res/Goblin.png");
        img5 = new Texture("res/easy10.png");
        img6 = new Texture("res/normal.png");
        img7 = new Texture("res/hard.png");
        img8 = new Texture("res/back.png");
        batch = new SpriteBatch();
        font = new BitmapFont();
        renderer = new ShapeRenderer();
        front1 = new TextureRegion(img1).split(16, 16)[0];
        front2 = new TextureRegion(img2).split(16, 16)[0];
        front3 = new TextureRegion(img3).split(16, 16)[0];
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
        batch.draw(front1[1], 220, 300, 64, 64);
        batch.draw(front2[1], 320, 300, 64, 64);
        batch.draw(front3[1], 420, 300, 64, 64);
        batch.draw(img4, 520, 300, 64, 64);
        batch.draw(img5, 335, 210);
        batch.draw(img6, 335, 150);
        batch.draw(img7, 335, 90);
        batch.draw(img8, 20, 400);
        batch.end();

    	renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        renderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
		    if(20<touchPoint.x && touchPoint.x<20+img8.getWidth()*0.85){
				if(400<touchPoint.y && touchPoint.y<400+img8.getHeight()*0.85){
					game.setScreen(new SongSelectDisplay(game));
				}
			}
			if(360<touchPoint.x && touchPoint.x<435){
				if(240>touchPoint.y && 210<touchPoint.y){
					game.setScreen(new GameScreen(game));
				}
			}
			if(340<touchPoint.x && touchPoint.x<460){
				if(180>touchPoint.y && 150<touchPoint.y){
					game.setScreen(new GameScreen(game));
				}
			}
			if(360<touchPoint.x && touchPoint.x<440){
				if(125>touchPoint.y && 95<touchPoint.y){
					game.setScreen(new GameScreen(game));
						
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
