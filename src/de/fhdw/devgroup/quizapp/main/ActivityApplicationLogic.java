package de.fhdw.devgroup.quizapp.main;

import android.content.Intent;
import android.util.Log;
import de.fhdw.devgroup.quizapp.constants.Constants;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityApplicationLogic {
	
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityInit mActivity;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		Log.d("Logic","Logic Class created");
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;
	}


	public void startButtonClicked() {
		
		Intent intent; 
		intent = new Intent();
        intent.setClass(mData.getActivity(), Constants.ACTIVITYSORTINGCLASS);
        mData.getActivity().startActivity(intent);
	}


	public void highscoreButtonClicked() {
		
		/* Intent intent = new Intent();
        intent.setClass(mData.getActivity(), Constants.ACTIVITYSORTINGCLASS);
        mData.getActivity().startActivity(intent);
		*/
	}

}