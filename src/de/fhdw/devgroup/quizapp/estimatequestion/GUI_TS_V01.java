package de.fhdw.devgroup.quizapp.estimatequestion;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */

public class GUI_TS_V01 {
	
	private TextView tvQuestion;
	private Button btnsubmit;
	private EditText etAnswer;
	
	public GUI_TS_V01(Init_TS_V01 act) {
		act.setContentView(R.layout.layout_e_ts_v01);
		
		tvQuestion = (TextView) act.findViewById(R.id.textView01);
		btnsubmit = (Button) act.findViewById(R.id.btn1);
		etAnswer = (EditText) act.findViewById(R.id.editTextField1);
	}

	public TextView getTvQuestion() {
		return tvQuestion;
	}

	public void setTvQuestion(TextView tvQuestion) {
		this.tvQuestion = tvQuestion;
	}

	public Button getBtnsubmit() {
		return btnsubmit;
	}

	public void setBtnsubmit(Button btnsubmit) {
		this.btnsubmit = btnsubmit;
	}

	public EditText getEtAnswer() {
		return etAnswer;
	}
	
	public void setEtAnswer(EditText etAnswer) {
		this.etAnswer = etAnswer;
	}

	public void setTvQuestionText(String questionText) {
		this.tvQuestion.setText(questionText);
	}
	
}
