package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class World {
	Map1 map1;

	Kaede kaede;

	//--Getter------------------------
	public Map1 getMap1(){
		return map1;
	}

	public Kaede getKaede(){
		return kaede;
	}
	//---------------------------------

	public World(){
		createDemoWorld();
	}

	public void createDemoWorld(){
		kaede = new Kaede(new Vector2(12.5f,9.5f));

//		map1 = new Map1();
	}
}
