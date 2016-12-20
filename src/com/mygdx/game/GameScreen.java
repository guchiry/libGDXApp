package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends MyScreenAdapter{
	private OrthographicCamera cam;
	private Viewport viewport;

	private Music music;

	private DisplayRenderer renderer;
	public GameScreen(LibGdxsample game) {
		super(game);
	}

	@Override
	public void show() {
		this.cam = new OrthographicCamera(Setting.LOGICAL_WIDTH, Setting.LOGICAL_HEIGHT);
		this.cam.position.set(Setting.LOGICAL_WIDTH/2, Setting.LOGICAL_HEIGHT/2, 0);
		viewport = new FitViewport(Setting.LOGICAL_WIDTH, Setting.LOGICAL_HEIGHT, cam);

		renderer = new DisplayRenderer(cam);

		music = Gdx.audio.newMusic(Gdx.files.internal("res/kaede.mp3"));

		music.setLooping(false);
        music.setVolume(0.8f);
        music.play();

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render(delta);

		//pauseButton(どうすればポーズできるのか)
		if (Gdx.input.justTouched()) {
		    float x = Gdx.input.getX();
		    float y = Gdx.input.getY();
		    Vector3 touchPoint = new Vector3();
		    viewport.unproject(touchPoint.set(x, y, 0));
		    Rectangle pauseBounds = new Rectangle();
		    pauseBounds.set(762, 442, 32, 32);
		    if (pauseBounds.contains(touchPoint.x, touchPoint.y)) {
		        pause();
		        System.out.println("PauseButtooooooooon!!!");
		    }
		}
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		renderer.gameRenderer.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

}
