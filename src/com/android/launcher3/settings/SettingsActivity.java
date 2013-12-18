package com.android.launcher3.settings;

import java.util.List;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.launcher3.R;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add a button to the header list.
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("Some action");
            setListFooter(button);
        }
    }

    /**
     * Populate the activity with the top-level headers.
     */
    @Override
    public void onBuildHeaders(List<Header> target) {
    	setTheme(android.R.style.Theme_Holo_Dialog);
        loadHeadersFromResource(R.xml.preference_headers, target);
    }
    
    protected boolean isValidFragment (String fragmentName) {
    	if ("com.android.launcher3.settings.WorkspaceSettingsFragment".equals(fragmentName)
    		|| "com.android.launcher3.settings.WorkspaceSettingsFragment2".equals(fragmentName)
    		|| "com.android.launcher3.settings.WorkspaceSettingsFragment3".equals(fragmentName)
    		){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    	System.exit(1);
    }
    
}