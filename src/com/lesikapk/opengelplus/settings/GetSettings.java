package com.lesikapk.opengelplus.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GetSettings extends Activity {
	
	private static GetSettings INSTANCE;
	
	public GetSettings() {
		
	}
	public static GetSettings getInstance(){
		return INSTANCE;
	}	
	public static boolean getBoolean(Context context) {
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPrefs.getBoolean("checkbox_preference", true)) {
        	return true;
        }
        else {
        	return false;
        }
	}
	public static int getDrawerRows() {
		Context c = GetSettings.getInstance();
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPrefs.getInt("drawer_grid_height", 5);
	}
	public static int getDrawerCols() {
		Context c = GetSettings.getInstance();
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        return sharedPrefs.getInt("drawer_grid_width", 6);
	}
}
