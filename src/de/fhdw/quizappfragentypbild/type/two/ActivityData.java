package de.fhdw.quizappfragentypbild.type.two;

import android.os.Bundle;

public class ActivityData {
	
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;

	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}

}
