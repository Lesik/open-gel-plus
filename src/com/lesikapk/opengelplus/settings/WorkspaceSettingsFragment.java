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
        if (getEnabled()) {
        	Toast.makeText(getActivity(), "true!", Toast.LENGTH_SHORT).show();
        }
        if (!getEnabled()) {
        	Toast.makeText(getActivity(), "false!", Toast.LENGTH_SHORT).show();
        }
        Preference ckboxPref = this.findPreference("general_color");
        ckboxPref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
    			SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    			int newColor = sharedPrefs.getInt("general_color", R.color.general_application_color);
    			SettingsActivity objSettingsActivity = SettingsActivity.getThis();
    			objSettingsActivity.changeColor(newColor);
//    			Toast.makeText(getActivity(), Integer.toHexString(mycolor), Toast.LENGTH_SHORT).show();
        		return true;
            }
        });
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