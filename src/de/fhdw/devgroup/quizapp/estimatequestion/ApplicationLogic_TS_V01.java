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
	
	private Data_TS_V01 mData;
	private GUI_TS_V01 mGUI;
	private double answerUser;
	
	
	// ApplicationLogic starten
	public ApplicationLogic_TS_V01(Data_TS_V01 mData, final GUI_TS_V01 mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
				
		//set Question
		mGUI.setTvQuestionText(mData.getQuestionText());
			
	}
	
	// event handling
	public void onButtonClicked(View v) {
		
		answerUser = Double.parseDouble(mGUI.getEtAnswer().getText().toString());
		
		// Die drei möglichen ANtworten abfragen
		if(mData.getAnswerMin() <= answerUser && answerUser <=mData.getAnswerMax() && answerUser != mData.getAnswer() ){
			Toast.makeText(mData.getActivity(), "Fast richtig geschätzt! Es sind " + mData.getAnswer(), Toast.LENGTH_SHORT).show();
			startNextQuestion();
		}
		else if(answerUser == mData.getAnswer()){
			Toast.makeText(mData.getActivity(), "Richtig geschätzt!", Toast.LENGTH_SHORT).show();
			startNextQuestion();
		}
		else{
			Toast.makeText(mData.getActivity(), "Falsch geschätzt!", Toast.LENGTH_SHORT).show();
			startNextQuestion();
		}
		
		
	}
	
	public void startNextQuestion(){
		 Intent intent = new Intent();
			mData.setQuestionScore(mData.getQuestionScore() + 1);
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
				intent = new Intent();
				intent.setClass(mData.getActivity(), Constants.ACTIVITYMAINCLASS);
				mData.getActivity().startActivity(intent);
		        mData.getActivity().finish();
			}
		 
	 }

}
