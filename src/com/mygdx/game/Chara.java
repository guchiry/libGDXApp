package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class Chara extends MyScreenAdapter {
	private static final String LOG_TAG = Chara.class.getSimpleName();
	SpriteBatch batch;
    Texture img1;
    Texture img2;
    Texture img3;
    Texture img4;
    BitmapFont font;
    ShapeRenderer debugRenderer;
    private OrthographicCamera cam;
	private Viewport viewport;
	
	public Chara(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        img1 = new Texture("res/hidari.png");
        img2 = new Texture("res/mae.png");
        img3 = new Texture("res/migi.png");
        img4 = new Texture("res/usiro.png");
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
        batch.begin(); // 描画の開始
        batch.draw(img1, 50, 80);
        batch.draw(img2, 50, 280);
        batch.draw(img3, 450, 80);
        batch.draw(img4, 450, 280);// テクスチャーを描画
        //font.setColor(Color.RED);
        font.getData().setScale(1f); 
        font.draw(batch, "kyokumei", 130, 110); 
        font.draw(batch, "kyokumei", 130, 310); 
        font.draw(batch, "kyokumei", 530, 110); 
        font.draw(batch, "kyokumei", 530, 310); 
        batch.end(); // 描画の終了
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.rect(120, 90, 270,30);
        debugRenderer.rect(120, 290, 270,30);
        debugRenderer.rect(520, 90, 270,30);
        debugRenderer.rect(520, 290, 270,30);
        debugRenderer.end();
        if (Gdx.input.justTouched()) {
        	float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
			if(120<touchPoint.x && touchPoint.x<390){
				if(90>touchPoint.y && 60<touchPoint.y){
					game.setScreen(new Nanido(game));
					//game.setScreen(new Chara(game));
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
    debugRenderer.dispose();
    }

}
