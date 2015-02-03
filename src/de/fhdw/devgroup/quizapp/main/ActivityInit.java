package de.fhdw.devgroup.quizapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import de.fhdw.devgroup.quizapp.R;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityInit extends Activity {
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityApplicationLogic mApplicationLogic;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Create","Succesfully Created");
        setContentView(R.layout.activity_main);
        initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
    }

    private void initData(Bundle savedInstanceState) {
		mData = new ActivityData(savedInstanceState, this);
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
