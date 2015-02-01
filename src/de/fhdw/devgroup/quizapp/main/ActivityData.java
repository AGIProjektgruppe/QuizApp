package de.fhdw.devgroup.quizapp.main;

import android.os.Bundle;
import android.util.Log;
import de.fhdw.devgroup.quizapp.constants.Constants;
import de.fhdw.devgroup.quizapp.utilities.QuestionManager;
import de.fhdw.devgroup.quizapp.utilities.Shuffler;

public class ActivityData {

	private ActivityInit mActivity;

	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit) {
		
		if ( savedInstanceState == null ) {  // no data to restore
			
		}
		else { 
			restoreDataFromBundle(savedInstanceState);
			
		}	
		
	}

	private void restoreDataFromBundle(Bundle savedInstanceState) {
		
		
	}

	public void saveDataInBundle(Bundle outState) {

	}

	public ActivityInit getActivity() {
		return mActivity;
	}

	public void setActivity(ActivityInit mActivity) {
		this.mActivity = mActivity;
	}

}
