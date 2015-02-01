package de.fhdw.devgroup.quizapp.sortingquestion;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.R;
import de.fhdw.devgroup.quizapp.constants.Constants;

public class ActivityApplicationLogic {
		
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityInit mActivity;
	private int mPosition; 
		
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		Log.d("Logic","Logic Class created");
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;
		
		mData.getPosition();
		mGUI.getQuestionText().setText(mData.getQuestionText());
		mGUI.getAnswerButton1().setText(mData.getAnswers(0));
		mGUI.getAnswerButton2().setText(mData.getAnswers(1));
		mGUI.getAnswerButton3().setText(mData.getAnswers(2));
		mGUI.getAnswerButton4().setText(mData.getAnswers(3));
		refreshGUI();
	}

	public void onAnswerButtonClicked(View v) {
		
		switch(v.getId()){
		case R.id.answer1:
			Log.d("Msg", "answer1");
			if (Integer.parseInt(mGUI.getPosition1().getText().toString()) == 0) {
				mGUI.getPosition1().setText(String.valueOf(mData.getPosition()));	
				mData.saveCurrentSolution(0, mData.getPosition());
				mData.nextPosition();
				mGUI.getPosition1().setTextColor(Color.rgb(0,0,0));
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition1().getText().toString()));
				mData.saveCurrentSolution(0, 0);
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
				mData.saveCurrentSolution(1, 0);
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
				mData.saveCurrentSolution(2, 0);
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
				mData.saveCurrentSolution(3, 0);
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
			Log.d("Solution, me", "this: " + currentSolution[i]);
			Log.d("Solution, correct", "this: " + correctSolution[i]);
			
            if (currentSolution[i] == 0) {
               Toast.makeText(mActivity.getApplicationContext(), "Please provide a solution before submitting", Toast.LENGTH_SHORT).show();
               correct = false;
               break;
            }
            else if(currentSolution[i] != correctSolution[i] + 1){
            	correct = false;
            	Toast.makeText(mActivity.getApplicationContext(), "You are wrong! Try again.", Toast.LENGTH_SHORT).show();
            }
            else{
            	correct = true;
            }
		}
		if (correct == true){
			Toast.makeText(mActivity.getApplicationContext(), "You are right! Go on with the next question.", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent();
	        intent.setClass(mData.getActivity(), Constants.ACTIVITYMULTICLASS);
	        mData.getActivity().startActivity(intent);
		}
	}
	
	public void refreshGUI(){
		int currentSolution[] = mData.getProvidedSolution();
		mGUI.getPosition1().setText(String.valueOf(currentSolution[0]));
		mGUI.getPosition2().setText(String.valueOf(currentSolution[1]));
		mGUI.getPosition3().setText(String.valueOf(currentSolution[2]));
		mGUI.getPosition4().setText(String.valueOf(currentSolution[3]));	
	}
}
