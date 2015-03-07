package com.example.creawa2013;

import android.app.Activity;
import android.os.Bundle;

public class CompleteActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complete);

		StringBuffer sb = new StringBuffer();
		sb.append("おつかれさまでした！<br/>");
		sb.append("コーヒー 200円キャンペーン実施中！");
		sb.append("<font color=\"yellow\">24pt a</font>");
		sb.append("");
		sb.append("");
		sb.append("");
		sb.append("");
		String html = "";
	}
}
