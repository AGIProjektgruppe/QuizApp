package de.fhdw.devgroup.quizapp.sortingquestion;

import android.view.View;
import de.fhdw.devgroup.quizapp.R;

public class ActivityApplicationLogic {
	
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		
		this.mData = mData;
		this.mGUI = mGUI;
		//refreshGUI();
	}

	public void onAnswerButtonClicked(View v) {
		switch(v.getId()){
		
		case R.id.answer1:
			if (mGUI.getPosition1().getText().toString() == "") {
				mGUI.getPosition1().setText(mData.getPosition());
				mData.nextPosition();
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition1().getText().toString()));
				mGUI.getPosition1().setText("");	
			}
			break;
			
		case R.id.answer2:
			if (mGUI.getPosition2().getText().toString() == "") {
				mGUI.getPosition2().setText(mData.getPosition());	
				mData.nextPosition();
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition2().getText().toString()));
				mGUI.getPosition2().setText("");	
			}
			break;
			
		case R.id.answer3: 
			if (mGUI.getPosition3().getText().toString() == "") {
				mGUI.getPosition3().setText(mData.getPosition());	
				mData.nextPosition();
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition3().getText().toString()));
				mGUI.getPosition3().setText("");	
			}
			break;
			
		case R.id.answer4:
			if (mGUI.getPosition4().getText().toString() == "") {
				mGUI.getPosition4().setText(mData.getPosition());	
				mData.nextPosition();
			}
			else {
				mData.previousPosition(Integer.parseInt(mGUI.getPosition4().getText().toString()));
				mGUI.getPosition4().setText("");	
			}
			break;
		
		}
		
	}
	
	public void refreshGUI(){
		
		
	}

}
