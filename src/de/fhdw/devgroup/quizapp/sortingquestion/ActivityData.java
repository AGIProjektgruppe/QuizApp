package de.fhdw.devgroup.quizapp.sortingquestion;

import android.os.Bundle;
import de.fhdw.devgroup.quizapp.constants.*;

public class ActivityData {

	private int mPosition;
	private int mSolution[] = {4,2,3,1};
	private int providedSolution[];
	private ActivityInit mActivity;

	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit) {
		
		setActivity(activityInit);
		if ( savedInstanceState == null ) {  // no data to restore
			mPosition = 1;   // use default
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
		providedSolution = new int[4];
		//mSolution = new int[4];
		
	}

	private void restoreDataFromBundle(Bundle savedInstanceState) {
		mPosition = savedInstanceState.getInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION);
		providedSolution = savedInstanceState.getIntArray(Constants.KEY_SOLUTIONARRAY_SORTINGQUESTION);
	}

	public void saveDataInBundle(Bundle outState) {
		
		outState.putInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION, mPosition);
		outState.putIntArray(Constants.KEY_SOLUTIONARRAY_SORTINGQUESTION, providedSolution);
	}
	
	
	public void nextPosition() {
		mPosition++;
	}
	
	public void previousPosition(int pos) {
		if (pos < mPosition){
			mPosition = pos;
			
		}
	}
	
	public void saveCurrentSolution(int index, int pos){
		
		providedSolution[index] = pos;
	}
	
	// Getter
	public int getPosition() {
		return mPosition;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	/**
	 * @return the result
	 */
	public int[] getSolution() {
		return mSolution;
	}

	/**
	 * @return the providedSolution
	 */
	public int[] getProvidedSolution() {
		return providedSolution;
	}

	/**
	 * @param result the result to set
	 */
	public void setSolution(int[] result) {
		this.mSolution = result;
	}

	/**
	 * @param providedSolution the providedSolution to set
	 */
	public void setProvidedSolution(int[] providedSolution) {
		this.providedSolution = providedSolution;
	}

	//Setter
	public void setPosition(int mPosition) {
		this.mPosition = mPosition;
	}

	public void setActivity(ActivityInit mActivity) {
		this.mActivity = mActivity;
	}

}
