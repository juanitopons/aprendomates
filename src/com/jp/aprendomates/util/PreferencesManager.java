package com.jp.aprendomates.util;




import android.preference.PreferenceManager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;

public class PreferencesManager extends Application {
	private Activity activity;
    private SharedPreferences prefs;
    
    @Override
    public void onCreate() {
    	super.onCreate();
    	PreferenceManager.setDefaultValues(getApplicationContext(), com.jp.aprendomates.R.xml.preferences, false);
		prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());	
    }
    
    public void setActivity(Activity activity) {
    	this.activity = activity;
    }
	
	public void update() {
		PreferenceManager.setDefaultValues(activity, null, com.jp.aprendomates.R.xml.preferences, Context.MODE_PRIVATE, false);
		prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		setOrientation();
		// and continue wit all future SETS preferences
	}
	
	public void setOrientation() {
		//Update activity orientation
		switch(Integer.parseInt(prefs.getString("orientation", "0"))) {
		case 0:
			//---change to landscape mode---
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			break;
		case 1:
			//---change to portrait mode---
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			break;
		}
	}

}
