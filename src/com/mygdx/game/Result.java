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
import com.mygdx.game.musicplay.Setting;

public class Result extends MyScreenAdapter {
	private static final String LOG_TAG = Result.class.getSimpleName();
    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    ShapeRenderer renderer;
	int time;
	private OrthographicCamera cam;
	private Viewport viewport;

    public Result(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
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
    	time++;
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.rect(100, 350, 400,50);
        renderer.rect(550, 350, 150,50);
        renderer.rect(50, 250, 160,40);
        renderer.rect(230, 250, 160,40);
        renderer.rect(410, 250, 160,40);
        renderer.rect(590, 250, 160,40);
        renderer.rect(200, 90, 400,80);
        renderer.rect(400, 430, 150,40);
        renderer.rect(600, 430, 150,40);
        renderer.end();

        batch.begin();
        font.getData().setScale(1f);
        font.draw(batch, "title", 460, 450);
        font.draw(batch, "exit", 670, 450);
        font.draw(batch, "kyokumei", 150, 375);
        font.draw(batch, "nanido", 600, 375);
        font.draw(batch, "perfect           /100", 80, 270);
        if(time>100){
        	font.draw(batch, "a", 160, 270);
        }

        font.draw(batch, "great             /100", 265, 270);
        if(time>150){
       	font.draw(batch, "b", 340, 270);
        }
       	font.draw(batch, "good              /100", 450, 270);
       	if(time>200){
       	font.draw(batch, "c", 530, 270);
       	}
       	font.draw(batch, "fault              /100", 625, 270);
       	if(time>250){
       	font.draw(batch, "d", 700, 270);
       	}
       	font.draw(batch, "Total points", 260, 115);
       	font.getData().setScale(3f);
       	if(time>350){
       	font.draw(batch, "XXXX", 400, 135);
       	}
       	font.getData().setScale(2f);
        if(time>410){
       	font.draw(batch, "clear", 650, 135);
        }
        batch.end();

        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
		    if(400<touchPoint.x && touchPoint.x<550){
				if(380>touchPoint.y && 340<touchPoint.y){
					game.setScreen(new Title(game));
				}
			}
		    if(600<touchPoint.x && touchPoint.x<750){
				if(380>touchPoint.y && 340<touchPoint.y){
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
    	 Gdx.app.log(LOG_TAG, "hide");
    	 font.dispose();
    	 batch.dispose();
    	 renderer.dispose();
    }
}