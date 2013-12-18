package com.android.launcher3.settings;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.android.launcher3.R;

/**
 * This fragment shows the preferences for the first header.
 */
public class WorkspaceSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_workspace);
        if (getEnabled()) {
        	Toast.makeText(getActivity(), "true!", Toast.LENGTH_SHORT).show();
        }
        if (!getEnabled()) {
        	Toast.makeText(getActivity(), "false!", Toast.LENGTH_SHORT).show();
        }
    }
    
    public boolean getEnabled() {
    	SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (sharedPrefs.getBoolean("checkbox_preference", true)) {
        	return true;
        }
        else {
        	return false;
        }
    }
}