package de.fhdw.devgroup.quizapp.picturequestionone;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.constants.Constants;

/**
 * 
 * @author Adrian Strzelczyk
 *
 */
public class ActivityApplicationLogic {
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private int questionId;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		questionId = mData.getquestionId();
				
		//set random image
		ImageView img = (ImageView) mGUI.getmImage();
		String picture = "t1_question_" + questionId;
		int id =  mData.getActivity().getResources().getIdentifier(picture, "drawable", mData.getActivity().getPackageName());
		img.setImageResource(id); 	
		mGUI.setmImage(img);
		
		//set question text
		String lText = "question_" + questionId + "_text";
		int lId = mData.getActivity().getResources().getIdentifier(lText, "string", mData.getActivity().getPackageName());
		mGUI.setmText(mData.getActivity().getResources().getString(lId));
	}
	
	// event handling
	
	public void onConfirmButtonClicked() {
		//build string and id to get the right answer from xml file
		String rightAnswer = getRightAnswer();
		
		//given answer
		String givenAnswer = mGUI.getmAnswer().getText().toString() + "";
		
		//Check Answers
		checkAnswer(givenAnswer, rightAnswer);
		mData.setQuestionNr(mData.getQuestionNr() + 1);
		//restart or forward to next activity to continue game
		startNewQuestion();	
	}
	
	public String getRightAnswer() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + questionId + "_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		
		return rightAnswer;
	}
	
	public void checkAnswer(String givenAnswer, String rightAnswer) {
		if (rightAnswer.equals(givenAnswer)) {
			//Popup right answer
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
			
		}
		mData.setQuestionNr(mData.getQuestionNr() + 1);
		
	}
	
	public void startNewQuestion(){
        
		if(mData.getQuestionNr() < 10){
			
			Intent intent = new Intent();
			
			intent.putExtra(Constants.KEY_QUESTIONORDER, mData.getQuestionOrder());
			intent.putExtra(Constants.KEY_QUESTIONNUMBER, mData.getQuestionNr());
			intent.putExtra(Constants.KEY_QUESTIONSCORE, mData.getQuestionScore());
	        intent.setClass(mData.getActivity(), Constants.ACTIVITYPICTURECLASSONE);
	        mData.getActivity().finish();
	        mData.getActivity().startActivity(intent);
		}else{
			Toast.makeText(mData.getActivity(), "Fertig!", Toast.LENGTH_SHORT).show();
			
		}
	}

}
