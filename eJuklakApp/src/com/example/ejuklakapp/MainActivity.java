package com.example.ejuklakapp;


import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
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
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
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
import android.widget.Toast;

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
		ViewFragment fragment = null;
		switch (position) {
		case 0:
			fragment = new ViewFragment(HTMLPath+"#kata-pengantar");
			setTitle("eJuklakApp-Kata Pengantar");
			break;
			
		case 1:
			fragment = new ViewFragment(HTMLPath+"#bab-1-pendahuluan");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 2:
			fragment = new ViewFragment(HTMLPath+"#sejarah-fakultas-teknologi-informasi-dan-sains");
			setTitle("eJuklakApp-Bab 1");
			break;
			
		case 3:
			fragment = new ViewFragment(HTMLPath+"#visi-misi-tujuan-dan-sasaran-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 4:
			fragment = new ViewFragment(HTMLPath+"#visi-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 5:
			fragment = new ViewFragment(HTMLPath+"#misi-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 6:
			fragment = new ViewFragment(HTMLPath+"#tujuan-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 7:
			fragment = new ViewFragment(HTMLPath+"#sasaran-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 8:
			fragment = new ViewFragment(HTMLPath+"#keberhasilan-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
		
		case 9:
			fragment = new ViewFragment(HTMLPath+"#pengelola-fakultas");
			setTitle("eJuklakApp-Bab 1");
			break;
			
		case 10:
			fragment = new ViewFragment(HTMLPath+"#daftar-dosen-ftis");
			setTitle("eJuklakApp-Bab 1");
			break;
			
		case 11:
			fragment = new ViewFragment(HTMLPath+"#bab-2-penyelenggaraan-mata-kuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 12:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan");
			setTitle("eJuklakApp-Bab 2");
			break;

		case 13:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-prasyarat");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 14:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-layanan");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 15:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-matematika");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 16:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-fisika");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 17:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-teknik-informatika");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 18:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-umum");
			setTitle("eJuklakApp-Bab 2");
			break;
			
		case 19:
			fragment = new ViewFragment(HTMLPath+"#susunan-matakuliah-umum");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 20:
			fragment = new ViewFragment(HTMLPath+"#uraian-singkat-matakuliah-umum");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 21:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-matematika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 22:
			fragment = new ViewFragment(HTMLPath+"#susunan-mata-kuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 23:
			fragment = new ViewFragment(HTMLPath+"#mata-kuliah-pilihan-program-studi-matematika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 24:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-mata-kuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 25:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-singkat-mata-kuliah-prodi-matematika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 26:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-fisika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 27:
			fragment = new ViewFragment(HTMLPath+"#susunan-matakuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
	
		case 28:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan-program-studi-fisika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 29:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-matakuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 30:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-singkat-matakuliah-program-studi-fisika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 31:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-teknik-informatika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 32:
			fragment = new ViewFragment(HTMLPath+"#sususan-matakuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 33:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan-program-studi-teknik-informatika");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 34:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-matakuliah-1");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 35:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-matakuliah");
			setTitle("eJuklakApp-Bab 2");
			break;
		
		case 36:
			fragment = new ViewFragment(HTMLPath+"#bab-3-kegiatan-akademik");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 37:
			fragment = new ViewFragment(HTMLPath+"#penyusunan-rencana-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 38:
			fragment = new ViewFragment(HTMLPath+"#perwalian-dan-penentuan-mata-kuliah");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 39:
			fragment = new ViewFragment(HTMLPath+"#pendaftaran-mata-kuliah");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 40:
			fragment = new ViewFragment(HTMLPath+"#tahap-perkuliahan-awal");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 41:
			fragment = new ViewFragment(HTMLPath+"#perubahan-rencana-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 42:
			fragment = new ViewFragment(HTMLPath+"#kegiatan-perkuliahan");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 43:
			fragment = new ViewFragment(HTMLPath+"#tata-cara-ujian");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 44:
			fragment = new ViewFragment(HTMLPath+"#syarat-mengikuti-ujian");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 45:
			fragment = new ViewFragment(HTMLPath+"#tata-tertib-ujian");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 46:
			fragment = new ViewFragment(HTMLPath+"#sanksi");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 47:
			fragment = new ViewFragment(HTMLPath+"#lain-lain");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 48:
			fragment = new ViewFragment(HTMLPath+"#cuti-dan-gencat-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
		
		case 49:
			fragment = new ViewFragment(HTMLPath+"#persyaratan-cuti-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
			
		case 50:
			fragment = new ViewFragment(HTMLPath+"#prosedur-cuti-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
			
		case 51:
			fragment = new ViewFragment(HTMLPath+"#gencat-studi");
			setTitle("eJuklakApp-Bab 3");
			break;
			
		case 52:
			fragment = new ViewFragment(HTMLPath+"#pengunduran-diri-sebagai-mahasiswa");
			setTitle("eJuklakApp-Bab 3");
			break;
			
		case 53:
			fragment = new ViewFragment(HTMLPath+"#bab-4-evaluasi-keberhasilan-belajar");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 54:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tiap-mata-kuliah");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 55:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-dalam-suatu-tahap-belajar");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 56:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tiap-semester");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 57:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-pertama");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 58:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-kedua");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 59:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-akhir");
			setTitle("eJuklakApp-Bab 4");
			break;
			
		case 60:
			fragment = new ViewFragment(HTMLPath+"#kemampuan-bahasa-inggris-mahasiswa-unpar");
			setTitle("eJuklakApp-Bab 4");
			break;
		
		}

		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
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
			new AlertDialog.Builder(MainActivity.this)
			.setTitle("About")
			.setMessage("(c) 2015 eJuklakApp v0.4-beta rev1")
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
				}
			})
			.show();
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

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);

	    // Checks the orientation of the screen
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	        //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
	        //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
	    }
	}
}
