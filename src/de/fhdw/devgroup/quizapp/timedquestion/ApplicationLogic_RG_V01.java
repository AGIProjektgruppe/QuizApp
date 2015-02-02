package de.fhdw.devgroup.quizapp.timedquestion;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class ApplicationLogic_RG_V01 {
	
	private Data_RG_V01 mData;
	private GUI_RG_V01 mGUI;
	private CountDownTimer mCountDownTimer;
	private final long countdownTime = 1000;
	private static int questionsPlayed = 0;
	
	// Handler für einen kurzenTimedelay
	private Handler handler = new Handler();
	private Runnable runnable = new Runnable() {
	    @Override
	    public void run() {
	    	// Funktioniert nur solange keine 10 Fragen gestellt wurden
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
	public ApplicationLogic_RG_V01(Data_RG_V01 mData, final GUI_RG_V01 mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
				
		//set Question
		mGUI.setTvQuestionText(mData.getQuestionText());
		
		//set Answer
		mGUI.setBtn01AnswerText(mData.getBtn01Text());
		mGUI.setBtn02AnswerText(mData.getBtn02Text());
		mGUI.setBtn03AnswerText(mData.getBtn03Text());
		mGUI.setBtn04AnswerText(mData.getBtn04Text());
		
		//set Timer for progressbar
		mGUI.getPbTimer().setMax((int)countdownTime);
		
		// Timer für die Progressbar
		mCountDownTimer = new CountDownTimer(countdownTime, 10) 
		{
		    // Berechnung wie viel Zeit schon vergangen ist
		    public void onTick(long millisUntilFinished) {
		      millisUntilFinished = countdownTime - millisUntilFinished;

		      mGUI.getPbTimer().setProgress((int) millisUntilFinished);
		    }

		    public void onFinish() {
		        // For styling purposes because of the "inaccuracy" of the timer
		        // so the progress will be shown as "full"
		    	mGUI.getPbTimer().setProgress((int) countdownTime);
		    	handler.postDelayed(runnable, 0);
		    }
		}.start();
		
	}
	
	// event handling
	public void onButtonClicked(View v) {
		
		// Je nach dem welcher Button gedrückt wurde, wird geschaut ob die richtige Antwort gedrückt wurde
		switch (v.getId())
		{
			case R.id.btn1:
			{
				if(mData.getAnswer()==1){
					mGUI.setColorBtnTrue(mGUI.getBt1Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt1Answer());
				}
			}
			break;
			case R.id.btn2:
			{
				if(mData.getAnswer()==2){
					mGUI.setColorBtnTrue(mGUI.getBt2Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt2Answer());
				}
			}
			break;
			case R.id.btn3:
			{
				if(mData.getAnswer()==3){
					mGUI.setColorBtnTrue(mGUI.getBt3Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt3Answer());
				}
			}
			break;
			case R.id.btn4:
			{
				if(mData.getAnswer()==4){
					mGUI.setColorBtnTrue(mGUI.getBt4Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt4Answer());
				}
			}
			break;
			
		}
	
		// Delay von 1 sek
		handler.postDelayed(runnable, 1000);
		
	}

}
