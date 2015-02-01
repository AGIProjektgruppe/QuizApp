package de.fhdw.devgroup.quizapp.picturequestiontwo;

import android.os.Bundle;

/**
 * 
 * @author Adrian Strzelczyk
 *
 */
public class ActivityData {
	
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;

	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}

}
