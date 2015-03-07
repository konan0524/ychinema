package com.example.creawa2013;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

public class MainActivity extends Activity implements OnClickListener {

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.findViewById(R.id.intro_layout).setOnClickListener(this);

		Intent intent = getIntent();
		if (intent != null) {
			byte[] idm = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
			if (idm != null) {
				setVolume();
				setContrast();
			}
		}
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.intro_layout) {
			Intent intent = new Intent(MainActivity.this, CountDownActivity.class);
            startActivity(intent);
		}
	}

	/**
	 * 消音にする
	 */
	public void setVolume() {
		try {
			AudioManager manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
			manager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
			manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 画面を暗くする。ただし、アプリ終了すると元の明るさに戻ってしまう。
	 */
	public void setContrast() {
		WindowManager.LayoutParams lp = getWindow().getAttributes();
		lp.screenBrightness = 0.0f;
		getWindow().setAttributes(lp);
	}

	/**
	 * 電源を落とす。電源ボタン長押しをエミュレートしてできないか模索中。
	 */
	public void setPower() {
		KeyEvent event = new KeyEvent(KeyEvent.FLAG_LONG_PRESS, KeyEvent.KEYCODE_POWER);
		dispatchKeyEvent(event);
//		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//		pm.goToSleep(1000);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
//       Log.d("KeyCode","KeyCode:"+ e.getKeyCode());
       if (e.getKeyCode() == KeyEvent.KEYCODE_POWER) {
       }
	   return super.dispatchKeyEvent(e);
	}
}
