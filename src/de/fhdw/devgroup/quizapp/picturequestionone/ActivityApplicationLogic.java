package de.fhdw.devgroup.quizapp.picturequestionone;

import java.util.Random;

import de.fhdw.devgroup.quizapp.constants.Constants;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

//hier ist noch ein fehler der zum memory overload führt, aber ich weiß nicht warum
//aber an sich funktionierts
public class ActivityApplicationLogic {
	
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
		String picture = "t1_question_" + randomNumber;
		int id =  mData.getActivity().getResources().getIdentifier(picture, "drawable", mData.getActivity().getPackageName());
		img.setImageResource(id); 	
		mGUI.setmImage(img);
		
		//set question text
		String lText = "question_" + randomNumber + "_text";
		int lId = mData.getActivity().getResources().getIdentifier(lText, "string", mData.getActivity().getPackageName());
		mGUI.setmText(mData.getActivity().getResources().getString(lId));
	}
	
	// event handling
	
	public void onConfirmButtonClicked() {
		//build string and id to get the right answer from xml file
		String answer = "question_" + randomNumber + "_answer";
		int id = mData.getActivity().getResources().getIdentifier(answer, "string", mData.getActivity().getPackageName());		
		String rightAnswer = mData.getActivity().getResources().getString(id);
		
		//given answer
		String givenAnswer = mGUI.getmAnswer().getText().toString() + "";
		
		if (rightAnswer.equals(givenAnswer)) {
			//Popup richtig --> nächste Frage
			Toast.makeText(mData.getActivity(), "Juhu Richtig!", Toast.LENGTH_SHORT).show();
		}
		else
		{
			//Popup leider Falsch --> nächste Frage
			Toast.makeText(mData.getActivity(), "Schade, leider Falsch.", Toast.LENGTH_SHORT).show();
		}
		//restart Activity for new Question
		Intent intent = new Intent();
        intent.setClass(mData.getActivity(), Constants.ACTIVITYPICTURECLASSTWO);
        mData.getActivity().startActivity(intent);

	}

}
