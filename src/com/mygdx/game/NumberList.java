package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class NumberList {
	private Array<Integer> list = new Array<Integer>();

	public NumberList(int num){
		do{
			int i = num%10;
			list.add(i);
			num = num/10;
		}while(num != 0);
		list.reverse();
	}

	public Integer get(int n){
		if(n < list.size) return list.get(n);
		return null;
	}

	public int size(){
		return list.size;
	}
}
