package de.fhdw.devgroup.quizapp.end;

import android.os.Bundle;
import android.util.Log;
import de.fhdw.devgroup.quizapp.constants.Constants;
import de.fhdw.devgroup.quizapp.utilities.QuestionManager;
import de.fhdw.devgroup.quizapp.utilities.Shuffler;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityData {

	private ActivityInit mActivity;

	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit) {
		mActivity = activityInit;
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