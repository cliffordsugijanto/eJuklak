package com.example.ejuklakapp;


import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private ViewFragment webView;
	private String HTMLPath;
	private String HTMLName;
	//private HTMLHeader[] headers= this.getHTMLHeaders();
	private String[] ids;
	private String[] headers;
	private CharSequence mTitle;
	final Activity activity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        HTMLName = "ejuklakgab.html";
        HTMLPath = "file:///android_asset/" + HTMLName;
        webView = new ViewFragment(HTMLPath);
        ids = this.getHTMLIds();
        headers = this.getHTMLHeaders();
        getFragmentManager().beginTransaction().replace(R.id.container, webView).commit();
        
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		ViewFragment fragment = new ViewFragment(HTMLPath);
		setTitle(R.string.title_section1);
//		switch (position) {
//		case 0:
//			fragment = new ViewFragment(HTMLPath+ids[position]);
//			setTitle(R.string.title_section1);
//			break;
//		case 1:
//			fragment = new Bab1Fragment();
//			setTitle(R.string.title_section2);
//			break;
//		case 2:
//			fragment = new Bab2Fragment();
//			setTitle(R.string.title_section3);
//			break;
//		case 3:
//			fragment = new Bab3Fragment();
//			setTitle(R.string.title_section4);
//			break;
//		case 4:
//			fragment = new Bab4Fragment();
//			setTitle(R.string.title_section5);
//			break;
//		default:
//			break;
//		}
//		
		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
		/*if (fragment != null) {
			getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}*/
		
		/*FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();*/
		
		/*switch (position+1) {
		case 1:
			fragmentManager.beginTransaction()
			.replace(R.id.container,Layout1Fragment.newInstance(position+1))
			.commit();
			break;
		case 2:
			fragmentManager.beginTransaction()
			.replace(R.id.container,Layout1Fragment.newInstance(position+1))
			.commit();
			break;
		}*/
	}
	

	public String[] getHTMLHeaders(){
		AssetManager assetManager = getAssets();
		String text = new String();
	    InputStream input;
	    try {
		    input = assetManager.open(HTMLName);
			int size = input.available();
		    byte[] buffer = new byte[size];
		    input.read(buffer);
		    input.close();
		    text = new String(buffer);
	    } catch (IOException e) {
           e.printStackTrace();
        }
	    
	    LinkedList<String> headerList = new LinkedList<String>();
	    String content = StringUtils.substringBetween(text, "<body>", "</body>");
	    String[] headers = StringUtils.substringsBetween(content, "<h", "/h");
	    for (String header : headers) {
          	String value  = StringUtils.substringBetween(header, ">", "<");
          	headerList.add(value);
	    }
	    headerList.addFirst("eJuklak");
	    String arr[] = headerList.toArray(new String[headerList.size()]);
	    return arr;
	}
	
	
	private String[] getHTMLIds(){
		AssetManager assetManager = getAssets();
		String text = new String();
	    InputStream input;
	    try {
		    input = assetManager.open(HTMLName);
			int size = input.available();
		    byte[] buffer = new byte[size];
		    input.read(buffer);
		    input.close();
		    text = new String(buffer);
	    } catch (IOException e) {
           e.printStackTrace();
        }
	    
	    LinkedList<String> idList = new LinkedList<String>();
	    String content = StringUtils.substringBetween(text, "<body>", "</body>");
	    String[] headers = StringUtils.substringsBetween(content, "<h", "/h");
	    for (String header : headers) {
          	String id  = StringUtils.substringBetween(header, "id=\"", "\">");
          	idList.add(id);
	    }
	    idList.addFirst("");
	    String arr[] = idList.toArray(new String[idList.size()]);
	    return arr;
	}
	/*public HTMLHeader[] getHTMLHeaders(){
    	AssetManager assetManager = getAssets();
		String text = new String();
	    InputStream input;
	    try {
		    input = assetManager.open(HTMLName);
			int size = input.available();
		    byte[] buffer = new byte[size];
		    input.read(buffer);
		    input.close();
		    text = new String(buffer);
	    } catch (IOException e) {
           e.printStackTrace();
        }
	    
	    LinkedList<HTMLHeader> headerList = new LinkedList<HTMLHeader>();
	    String content = StringUtils.substringBetween(text, "<body>", "</body>");
	    String[] headers = StringUtils.substringsBetween(content, "<h", "/h");
	    for (String header : headers) {
			String number  = StringUtils.substringBetween(header, "", " id");
          	String id  = StringUtils.substringBetween(header, "id=\"", "\">");
          	String value  = StringUtils.substringBetween(header, ">", "<");
          	headerList.add(new HTMLHeader(Integer.parseInt(number),id,value));
	    }
	    headerList.addFirst(new HTMLHeader(1,"","HOME"));
	    HTMLHeader[] headerArr = headerList.toArray(new HTMLHeader[headerList.size()]);
	    return headerArr;
    }*/
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		//getActionBar().setTitle(mTitle);
	}
	
/*
	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		}
	}*/

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
/*
		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}*/
	}

}
