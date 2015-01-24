package de.fhdw.quizappfragentypbild.type.one;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import de.fhdw.quizappfragentyp.R;

public class ActivityGUI {
	
	private ImageView mImage;
	private TextView mText;
	private EditText mAnswer;
	private Button mConfirm;
	
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_type_one);
		
		mImage = (ImageView) act.findViewById(R.id.imageViewt1);
		mText = (TextView) act.findViewById(R.id.t1_question_text);
		mAnswer = (EditText) act.findViewById(R.id.answer_textfield);
		mConfirm = (Button) act.findViewById(R.id.confirm_button);
	}
	
	//getter and setter to access Views

	public ImageView getmImage() {
		return mImage;
	}

	public void setmImage(ImageView mImage) {
		this.mImage = mImage;
	}

	public TextView getmText() {
		return mText;
	}

	public void setmText(String mText) {
		this.mText.setText(mText);
	}

	public EditText getmAnswer() {
		return mAnswer;
	}

	public void setmAnswer(EditText mAnswer) {
		this.mAnswer = mAnswer;
	}

	public Button getmConfirm() {
		return mConfirm;
	}

	public void setmConfirm(Button mConfirm) {
		this.mConfirm = mConfirm;
	}
}
