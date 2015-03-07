package com.example.creawa2013;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CountDownActivity extends Activity implements OnClickListener {

	private ImageView mImageTimeHour10;
	private ImageView mImageTimeHour1;
	private ImageView mImageTimeMenutes10;
	private ImageView mImageTimeMenutes1;

	private ImageView mImageConterMenutes100;
	private ImageView mImageConterMenutes10;
	private ImageView mimageConterMenutes1;
	private ImageView mImageConterSeconds10;
	private ImageView mImageConterSeconds1;

	private TextView mButtonStart;
	private TextView mButtonEnd;

	private int counter = 1000;
	private boolean active = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.count_down);

		mImageTimeHour10 = (ImageView) this.findViewById(R.id.view_time_hour_10);
		mImageTimeHour1 = (ImageView) this.findViewById(R.id.view_time_hour_1);
		mImageTimeMenutes10 = (ImageView) this.findViewById(R.id.view_time_minutes_10);
		mImageTimeMenutes1 = (ImageView) this.findViewById(R.id.view_time_minutes_1);

		mImageConterMenutes100 = (ImageView) this.findViewById(R.id.view_counter_minutes_100);
		mImageConterMenutes10 = (ImageView) this.findViewById(R.id.view_counter_minutes_10);
		mimageConterMenutes1 = (ImageView) this.findViewById(R.id.view_counter_minutes_1);
		mImageConterSeconds10 = (ImageView) this.findViewById(R.id.view_counter_second_10);
		mImageConterSeconds1 = (ImageView) this.findViewById(R.id.view_counter_second_1);

		mButtonStart = (TextView) this.findViewById(R.id.view_start_button);
		mButtonStart.setOnClickListener(this);
		mButtonEnd = (TextView) this.findViewById(R.id.view_end_button);
		mButtonEnd.setOnClickListener(this);

		setCounter();
		setTime();
	}

	private void countdown() {
		Timer timer = new Timer(true);
		final Handler handler = new Handler();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				handler.post(new Runnable() {
					public void run() {
						counter = counter - 1;
						setCounter();
						setTime();
						if (counter <= 0 || active == false) {
							cancel();
							Intent intent = new Intent(CountDownActivity.this, CompleteActivity.class);
				            startActivity(intent);
						}
					}
				});
			}
		}, 0, 10);
	}

	private void setCounter() {
		int minutes1 = counter / 60; 
		int minutes2 = counter % 60; 

		int m1_100 = minutes1 / 100;
		int m1_10 = (minutes1 % 100) / 10;
		int m1_1 = (minutes1 % 100) % 10;

		int s2_10 = minutes2 / 10;
		int s2_1 = minutes2 % 10;

		setBackgroundRes(mImageConterMenutes100, m1_100);
		setBackgroundRes(mImageConterMenutes10, m1_10);
		setBackgroundRes(mimageConterMenutes1, m1_1);
		setBackgroundRes(mImageConterSeconds10, s2_10);
		setBackgroundRes(mImageConterSeconds1, s2_1);
	}

	private void setTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
	    int minute = cal.get(Calendar.MINUTE);

	    int h1_10 = hour / 10;
	    int h1_1 = hour % 10;

	    int m1_10 = minute / 10;
	    int m1_1 = minute % 10;

		setBackgroundRes(mImageTimeHour10, h1_10);
		setBackgroundRes(mImageTimeHour1, h1_1);
		setBackgroundRes(mImageTimeMenutes10, m1_10);
		setBackgroundRes(mImageTimeMenutes1, m1_1);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.view_start_button) {
			mButtonStart.setVisibility(View.GONE);
			mButtonEnd.setVisibility(View.VISIBLE);
			countdown();
		} else if (id == R.id.view_end_button) {
			active = false;
			finish();
		}
	}

	public void setBackgroundRes(ImageView v, int id) {
		if (id == 0) {
			v.setImageResource(R.drawable.c0);
		} else  if (id == 1) {
			v.setImageResource(R.drawable.c1);
		} else  if (id == 2) {
			v.setImageResource(R.drawable.c2);
		} else  if (id == 3) {
			v.setImageResource(R.drawable.c3);
		} else  if (id == 4) {
			v.setImageResource(R.drawable.c4);
		} else  if (id == 5) {
			v.setImageResource(R.drawable.c5);
		} else  if (id == 6) {
			v.setImageResource(R.drawable.c6);
		} else  if (id == 7) {
			v.setImageResource(R.drawable.c7);
		} else  if (id == 8) {
			v.setImageResource(R.drawable.c8);
		} else  if (id == 9) {
			v.setImageResource(R.drawable.c9);
		}
	}

}
