package de.fhdw.devgroup.quizapp.estimatequestion;

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
	private final long countdownTime = 1000;
	private static int questionsPlayed = 0;
	
	// Handler für einen kurzenTimedelay
	private Handler handler = new Handler();
	private Runnable runnable = new Runnable() {
	    @Override
	    public void run() {
	    	
	    	if (questionsPlayed != 9) {
	    		// Anzahl von gespielten Fragen +1
	    		questionsPlayed++;
	    		// Activity neu starten
				Intent intent = new Intent();
				intent.setClass(mData.getActivity(), mData.getActivity().getClass());
				//mData.getActivity().finish();
				mData.getActivity().startActivity(intent);
				
				//handler.postDelayed(this, 100);
				//handler.removeCallback(runnable)
	    	}
	    	else{
	    		//wechsle ins HauptMenu
	    	}
	    	
	    }
	   
	};
	
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
		}
		else if(answerUser == mData.getAnswer()){
			Toast.makeText(mData.getActivity(), "Richtig geschätzt!", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(mData.getActivity(), "Falsch geschätzt!", Toast.LENGTH_SHORT).show();
		}
		
		if (questionsPlayed != 9){
			// Delay von 1 sek
			handler.postDelayed(runnable, 1000);
		}
		
	}

}
