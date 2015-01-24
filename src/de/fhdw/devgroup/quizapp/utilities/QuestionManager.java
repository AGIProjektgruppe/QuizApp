package de.fhdw.devgroup.quizapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class QuestionManager {
	
	
	public static void insertQuestions(Activity act ){
		DatabaseManager dbManager = new DatabaseManager(act.getApplicationContext());
		
		
		dbManager.insertSortingquestion("S1","Testfragetext, nur zum testen", "A,B,C,D");
		
	}
	
	public static String[] getSortingquestion(Context context, String questionId){
		
		DatabaseManager dbManager = new DatabaseManager(context);
		String question[] = new String[2];
		question = dbManager.retrieveSortingquestion("S1");
		return question;
		
	}

}
