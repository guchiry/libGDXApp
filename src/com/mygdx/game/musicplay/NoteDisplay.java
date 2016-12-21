package com.mygdx.game.musicplay;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class NoteDisplay {
	private NoteGenerater noteGenerater;

	private Array<Note> dispNotesList = new Array<Note>();

	public NoteDisplay(){
		noteGenerater = new NoteGenerater();
	}

	public void update(){
		for(Note note : dispNotesList){
			note.movePositionX();
		}
	}

	public void createNote(float delta){
		System.out.println(Setting.ARRIVAL_TIME);
		if(!noteGenerater.isEmpty()){
			if(GradeNum.playTime >= noteGenerater.getLateNote()-Setting.ARRIVAL_TIME){
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
