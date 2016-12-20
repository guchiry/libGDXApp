package com.mygdx.game.musicplay;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class NoteDisplay {
	private NoteGenerater noteGenerater;

	private Array<Note> dispNotesList = new Array<Note>();
	private float elapsedTime = 0;

	public NoteDisplay(){
		noteGenerater = new NoteGenerater();
	}

	public void update(){
		for(Note note : dispNotesList){
			note.movePositionX();
		}

		//終了処理
		if(noteGenerater.isEmpty() && dispNotesList.size == 0){
			//なんもなす
		}
	}

	public void createNote(float delta){
		elapsedTime += delta;
		if(!noteGenerater.isEmpty()){
			if(elapsedTime >= noteGenerater.getLateNote()-4.4f){
				noteGenerater.removeNote(0);
				addNote(new Vector2(740, 392));
			}
		}
	}

	public Array<Note> getNotesList(){
		return dispNotesList;
	}

	public void addNote(Vector2 position) {
		Note note = new Note(position);
		dispNotesList.add(note);
	}

	public void removeNote(int i){
		if(dispNotesList.size != 0)
			dispNotesList.removeIndex(i);
	}

	public Note getLatestNote(){
		return dispNotesList.first();
	}

	public boolean isEmpty(){
		if(dispNotesList.size == 0){
			return true;
		}else{
			return false;
		}
	}

	public float getElapsedTime() {
		return elapsedTime;
	}
}
