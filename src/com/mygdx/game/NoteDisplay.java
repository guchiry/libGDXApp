package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class NoteDisplay {
	private NoteGenerater noteGenerater;

	private Array<Note> dispNotesList = new Array<Note>();
	private int elapsedFrame = 0;

	public NoteDisplay(){
		noteGenerater = new NoteGenerater();
	}

	public void update(){
		for(Note note : dispNotesList){
			note.movePositionX();
		}

		//終了処理
		if(noteGenerater.isEmpty()){
			//なんもなす
		}
	}

	public void createNote(){
		elapsedFrame++;
		if(!noteGenerater.isEmpty()){
			if(elapsedFrame >= noteGenerater.getLateNote()){
				elapsedFrame = 0;
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
}
