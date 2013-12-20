package com.lesikapk.opengelplus.settings;

import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.astuetz.PagerSlidingTabStrip.IconTabProvider;
import com.lesikapk.opengelplus.R;

public class QuickContactFragment extends DialogFragment {

	private ImageView photo;
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private ContactPagerAdapter adapter;

	public static QuickContactFragment newInstance() {
		QuickContactFragment f = new QuickContactFragment();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (getDialog() != null) {
			getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		}

		View root = inflater.inflate(R.layout.fragment_quick_contact, container, false);
		photo = (ImageView) root.findViewById(R.id.photo);
		tabs = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
		pager = (ViewPager) root.findViewById(R.id.pager);
		adapter = new ContactPagerAdapter();

		pager.setAdapter(adapter);

		tabs.setViewPager(pager);

		return root;
	}

	@Override
	public void onStart() {
		super.onStart();

		// change dialog width
		if (getDialog() != null) {

			int fullWidth = getDialog().getWindow().getAttributes().width;

			Display display = getActivity().getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			fullWidth = size.x;

			final int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
					.getDisplayMetrics());

			int w = fullWidth - padding;
			int h = getDialog().getWindow().getAttributes().height;

			getDialog().getWindow().setLayout(w, h);
		}
	}

	public class ContactPagerAdapter extends PagerAdapter implements IconTabProvider {

		private final int[] ICONS = { R.mipmap.ic_launcher_phone, R.mipmap.ic_launcher_plusone,
				R.mipmap.ic_launcher_mail, R.drawable.ic_images };

		public ContactPagerAdapter() {
			super();
		}

		@Override
		public int getCount() {
			return ICONS.length;
		}

		@Override
		public int getPageIconResId(int position) {
			return ICONS[position];
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// looks a little bit messy here
			TextView v = new TextView(getActivity());
			v.setBackgroundResource(R.color.delete_target_hover_tint2);
			v.setTextSize(20);
			switch (position) {
				case 0:
					v.setText("Not for you lol");
				case 1:
					v.setText("nowthis is the second tab lol");
			}
			v.setPadding(20, 20, 0, 0);
			v.setGravity(Gravity.LEFT);
			container.addView(v, 0);
			return v;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object view) {
			container.removeView((View) view);
		}

		@Override
		public boolean isViewFromObject(View v, Object o) {
			return v == ((View) o);
		}

	}

}
