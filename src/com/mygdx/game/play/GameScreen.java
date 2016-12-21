package com.mygdx.game.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.LibGdxsample;
import com.mygdx.game.musicplay.Setting;
import com.mygdx.game.screen.MyScreenAdapter;
import com.mygdx.game.screen.Result;

public class GameScreen extends MyScreenAdapter{
	enum MusicState{
		PLAY, START, BEFORE_THE_START
	}
	private OrthographicCamera cam;
	private Viewport viewport;

	private Music music;
	private MusicState state = MusicState.BEFORE_THE_START;
	private float startMusicTime = 0;

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

		music = Gdx.audio.newMusic(Gdx.files.internal("res/FatefulDay2.mp3"));
	}

	@Override
	public void render(float delta) {
		if(state == MusicState.BEFORE_THE_START)
			startMusicTime += delta;
		if(startMusicTime > 3f && state == MusicState.BEFORE_THE_START)
			state = MusicState.START;
		if(state == MusicState.START){
			state = MusicState.PLAY;
			music.setLooping(false);
	        music.setVolume(0.8f);
	        music.play();
		}
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

		if(!music.isPlaying() && state == MusicState.PLAY){
			game.setScreen(new Result(game));
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
		music.dispose();

	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

}
