package com.lesikapk.opengelplus.settings;


import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.lesikapk.opengelplus.R;

public class InfoFragment extends PreferenceFragment {
	
	public static InfoFragment newInstance() {
	    InfoFragment pageFragment = new InfoFragment();
	    return pageFragment;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	addPreferencesFromResource(R.xml.preference_author);
    }
    
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.author_fragment, container, false);
    	RelativeLayout authorBadge = (RelativeLayout) view.findViewById(R.id.author_badge);
    	authorBadge.setOnClickListener(new View.OnClickListener(){
    	    @Override
    	    public void onClick(View v){
    	    	Toast.makeText(getActivity(), "Click on one of the logos to get to my pages. I hope this message will be replaced by a beautiful fragment soon.", Toast.LENGTH_SHORT).show();
    	    }
    	});
    	ImageView twitterButton = (ImageView) view.findViewById(R.id.twitter_button);
    	twitterButton.setOnClickListener(new View.OnClickListener(){
    	    @Override
    	    public void onClick(View v){
    	    	Intent i = new Intent(Intent.ACTION_VIEW);
    	    	startActivity(i.setData(Uri.parse("https://twitter.com/printworkingdir")));
    	    }
    	});
    	ImageView githubButton = (ImageView) view.findViewById(R.id.github_button);
    	githubButton.setOnClickListener(new View.OnClickListener(){
    	    @Override
    	    public void onClick(View v){
    	    	Intent i = new Intent(Intent.ACTION_VIEW);
    	    	startActivity(i.setData(Uri.parse("https://github.com/Lesik/")));
    	    }
    	});
    	ImageView authorPicture = (ImageView) view.findViewById(R.id.photo);
    	Bitmap authorPictureBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.author_picture);
    	authorPicture.setImageBitmap(authorPictureBitmap);
    	return view;
    }*/
    /*private void showAuthorInfo() {
    	//NOT WORKING PROPERLY
        QuickContactFragment dialog = new QuickContactFragment();
    	dialog.show(getFragmentManager(), "QuickContactFragment");
    }*/
}