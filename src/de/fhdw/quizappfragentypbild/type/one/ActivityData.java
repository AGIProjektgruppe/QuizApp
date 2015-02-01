package de.fhdw.quizappfragentypbild.type.one;

import android.os.Bundle;

public class ActivityData {
	
	private static final String ENTEREDSTRING = "K1";
	
	private ActivityInit mActivity;
	private String mTypedIn;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mTypedIn = ""; //use default
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putString(ENTEREDSTRING, mTypedIn);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mTypedIn = b.getString(ENTEREDSTRING);
	}
	
	// setter	
	public void setmTypedIn(String mTypedIn) {
		this.mTypedIn = mTypedIn;
	}
	// getter
	public String getmTypedIn() {
		return mTypedIn;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
}
