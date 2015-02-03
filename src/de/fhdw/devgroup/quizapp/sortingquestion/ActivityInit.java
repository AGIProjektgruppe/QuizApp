package de.fhdw.devgroup.quizapp.sortingquestion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import de.fhdw.devgroup.quizapp.R;
import de.fhdw.devgroup.quizapp.constants.Constants;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */

public class ActivityInit extends Activity {
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityApplicationLogic mApplicationLogic;
	private int[] questionOrder;
	private int questionNr;
	private int mScore;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Create","Succesfully Created");
        setContentView(R.layout.activity_sortingquestion);

			//QuestionManager.insertQuestions(this);
		
        initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
    }
    @Override
    protected void onResume(){
    	super.onResume();
    	
    	
    }

    private void initData(Bundle savedInstanceState) {
    	Bundle extras = getIntent().getExtras();
		if (extras != null) {
			questionOrder = extras.getIntArray(Constants.KEY_QUESTIONORDER);
			questionNr = extras.getInt(Constants.KEY_QUESTIONNUMBER);
			mScore = extras.getInt(Constants.KEY_QUESTIONSCORE);
		}
		mData = new ActivityData(savedInstanceState, this, questionOrder, questionNr ,mScore);
	}
	
	private void initGUI() {
		mGUI = new ActivityGUI(this);
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ActivityApplicationLogic(mData, mGUI, this);
	}
	
	private void initEventToListenerMapping() {
		new ActivityEventToListenerMapping(mGUI, mApplicationLogic);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
	
}
