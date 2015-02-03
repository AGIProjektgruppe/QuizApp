package de.fhdw.devgroup.quizapp.sortingquestion;

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

	private int mPosition;
	private String[][] shuffeldQuestionData;
	private String[] answers; //Antwortmöglichekeiten
	private int[] mSolution; //Richtige Reihenfolge
	private String mQuestionText;
	private int providedSolution[]; //Vom Nutzer eingegenebe Reihenfolge
	private ActivityInit mActivity;
	private int[] mQuestionOrder;
	private int mQuestionNr;
	private int mQuestionScore;

	public ActivityData(Bundle savedInstanceState, ActivityInit activityInit, int[] questionOrder, int questionNr, int mScore) {
		setQuestionOrder(questionOrder);
		setQuestionNr(questionNr);
		setQuestionScore(mScore);
		
		setActivity(activityInit);
		if ( savedInstanceState == null ) {  // no data to restore
			mPosition = 1;   // use default
			providedSolution = new int[4];
			mSolution = new int[4];
			shuffeldQuestionData = new String[4][2]; //Antworten durcheinander würfeln
			answers = new String[4];
			
			mQuestionText = "sortingquestion_text_"  + questionOrder[questionNr];
			int lId = this.getActivity().getResources().getIdentifier(mQuestionText, "string", this.getActivity().getPackageName());
			
			
			String answer = "sortingquestion_" + questionOrder[questionNr] + "_answer_1";
			int id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			answers[0] = this.getActivity().getResources().getString(id);
			
			answer = "sortingquestion_" + questionOrder[questionNr] + "_answer_2";
			id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			answers[1] = this.getActivity().getResources().getString(id);
			
			answer = "sortingquestion_" + questionOrder[questionNr] + "_answer_3";
			id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			answers[2] = this.getActivity().getResources().getString(id);
			
			answer = "sortingquestion_" + questionOrder[questionNr] + "_answer_4";
			id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			answers[3] = this.getActivity().getResources().getString(id);
			
			shuffeldQuestionData = Shuffler.shuffleStringArray(answers);
			
			for(int i = 0; i< shuffeldQuestionData.length; i++ ){
				mSolution[i] = Integer.parseInt(shuffeldQuestionData[i][0]);
				answers[i]=shuffeldQuestionData[i][1];			
			}	
			//extractInformationFromDBQuery(QuestionManager.getSortingquestion(this.getActivity() , "S1")); //Aus der Rückgabe der Datenbankabfrage Antwort, Fragetext und Lösung aufteilen
		}
		else { 
			restoreDataFromBundle(savedInstanceState);	
		}		
	}

	private void restoreDataFromBundle(Bundle savedInstanceState) {
		mPosition = savedInstanceState.getInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION);
		providedSolution = savedInstanceState.getIntArray(Constants.KEY_PROVIDEDSOLUTIONARRAY_SORTINGQUESTION);
		answers = savedInstanceState.getStringArray(Constants.KEY_ANSWERSARRAY_SORTINGQUESTION);
		mSolution = savedInstanceState.getIntArray(Constants.KEY_CORRECTSOLUTIONARRAY_SORTINGQUESTION);		
	}

	public void saveDataInBundle(Bundle outState) {
		
		outState.putInt(Constants.KEY_POSTIONVALUE_SORTINGQUESTION, mPosition);
		outState.putIntArray(Constants.KEY_PROVIDEDSOLUTIONARRAY_SORTINGQUESTION, providedSolution);
		outState.putStringArray(Constants.KEY_ANSWERSARRAY_SORTINGQUESTION, answers);
		outState.putIntArray(Constants.KEY_CORRECTSOLUTIONARRAY_SORTINGQUESTION, mSolution);
	}
	
	/*public void extractInformationFromDBQuery(String[] queryresult){
		setQuestionText(queryresult[0]);
		String temp = queryresult[1];
		String tempParts[] = temp.split(",");
		
		shuffeldQuestionData = Shuffler.shuffleStringArray(tempParts);
		
		for(int i = 0; i< shuffeldQuestionData.length; i++ ){
			mSolution[i] = Integer.parseInt(shuffeldQuestionData[i][0]);
			answers[i]=shuffeldQuestionData[i][1];			
		}	
	}*/
	
	public void nextPosition() {
		mPosition++;
		for(int i = 0; i < providedSolution.length; i++){
			if (mPosition == providedSolution[i]) mPosition++;
		}
		
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
		return mPosition;	}
	
	public ActivityInit getActivity() {
		return mActivity;	}

	public int[] getSolution() {
		return mSolution;	}

	public int[] getProvidedSolution() {
		return providedSolution;	}

	public String getAnswers(int index) {
		return answers[index];	}

	public int getQuestionScore() {
		return mQuestionScore;
	}

	public int getQuestionNr() {
		return mQuestionNr;
	}

	public int[] getQuestionOrder() {
		return mQuestionOrder;
	}

	public void setQuestionOrder(int[] mQuestionOrder) {
		this.mQuestionOrder = mQuestionOrder;
	}

	public void setQuestionNr(int mQuestionNr) {
		this.mQuestionNr = mQuestionNr;
	}

	public void setQuestionScore(int mQuestionScore) {
		this.mQuestionScore = mQuestionScore;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;	}

	public void setSolution(int[] result) {
		this.mSolution = result;	}

	public void setProvidedSolution(int[] providedSolution) {
		this.providedSolution = providedSolution;	}

	//Setter
	public void setPosition(int mPosition) {
		this.mPosition = mPosition;	}

	public void setActivity(ActivityInit mActivity) {
		this.mActivity = mActivity;	}

	public String getQuestionText() {
		return mQuestionText;	}

	public void setQuestionText(String mQuestionText) {
		this.mQuestionText = mQuestionText;	}
}
