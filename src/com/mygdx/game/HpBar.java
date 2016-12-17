package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class HpBar extends HitPoint{

	public HpBar(){
		super();
	}

	public void draw(ShapeRenderer renderer){
		renderer.begin(ShapeType.Line);
		renderer.setColor(1, 1, 1, 1);
		renderer.rect(20,455,241,15);
		renderer.end();
		renderer.begin(ShapeType.Filled);
		renderer.rect(20,455,40,15);

		if(hp>=0){
			renderer.setColor(0,1,0,1);
			renderer.rect(60, 456, hp * 2, 14);
		}

		renderer.end();
	}
}
