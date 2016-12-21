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
import com.mygdx.game.Sequence;
import com.mygdx.game.musicplay.GradeNum;
import com.mygdx.game.musicplay.Setting;


public class Result extends MyScreenAdapter {
	private static final String LOG_TAG = Result.class.getSimpleName();
    SpriteBatch batch;
    Texture perfectImg, greatImg, goodImg, missImg, totalImg, songSelectImg, gameOverImg, titleImg, exitImg, hearttalesImg;

    BitmapFont font;
    ShapeRenderer debugRenderer;
	int i;
	private OrthographicCamera cam;
	private Viewport viewport;

	Sequence seq = new Sequence();

    public Result(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
        debugRenderer = new ShapeRenderer();
        perfectImg= new Texture("res/perfect.png");
        greatImg = new Texture("res/great1.png");
        goodImg = new Texture("res/good2.png");
        missImg = new Texture("res/miss1.png");
        totalImg = new Texture("res/totalpoint.png");
        songSelectImg = new Texture("res/songselect.png");
        gameOverImg = new Texture("res/gameover.png");
        titleImg = new Texture("res/title.png");
        exitImg = new Texture("res/exit.png");
        hearttalesImg = new Texture("res/hearttales.png");
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
        batch.draw(perfectImg, 30, 280);
        seq.draw(batch,178, 290, GradeNum.perfect);
        seq.draw(batch, 230, 290, GradeNum.fullCombo);
        batch.draw(greatImg, 30, 230);
        seq.draw(batch,178, 240, GradeNum.great);
        seq.draw(batch, 230, 240, GradeNum.fullCombo);
        batch.draw(goodImg, 30, 180);
        seq.draw(batch,178, 190, GradeNum.good);
        seq.draw(batch, 230, 190, GradeNum.fullCombo);
        batch.draw(missImg, 30, 130);
        seq.draw(batch,178, 140, GradeNum.miss);
        seq.draw(batch, 230, 140, GradeNum.fullCombo);
        batch.draw(totalImg, 300, 130);
        batch.draw(songSelectImg, 10, 340);
        batch.draw(hearttalesImg, 310, 415);
        if(i>200){
        	batch.draw(gameOverImg, 650, 130);
        }

        if(i>250){
        	batch.draw(titleImg, 500, 30);
        	batch.draw(exitImg, 650, 30);
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