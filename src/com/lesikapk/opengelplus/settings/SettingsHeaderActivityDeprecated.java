package com.lesikapk.opengelplus.settings;

import java.util.List;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.Button;

import com.lesikapk.opengelplus.R;

public class SettingsHeaderActivityDeprecated extends PreferenceActivity {
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
    	if ("com.lesikapk.opengelplus.settings.WorkspaceSettingsFragment".equals(fragmentName)
    		|| "com.lesikapk.opengelplus.settings.WorkspaceSettingsFragment2".equals(fragmentName)
    		|| "com.lesikapk.opengelplus.settings.WorkspaceSettingsFragment3".equals(fragmentName)
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