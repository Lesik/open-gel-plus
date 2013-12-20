package com.lesikapk.opengelplus.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GetSettings extends Activity {
	public GetSettings() {
		
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
	public static int getWorkspaceIconSize(Context context) {
		return 17;
	}
}
