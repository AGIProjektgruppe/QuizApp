package de.fhdw.devgroup.quizapp.multiquestion;

import java.util.ArrayList;

import android.os.Bundle;
import de.fhdw.devgroup.quizapp.constants.*;

/**
 * 
 * @author Sebastian Feder
 *
 */
public class ActivityData {

	// solution of the DB entry
	private ArrayList<Integer> mSolution = new ArrayList<Integer>();
	
	// solution of the user
	private ArrayList<Integer> providedSolution = new ArrayList<Integer>();
	
	private ActivityInit mActivity;

	
	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit) {
		
		setActivity(activityInit);
		if ( savedInstanceState == null ) {  // no data to restore
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
		//TODO replace with solution of the database entry
		mSolution.add(1);
		mSolution.add(2);
		mSolution.add(3);
		
	}

	private void restoreDataFromBundle(Bundle savedInstanceState) {
		//TODO make own constants for this type of question ?? dont know if this is necessary
		providedSolution = savedInstanceState.getIntegerArrayList(Constants.KEY_PROVIDEDSOLUTIONARRAY_SORTINGQUESTION);
	}

	public void saveDataInBundle(Bundle outState) {	
		//TODO make own constants for this type of question ?? dont know if this is necessary
		outState.putIntegerArrayList(Constants.KEY_PROVIDEDSOLUTIONARRAY_SORTINGQUESTION, providedSolution);
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	/**
	 * @return the DB entry solution
	 */
	public ArrayList<Integer> getSolution() {
		return mSolution;
	}

	/**
	 * @return the provided solution of the user
	 */
	public ArrayList<Integer> getProvidedSolution() {
		return providedSolution;
	}

	/**
	 * @param solution the solution of the DB entry
	 */
	public void setSolution(ArrayList<Integer> solution) {
		this.mSolution = solution;
	}

	/**
	 * @param providedSolution the solution of the user
	 */
	public void setProvidedSolution(ArrayList<Integer> providedSolution) {
		this.providedSolution = providedSolution;
	}


	public void setActivity(ActivityInit mActivity) {
		this.mActivity = mActivity;
	}

}
