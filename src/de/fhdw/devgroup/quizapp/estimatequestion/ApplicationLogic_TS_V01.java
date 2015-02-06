package de.fhdw.devgroup.quizapp.estimatequestion;

import de.fhdw.devgroup.quizapp.constants.Constants;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */

public class ApplicationLogic_TS_V01 {
	
	// Dateninitialisierung
	
	private Data_TS_V01 mData;
	private GUI_TS_V01 mGUI;
	private double answerUser;
	
	
	// ApplicationLogic starten
	public ApplicationLogic_TS_V01(Data_TS_V01 mData, final GUI_TS_V01 mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
				
		//Frage aus XML einlesen
		mGUI.setTvQuestionText(mData.getQuestionText());
			
	}
	
	// Antwort abholen
	public void onButtonClicked(View v) {
		
		answerUser = Double.parseDouble(mGUI.getEtAnswer().getText().toString());
		
		// Die drei möglichen Antworten abfragen
		if(
			// Falls die Antwort im Toleranzbereich liegt	
			mData.getAnswerMin() <= answerUser && answerUser <=mData.getAnswerMax() && answerUser != mData.getAnswer() ){
			Toast.makeText(mData.getActivity(), "Fast richtig geschätzt! Es sind " + mData.getAnswer(), Toast.LENGTH_SHORT).show();
			mData.setQuestionScore(mData.getQuestionScore() + 1);
			startNextQuestion();
		}
		else if(answerUser == mData.getAnswer()){
			//Falls Antwort richtig
			Toast.makeText(mData.getActivity(), "Richtig geschätzt!", Toast.LENGTH_SHORT).show();
			mData.setQuestionScore(mData.getQuestionScore() + 1);
			startNextQuestion();
		}
		else{
			//Falsche Antwort
			Toast.makeText(mData.getActivity(), "Falsch geschätzt!", Toast.LENGTH_SHORT).show();
			startNextQuestion();
		}
		
		
	}
	
	public void startNextQuestion(){
		 Intent intent = new Intent();
		 
		 	//Wenn das Ende der Fragenreihe nicht erreicht ist, nächste Frage starten
		 	// Sonst Score anzeigen
			
			if(mData.getQuestionNr() != 10){
			mData.setQuestionNr(mData.getQuestionNr() + 1);
			intent.putExtra(Constants.KEY_QUESTIONORDER, mData.getQuestionOrder());
			intent.putExtra(Constants.KEY_QUESTIONNUMBER, mData.getQuestionNr());
			intent.putExtra(Constants.KEY_QUESTIONSCORE, mData.getQuestionScore());
			
	        intent.setClass(mData.getActivity(), Constants.ACTIVITYESTIMATECLASS);
	        mData.getActivity().startActivity(intent);
			}
			else{
				Toast.makeText(mData.getActivity().getApplicationContext(), "Score: " + mData.getQuestionScore(), Toast.LENGTH_SHORT).show();	
			}
		 
	 }

}
