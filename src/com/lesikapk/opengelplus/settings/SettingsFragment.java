package com.lesikapk.opengelplus.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
	
	private static int ActiveLayout;
	
	public static SettingsFragment newInstance(int SubmittedLayout) {
		ActiveLayout = SubmittedLayout;
		SettingsFragment pageFragment = new SettingsFragment();
	    return pageFragment;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	addPreferencesFromResource(ActiveLayout);
    }
}