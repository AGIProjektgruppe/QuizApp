package de.fhdw.devgroup.quizapp.gapquestion;

import android.widget.Button;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Kevin Respondek
 *
 */
public class ActivityGUI {
	
	private TextView mText;
	private Button mButton1;
	private Button mButton2;
	private Button mButton3;
	private Button mButton4;
	
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_gapquestion);
		
		mText = (TextView) act.findViewById(R.id.question_text);
		mButton1 = (Button) act.findViewById(R.id.button1);
		mButton2 = (Button) act.findViewById(R.id.button2);
		mButton3 = (Button) act.findViewById(R.id.button3);
		mButton4 = (Button) act.findViewById(R.id.button4);
	}

	//getter and setter to access Views

	public TextView getmText() {
		return mText;
	}

	public void setmText(TextView mText) {
		this.mText = mText;
	}

	public Button getmButton1() {
		return mButton1;
	}

	public void setmButton1(Button mButton1) {
		this.mButton1 = mButton1;
	}

	public Button getmButton2() {
		return mButton2;
	}

	public void setmButton2(Button mButton2) {
		this.mButton2 = mButton2;
	}

	public Button getmButton3() {
		return mButton3;
	}

	public void setmButton3(Button mButton3) {
		this.mButton3 = mButton3;
	}

	public Button getmButton4() {
		return mButton4;
	}

	public void setmButton4(Button mButton4) {
		this.mButton4 = mButton4;
	}
}
