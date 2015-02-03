package de.fhdw.devgroup.quizapp.gapquestion;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.constants.Constants;

/**
 * 
 * @author Kevin Respondek
 *
 */
public class ActivityApplicationLogic extends Activity{
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private int randomNumber;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		randomNumber = mData.getCurrentRandomNumber();
		
		//set random question
		String textview = "gap_text_" + randomNumber;
		mGUI.getmText().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(textview, "string", mData.getActivity().getPackageName())));
		
		//write answers on buttons
		String lButton1 = "gap_" + randomNumber + "_answer_1";
		String lButton2 = "gap_" + randomNumber + "_answer_2";
		String lButton3 = "gap_" + randomNumber + "_answer_3";
		String lButton4 = "gap_" + randomNumber + "_answer_4";
		mGUI.getmButton1().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton1, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton2().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton2, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton3().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton3, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton4().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton4, "string", mData.getActivity().getPackageName())));
	}
	
	// event handling
	
	public void onButton1Clicked() {
		buttonHandler(1);
	}

	public void onButton2Clicked() {
		buttonHandler(2);
		
	}
	public void onButton3Clicked() {
		buttonHandler(3);
		
	}
	public void onButton4Clicked() {
		buttonHandler(4);
	}
	
	public void startNewQuestion(){
		
		Intent intent = new Intent();
		mData.setQuestionScore(mData.getQuestionScore() + 1);
		if(mData.getQuestionNr() != 10){
		mData.setQuestionNr(mData.getQuestionNr() + 1);
		intent.putExtra(Constants.KEY_QUESTIONORDER, mData.getQuestionOrder());
		intent.putExtra(Constants.KEY_QUESTIONNUMBER, mData.getQuestionNr());
		intent.putExtra(Constants.KEY_QUESTIONSCORE, mData.getQuestionScore());
		
        intent.setClass(mData.getActivity(), Constants.ACTIVITYGAPCLASS);
        mData.getActivity().startActivity(intent);
		}
		else{
			Toast.makeText(mData.getActivity().getApplicationContext(), "Score: " + mData.getQuestionScore(), Toast.LENGTH_SHORT).show();	
		}
	}
	
	public void checkAnswer(String givenAnswer, String rightAnswer) {
		if (rightAnswer.equals(givenAnswer)) {
			//Popup right answer
			Toast.makeText(mData.getActivity(), "Absolut! Richtige Antort", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider falsch geraten.", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public String getRightAnswer() {
		//build string and id to get the right answer from xml file
		String answer = "gap_" + randomNumber + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		
		return rightAnswer;
	}
	
	public void buttonHandler(int lButtonNumber) {
		
		String rAnswer = getRightAnswer();
		//get clicked answer
		String givenAnswer = "";
		switch(lButtonNumber) {
		case 1: givenAnswer = mGUI.getmButton1().getText().toString();break;
		case 2: givenAnswer = mGUI.getmButton2().getText().toString();break;
		case 3: givenAnswer = mGUI.getmButton3().getText().toString();break;
		case 4: givenAnswer = mGUI.getmButton4().getText().toString();break;
		
		}
		//check if the user was right or wrong
		checkAnswer(givenAnswer, rAnswer);		
		//restart or forward to next activity to continue game
		startNewQuestion();		
	}

}
