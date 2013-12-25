package com.lesikapk.opengelplus.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
	
	private static int ActiveLayout;
	
	public static InfoFragment newInstance(int SubmittedLayout) {
		ActiveLayout = SubmittedLayout;
		InfoFragment pageFragment = new InfoFragment();
	    return pageFragment;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	addPreferencesFromResource(ActiveLayout);
    }
}