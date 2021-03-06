package de.fhdw.devgroup.quizapp.timedquestion;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.R;
import de.fhdw.devgroup.quizapp.constants.Constants;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class ApplicationLogic_RG_V01 {
	
	private Data_RG_V01 mData;
	private GUI_RG_V01 mGUI;
	private CountDownTimer mCountDownTimer;
	private final long countdownTime = 10000;
	private int questionId;
	private String rightAnswer;
	
	// Handler für einen kurzenTimedelay
	private Handler handler = new Handler();
	private Runnable runnable = new Runnable() {
	    @Override
	    public void run() {
	    	if(mData.getQuestionNr() < 10){
	    		// Vorbereitung für neu Aufruf der nächsten Activitiy
			Intent intent = new Intent();
			// Übergabe der globalen Parameter
			intent.putExtra(Constants.KEY_QUESTIONORDER, mData.getQuestionOrder());
			intent.putExtra(Constants.KEY_QUESTIONNUMBER, mData.getQuestionNr());
			intent.putExtra(Constants.KEY_QUESTIONSCORE, mData.getQuestionScore());
			intent.setClass(mData.getActivity(), Constants.ACTIVITYTIMEDCLASS);
			// Beendet alte Activity
			mData.getActivity().finish();
	        	mData.getActivity().startActivity(intent);
		}else{
			// Ende nach 10 Fragen
			Toast.makeText(mData.getActivity(), "Fertig!", Toast.LENGTH_SHORT).show();
			
		}
	    }
	   
	};
	
	// ApplicationLogic starten
	public ApplicationLogic_RG_V01(Data_RG_V01 mData, final GUI_RG_V01 mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		questionId = mData.getquestionId();
		
		//set Question
		String lText = "question_r_" + questionId;
		int lId = mData.getActivity().getResources().getIdentifier(lText, "string", mData.getActivity().getPackageName());
		mGUI.setTvQuestionText(mData.getActivity().getResources().getString(lId));
		
		//set Answer
		String lButton1 = "question_r_" + questionId + "_answer_1";
		String lButton2 = "question_r_" + questionId + "_answer_2";
		String lButton3 = "question_r_" + questionId + "_answer_3";
		String lButton4 = "question_r_" + questionId + "_answer_4";
		mGUI.setBtn01AnswerText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton1, "string", mData.getActivity().getPackageName())));
		mGUI.setBtn02AnswerText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton2, "string", mData.getActivity().getPackageName())));
		mGUI.setBtn03AnswerText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton3, "string", mData.getActivity().getPackageName())));
		mGUI.setBtn04AnswerText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton4, "string", mData.getActivity().getPackageName())));
		
		//get answer
		String answer = "question_r_" + questionId + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		rightAnswer = mData.getActivity().getResources().getString(id);
		
		//set Timer für progressbar
		mGUI.getPbTimer().setMax((int)countdownTime);
		
		// Timer für die Progressbar
		mCountDownTimer = new CountDownTimer(countdownTime, 10) 
		{
		    // Berechnung wie viel Zeit schon vergangen ist
		    public void onTick(long millisUntilFinished) {
		      millisUntilFinished = countdownTime - millisUntilFinished;
		      // Setzt die Progressbar auf die vergangene Zeit
		      mGUI.getPbTimer().setProgress((int) millisUntilFinished);
		    }

		    public void onFinish() {
			// Setzt die Progressbar auf die maximal vergangene Zeit (countdownTime)
		    	mGUI.getPbTimer().setProgress((int) countdownTime);
		    	// Beendet den Timer
		    	mCountDownTimer.cancel();
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
				
				if(mGUI.getBt1Answer().getText().toString().equals(rightAnswer)){
					mGUI.setColorBtnTrue(mGUI.getBt1Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt1Answer());
				}
			}
			break;
			case R.id.btn2:
			{
				if(mGUI.getBt2Answer().getText().toString().equals(rightAnswer)){
					mGUI.setColorBtnTrue(mGUI.getBt2Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt2Answer());
				}
			}
			break;
			case R.id.btn3:
			{
				if(mGUI.getBt3Answer().getText().toString().equals(rightAnswer)){
					mGUI.setColorBtnTrue(mGUI.getBt3Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt3Answer());
				}
			}
			break;
			case R.id.btn4:
			{
				if(mGUI.getBt4Answer().getText().toString().equals(rightAnswer)){
					mGUI.setColorBtnTrue(mGUI.getBt4Answer());
				}
				else{
					mGUI.setColorBtnFalse(mGUI.getBt4Answer());
				}
			}
			break;
			
		}
		// Zählt die Anzahl abgefragter Fragen bis jetzt eins hoch
		mData.setQuestionNr(mData.getQuestionNr() + 1);
		// Beendet den Timer
		mCountDownTimer.cancel();
	
		// Delay von 1 sek
		handler.postDelayed(runnable, 1000);
		
	}

}
