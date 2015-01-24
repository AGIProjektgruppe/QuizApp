package de.fhdw.quizappfragentypbild.type.two;

import java.util.Random;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.Toast;


public class ActivityApplicationLogic extends Activity{
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private Random rand = new Random();
	//randomnumber between 1-5 to get one of those questions
	//next((max-min)+1)+1
	private int randomNumber = rand.nextInt((5-1)+1)+1;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		
		
		//set random image
		ImageView img = (ImageView) mGUI.getmImage();
		String picture = "t2_question_" + randomNumber;
		int id =  mData.getActivity().getResources().getIdentifier(picture, "drawable", mData.getActivity().getPackageName());
		img.setImageResource(id); 	
		mGUI.setmImage(img);
		
		//write answers on buttons
		String lButton1 = "question_" + randomNumber + "_answer_1";
		String lButton2 = "question_" + randomNumber + "_answer_2";
		String lButton3 = "question_" + randomNumber + "_answer_3";
		String lButton4 = "question_" + randomNumber + "_answer_4";
		mGUI.getmButton1().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton1, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton2().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton2, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton3().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton3, "string", mData.getActivity().getPackageName())));
		mGUI.getmButton4().setText(mData.getActivity().getResources().getString(mData.getActivity().getResources().getIdentifier(lButton4, "string", mData.getActivity().getPackageName())));
	}
	
	// event handling
	
	public void onButton1Clicked() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + randomNumber + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		//get clicked answer
		String givenAnswer = mGUI.getmButton1().getText().toString();
		//check if the user was right or wrong
		if (rightAnswer.equals(givenAnswer)) {
			//Popup right answer
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
		}
		//restart or forward to next activity to continue game
		mData.getActivity().recreate();

	}
	
	public void onButton2Clicked() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + randomNumber + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		//get clicked answer
		String givenAnswer = mGUI.getmButton2().getText().toString();
		//check if the user was right or wrong
		if (rightAnswer.equals(givenAnswer)) {
			//popup right answer
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
		}
		//restart or forward to next activity to continue game
		mData.getActivity().recreate();
		
	}
	public void onButton3Clicked() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + randomNumber + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		//get clicked answer
		String givenAnswer = mGUI.getmButton3().getText().toString();
		//check if the user was right or wrong
		if (rightAnswer.equals(givenAnswer)) {
			//popup right answer
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
		}
		//restart or forward to next activity to continue game
		mData.getActivity().recreate();
		
	}
	public void onButton4Clicked() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + randomNumber + "_right_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		//get clicked answer
		String givenAnswer = mGUI.getmButton4().getText().toString();
		//check if the user was right or wrong
		if (rightAnswer.equals(givenAnswer)) {
			//popup right answer
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup wrong answer
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
		}
		//restart or forward to next activity to continue game
		mData.getActivity().recreate();
	}
	
	//here i can add a new method to check if two string are equal or not and then give a popup
	//public void checkAnswers(String rightAnswer, String givenAnswer) { }
	//the same with getting the right answer
	//public String getRightAnswer() { }

}
