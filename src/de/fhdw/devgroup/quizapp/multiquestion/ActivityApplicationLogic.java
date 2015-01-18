package de.fhdw.devgroup.quizapp.multiquestion;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;
import android.widget.Toast;
import de.fhdw.devgroup.quizapp.R;


/**
 * 
 * @author Sebastian Feder
 *
 */
public class ActivityApplicationLogic {
	
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityInit mActivity;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;
	}

	
	public void onAnswerButtonClicked(View v) {

		switch(v.getId()){
		
		case R.id.answer1:
			//if answer1 not clicked -> set on click and add to solution list
			if(mGUI.getAnswerButton1().isSelected()){
				
				mGUI.getAnswerButton1().setSelected(false);
				mGUI.getAnswerButton1().setBackgroundColor(mGUI.getInitialColor());
				mData.getProvidedSolution().remove(mData.getProvidedSolution().indexOf(1));
			}
			//else set unclicked and remove from solution list
			else{
				mGUI.getAnswerButton1().setSelected(true);
				mGUI.getAnswerButton1().setBackgroundColor(Color.BLUE);
				mData.getProvidedSolution().add(1);
			}
			
			break;
			
		case R.id.answer2:
			//if answer2 not clicked -> set on click and add to solution list
			if(mGUI.getAnswerButton2().isSelected()){
				
				mGUI.getAnswerButton2().setSelected(false);
				mGUI.getAnswerButton2().setBackgroundColor(mGUI.getInitialColor());
				mData.getProvidedSolution().remove(mData.getProvidedSolution().indexOf(2));
			}
			//else set unclicked and remove from solution list
			else{
				mGUI.getAnswerButton2().setSelected(true);
				mGUI.getAnswerButton2().setBackgroundColor(Color.BLUE);
				mData.getProvidedSolution().add(2);
			}
			
			break;
			
		case R.id.answer3: 
			//if answer3 not clicked -> set on click and add to solution list
			if(mGUI.getAnswerButton3().isSelected()){
			
				mGUI.getAnswerButton3().setSelected(false);
				mGUI.getAnswerButton3().setBackgroundColor(mGUI.getInitialColor());
				mData.getProvidedSolution().remove(mData.getProvidedSolution().indexOf(3));
			}
			//else set unclicked and remove from solution list
			else{
				mGUI.getAnswerButton3().setSelected(true);
				mGUI.getAnswerButton3().setBackgroundColor(Color.BLUE);
				mData.getProvidedSolution().add(3);
			}
			break;
			
		case R.id.answer4:
			//if answer4 not clicked -> set on click and add to solution list
			if(mGUI.getAnswerButton4().isSelected()){
				
				mGUI.getAnswerButton4().setSelected(false);
				mGUI.getAnswerButton4().setBackgroundColor(mGUI.getInitialColor());
				mData.getProvidedSolution().remove(mData.getProvidedSolution().indexOf(4));
			}
			//else set unclicked and remove from solution list
			else{
				mGUI.getAnswerButton4().setSelected(true);
				mGUI.getAnswerButton4().setBackgroundColor(Color.BLUE);
				mData.getProvidedSolution().add(4);
			}
			
			break;
		case R.id.submit:
			//check the result and add points to the score for a correct answer
			checkResult(mData.getProvidedSolution(), mData.getSolution());
			break;
		}
	}
	
	public void checkResult(ArrayList<Integer> currentSolution, ArrayList<Integer> correctSolution){
		
		boolean correct = true;
		
		//if the number of selected answers is not correct, the solution is not correct!
		if(currentSolution.size()!=correctSolution.size()){
			correct = false;
		}
		else{
		//if a selected answer is not contained in the correct solution, the solution is not correct!
			for(Integer i: currentSolution){
				if(!correctSolution.contains(i)){
					correct = false;
					break;
				}
			}
		}
		
		if(!correct){
        	Toast.makeText(mActivity.getApplicationContext(), "You are wrong! New question, new luck!", Toast.LENGTH_LONG).show();
        	
        	//TODO read and use it or delete it
        	//if each single answer that fits counts, count correct answers
        	//WARNING!!! If the user selects all answers, he gets always the highest score
        	//Advise: GIVE NO POINTS HERE
        	//for(Integer i:currentSolution){
        	//  if(correctSolution.contains(i){
        	//    addToScore(pointsForOneCorrectAnswer);
        	//  }
        	//}
		}
		else{
			Toast.makeText(mActivity.getApplicationContext(), "Woohooo! You are right! Go on with the next question.", Toast.LENGTH_LONG).show();

			//give score for the correct answer and selection
			//TODO add scoring
			//addToScore(highestPossiblePointsForThisQuestion);
		}
		
		//TODO open next question
	}
	
	public void refreshGUI(){
		
	}

}
