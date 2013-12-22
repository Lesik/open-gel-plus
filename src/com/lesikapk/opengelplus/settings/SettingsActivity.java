/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 * limitations under the License.
 * 
 */

package com.lesikapk.opengelplus.settings;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.lesikapk.opengelplus.R;

public class SettingsActivity extends FragmentActivity {

	private final Handler handler = new Handler();
	protected static SettingsActivity mSelf;

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;

	private Drawable oldBackground = null;
	private int currentColor = 0xFF666666;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_tab_activity);
		SettingsActivity.mSelf = this;
		// This hides the actionbar which contains the activity name and icon, but the tabs will be shown.
		// It is important to leave this as-is and don't hide the actionbar in the manifest using Theme.Holo.NoActionBar, otherwise the app will crash.
//		getActionBar().hide();
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		currentColor = sharedPrefs.getInt("general_color", R.color.general_application_color);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);
		
		changeColor(currentColor);
	}
	
	public static SettingsActivity getThis() {
    	return SettingsActivity.mSelf;
    }
    
    @Override
	public void onPause() {
		super.onPause();
		System.exit(1);
	}
	@Override
	public void onStop() {
		super.onStop();
		System.exit(1);
	}
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    	System.exit(1);
    }
	//Not needed, used somewhere else.
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.settings_action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.item1:
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			return true;

		}

		return super.onOptionsItemSelected(item);
	}*/

	public void changeColor(int newColor) {

		tabs.setIndicatorColor(newColor);

		// change ActionBar color just if an ActionBar is available
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

			Drawable colorDrawable = new ColorDrawable(newColor);
			Drawable bottomDrawable = getResources().getDrawable(R.drawable.background_tab);
			LayerDrawable ld = new LayerDrawable(new Drawable[] { colorDrawable, bottomDrawable });

			// This is actually unnecessary because the actionbar is hidden anyways, however I will leave this because of the transition.
			if (oldBackground == null) {

				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					ld.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(ld);
				}

			} else {

				TransitionDrawable td = new TransitionDrawable(new Drawable[] { oldBackground, ld });

				// workaround for broken ActionBarContainer drawable handling on
				// pre-API 17 builds
				// https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					td.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(td);
				}

				td.startTransition(200);

			}

			oldBackground = ld;

			// http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
			getActionBar().setDisplayShowTitleEnabled(false);
			getActionBar().setDisplayShowTitleEnabled(true);

		}

		currentColor = newColor;

	}

	public void onColorClicked(View v) {
		int color = Color.parseColor(v.getTag().toString());
		changeColor(color);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("currentColor", currentColor);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		currentColor = savedInstanceState.getInt("currentColor");
		changeColor(currentColor);
	}

	private Drawable.Callback drawableCallback = new Drawable.Callback() {
		@Override
		public void invalidateDrawable(Drawable who) {
			getActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
			handler.postAtTime(what, when);
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
			handler.removeCallbacks(what);
		}
	};

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Workspace", "App Drawer", "Author" };
		
		/*@Override
		public float getPageWidth(int position) {
			if (position == 0) {
			    return(0.5f);
			}
			else {
			    return (1.0f);       
			}
		}*/
		
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
//			return SuperAwesomeCardFragment.newInstance(position);
			switch (position) {
				case 0:
					return WorkspaceSettingsFragment.newInstance();
				case 1:
					return AppDrawerSettingsFragment.newInstance();
				case 2:
					return InfoFragment.newInstance();
				default:
					return InfoFragment.newInstance();
			}
		}

	}

}