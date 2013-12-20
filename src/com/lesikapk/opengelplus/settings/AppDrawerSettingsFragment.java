package com.lesikapk.opengelplus.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.lesikapk.opengelplus.R;

public class AppDrawerSettingsFragment extends PreferenceFragment {
	
	public static WorkspaceSettingsFragment newInstance() {
	    WorkspaceSettingsFragment pageFragment = new WorkspaceSettingsFragment();
	    return pageFragment;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_app_drawer);
    }
}