package com.mygdx.game.screen;


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
import com.mygdx.game.LibGdxsample;
import com.mygdx.game.musicplay.Setting;


public class Result extends MyScreenAdapter {
	private static final String LOG_TAG = Result.class.getSimpleName();
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
    Texture img10;
    BitmapFont font;
    ShapeRenderer debugRenderer;
	int i;
	private OrthographicCamera cam;
	private Viewport viewport;

    public Result(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
        debugRenderer = new ShapeRenderer();
        img1 = new Texture("res/perfect.png");
        img2 = new Texture("res/great1.png");
        img3 = new Texture("res/good2.png");
        img4 = new Texture("res/miss1.png");
        img5 = new Texture("res/totalpoint.png");
        img6 = new Texture("res/songselect.png");
        img7 = new Texture("res/gameover.png");
        img8 = new Texture("res/title.png");
        img9 = new Texture("res/exit.png");
        img10 = new Texture("res/hearttales.png");
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
    	i++;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.cam.update();
    	batch.setProjectionMatrix(cam.combined);
        batch.begin(); // 描画の開始
        batch.draw(img1, 30, 280);
        batch.draw(img2, 30, 230);
        batch.draw(img3, 30, 180);
        batch.draw(img4, 30, 130);
        batch.draw(img5, 300, 130);
        batch.draw(img6, 10, 340);
        batch.draw(img10, 310, 415);
        if(i>200){
        	batch.draw(img7, 650, 130);
        }

        if(i>250){
        	batch.draw(img8, 500, 30);
        	batch.draw(img9, 650, 30);
        	if (Gdx.input.justTouched()) {
            	float x = Gdx.input.getX();
    		    float y = Gdx.input.getY();
    		    Vector3 touchPoint = new Vector3();
    		    viewport.unproject(touchPoint.set(x, y, 0));
    		    if(525<touchPoint.x && touchPoint.x<600){
    				if(70>touchPoint.y && 40<touchPoint.y){
    					game.setScreen(new Title(game));
    				}
    			}
    		    if(680<touchPoint.x && touchPoint.x<750){
    				if(70>touchPoint.y && 40<touchPoint.y){
    					Gdx.app.exit();
    					}
    			}
            }
        }

        batch.end(); // 描画の終了
        
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