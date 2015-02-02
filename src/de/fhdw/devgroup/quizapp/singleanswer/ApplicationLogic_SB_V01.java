package de.fhdw.devgroup.quizapp.singleanswer;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Sven Brückmann
 * @version 1.0
 */

public class ApplicationLogic_SB_V01 {
	
	private Data_SB_V01 mData;
	private GUI_SB_V01 mGUI;
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
	    		//wechsele ins HauptMenu
	    	}
	    	
		}
	   
	};
	
	// ApplicationLogic starten
	public ApplicationLogic_SB_V01(Data_SB_V01 mData, final GUI_SB_V01 mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
				
		//set Question
		mGUI.setTvQuestionText(mData.getQuestionText());
		
		//set Answer
		mGUI.setBtn01AnswerText(mData.getBtn01Text());
		mGUI.setBtn02AnswerText(mData.getBtn02Text());
		mGUI.setBtn03AnswerText(mData.getBtn03Text());
		mGUI.setBtn04AnswerText(mData.getBtn04Text());
		
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
