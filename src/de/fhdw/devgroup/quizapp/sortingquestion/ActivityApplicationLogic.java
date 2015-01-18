package de.fhdw.devgroup.quizapp.sortingquestion;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.R;

public class ActivityApplicationLogic {
	
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityInit mActivity;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;
		//refreshGUI();
	}

	public void onAnswerButtonClicked(View v) {
		Log.d("Msg", "Am I getting called?");
		switch(v.getId()){
		
		case R.id.answer1:
			if (Integer.parseInt(mGUI.getPosition1().getText().toString()) == 0) {
				mGUI.getPosition1().setText(String.valueOf(mData.getPosition()));	
				mData.saveCurrentSolution(0, mData.getPosition());
				mData.nextPosition();
				mGUI.getPosition1().setTextColor(Color.rgb(0,0,0));
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition1().getText().toString()));
				mGUI.getPosition1().setText("0");
				mGUI.getPosition1().setTextColor(Color.rgb(255,255,255));
			}
			break;
			
		case R.id.answer2:
			if (Integer.parseInt(mGUI.getPosition2().getText().toString()) == 0) {
				mGUI.getPosition2().setText(String.valueOf(mData.getPosition()));
				mData.saveCurrentSolution(1, mData.getPosition());
				mData.nextPosition();
				mGUI.getPosition2().setTextColor(Color.rgb(0,0,0));
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition2().getText().toString()));
				mGUI.getPosition2().setText("0");
				mGUI.getPosition2().setTextColor(Color.rgb(255,255,255));
			}
			break;
			
		case R.id.answer3: 
			if (Integer.parseInt(mGUI.getPosition3().getText().toString()) == 0) {
				mGUI.getPosition3().setText(String.valueOf(mData.getPosition()));	
				mData.saveCurrentSolution(2, mData.getPosition());
				mData.nextPosition();
				mGUI.getPosition3().setTextColor(Color.rgb(0,0,0));
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition3().getText().toString()));
				mGUI.getPosition3().setText("0");
				mGUI.getPosition3().setTextColor(Color.rgb(255,255,255));
			}
			break;
			
		case R.id.answer4:
			if (Integer.parseInt(mGUI.getPosition4().getText().toString()) == 0) {
				mGUI.getPosition4().setText(String.valueOf(mData.getPosition()));	
				mData.saveCurrentSolution(3, mData.getPosition());
				mData.nextPosition();
				mGUI.getPosition4().setTextColor(Color.rgb(0,0,0));
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition4().getText().toString()));
				mGUI.getPosition4().setText("0");
				mGUI.getPosition4().setTextColor(Color.rgb(255,255,255));
			}
			break;
		case R.id.submit:
			checkResult(mData.getProvidedSolution(), mData.getSolution());
			break;
		}
		
	}
	public void checkResult(int[] currentSolution, int[] correctSolution){
		boolean correct = false;
		for (int i = 0; i < currentSolution.length; i++) {
            if (currentSolution[i] == 0) {
               Toast.makeText(mActivity.getApplicationContext(), "Please provide a solution before submitting", Toast.LENGTH_LONG).show();
               correct = false;
               break;
            }
            else if(currentSolution[i] != correctSolution[i]){
            	correct = false;
            	Toast.makeText(mActivity.getApplicationContext(), "You are wrong! Try again.", Toast.LENGTH_LONG).show();
            }
            else{
            	correct = true;
            }
		}
		if (correct == true){
			Toast.makeText(mActivity.getApplicationContext(), "You are right! Go on with the next question.", Toast.LENGTH_LONG).show();
			//TODO Neue Frage Starten
		}
		
		
		//TODO prüfen
		
		
	}
	public void refreshGUI(){
		
		
	}

}
