package com.lesikapk.opengelplus.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.lesikapk.opengelplus.R;

public class WorkspaceSettingsFragment extends PreferenceFragment {
	
	static WorkspaceSettingsFragment pageFragment;
	
	public static WorkspaceSettingsFragment newInstance() {
	    pageFragment = new WorkspaceSettingsFragment();
	    return pageFragment;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_workspace);
        Preference ckboxPref = this.findPreference("general_color");
        ckboxPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
    			SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    			// getThis returns the current object of the SettingsActivity
    			SettingsActivity.getThis().changeColor(sharedPrefs.getInt("general_color", R.color.general_application_color));
        		return true;
            }
        });
    }
    
    public boolean getEnabled() {
    	SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    	Toast.makeText(getActivity(), sharedPrefs.getInt("workspace_dock_icon_count", -1), Toast.LENGTH_SHORT).show();
        if (sharedPrefs.getBoolean("checkbox_preference", true)) {
        	return true;
        }
        else {
        	return false;
        }
    }
}