package de.fhdw.devgroup.quizapp.sortingquestion;

import android.os.Bundle;
import de.fhdw.devgroup.quizapp.constants.*;

public class ActivityData {

	private int mPosition;
	private ActivityInit mActivity;

	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit) {
		
		setActivity(activityInit);
		if ( savedInstanceState == null ) {  // no data to restore
			mPosition = 1;   // use default
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}

	private void restoreDataFromBundle(Bundle savedInstanceState) {
		mPosition = savedInstanceState.getInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION);
		
	}

	public void saveDataInBundle(Bundle outState) {
		
		outState.putInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION, mPosition);
	}
	
	
	public void nextPosition() {
		mPosition++;
	}
	
	public void previousPosition(int pos) {
		if (pos < mPosition){
			mPosition = pos;
			
		}
	}
	
	// Getter
	public int getPosition() {
		return mPosition;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	//Setter
	public void setPosition(int mPosition) {
		this.mPosition = mPosition;
	}

	public void setActivity(ActivityInit mActivity) {
		this.mActivity = mActivity;
	}

}
