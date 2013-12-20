package com.lesikapk.opengelplus.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.lesikapk.opengelplus.R;

public class WorkspaceSettingsFragment extends PreferenceFragment {
	
	public static WorkspaceSettingsFragment newInstance() {
	    WorkspaceSettingsFragment pageFragment = new WorkspaceSettingsFragment();
	    return pageFragment;
	}
	
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