package de.fhdw.quizappfragentypbild.type.two;

import android.view.View;
import android.view.View.OnClickListener;
import de.fhdw.quizappfragentyp.R;

public class ActivityEventToListenerMapping  implements OnClickListener{
	
	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		//mGUI.getmConfirm().setOnClickListener(this);
		mGUI.getmButton1().setOnClickListener(this);
		mGUI.getmButton2().setOnClickListener(this);
		mGUI.getmButton3().setOnClickListener(this);
		mGUI.getmButton4().setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.button1: mApplicationLogic.onButton1Clicked(); break;
		case R.id.button2: mApplicationLogic.onButton2Clicked(); break;
		case R.id.button3: mApplicationLogic.onButton3Clicked(); break;
		case R.id.button4: mApplicationLogic.onButton4Clicked(); break;
		}	
	}


}
