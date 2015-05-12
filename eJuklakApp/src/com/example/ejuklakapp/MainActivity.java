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
import android.os.Handler;
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
	private CharSequence mTitle;
	final Activity activity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        HTMLName = "ejuklakgab.html";
        HTMLPath = "file:///android_asset/" + HTMLName;
        webView = new ViewFragment(HTMLPath);
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
			
			break;
			
		case 1:
			fragment = new ViewFragment(HTMLPath+"#bab-1-pendahuluan");
			
			break;
		
		case 2:
			fragment = new ViewFragment(HTMLPath+"#sejarah-fakultas-teknologi-informasi-dan-sains");
			
			break;
			
		case 3:
			fragment = new ViewFragment(HTMLPath+"#visi-misi-tujuan-dan-sasaran-ftis");
			
			break;
		
		case 4:
			fragment = new ViewFragment(HTMLPath+"#visi-ftis");
			
			break;
		
		case 5:
			fragment = new ViewFragment(HTMLPath+"#misi-ftis");
			
			break;
		
		case 6:
			fragment = new ViewFragment(HTMLPath+"#tujuan-ftis");
			
			break;
		
		case 7:
			fragment = new ViewFragment(HTMLPath+"#sasaran-ftis");
			
			break;
		
		case 8:
			fragment = new ViewFragment(HTMLPath+"#keberhasilan-ftis");
			
			break;
		
		case 9:
			fragment = new ViewFragment(HTMLPath+"#pengelola-fakultas");
			
			break;
			
		case 10:
			fragment = new ViewFragment(HTMLPath+"#daftar-dosen-ftis");
			
			break;
			
		case 11:
			fragment = new ViewFragment(HTMLPath+"#bab-2-penyelenggaraan-mata-kuliah");
			
			break;
			
		case 12:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan");
			
			break;

		case 13:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-prasyarat");
			
			break;
			
		case 14:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-layanan");
			
			break;
			
		case 15:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-matematika");
			
			break;
			
		case 16:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-fisika");
			
			break;
			
		case 17:
			fragment = new ViewFragment(HTMLPath+"#kuliah-layanan-program-studi-teknik-informatika");
			
			break;
			
		case 18:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-umum");
			
			break;
			
		case 19:
			fragment = new ViewFragment(HTMLPath+"#susunan-matakuliah-umum");
			
			break;
		
		case 20:
			fragment = new ViewFragment(HTMLPath+"#uraian-singkat-matakuliah-umum");
			
			break;
		
		case 21:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-matematika");
			
			break;
		
		case 22:
			fragment = new ViewFragment(HTMLPath+"#susunan-mata-kuliah");
			
			break;
		
		case 23:
			fragment = new ViewFragment(HTMLPath+"#mata-kuliah-pilihan-program-studi-matematika");
			
			break;
		
		case 24:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-mata-kuliah");
			
			break;
		
		case 25:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-singkat-mata-kuliah-prodi-matematika");
			
			break;
		
		case 26:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-fisika");
			
			break;
		
		case 27:
			fragment = new ViewFragment(HTMLPath+"#susunan-matakuliah");
			
			break;
	
		case 28:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan-program-studi-fisika");
			
			break;
		
		case 29:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-matakuliah");
			
			break;
		
		case 30:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-singkat-matakuliah-program-studi-fisika");
			
			break;
		
		case 31:
			fragment = new ViewFragment(HTMLPath+"#kurikulum-program-studi-teknik-informatika");
			
			break;
		
		case 32:
			fragment = new ViewFragment(HTMLPath+"#sususan-matakuliah");
			
			break;
		
		case 33:
			fragment = new ViewFragment(HTMLPath+"#matakuliah-pilihan-program-studi-teknik-informatika");
			
			break;
		
		case 34:
			fragment = new ViewFragment(HTMLPath+"#peta-dan-prasyarat-matakuliah-1");
			
			break;
		
		case 35:
			fragment = new ViewFragment(HTMLPath+"#deskripsi-matakuliah");
			
			break;
		
		case 36:
			fragment = new ViewFragment(HTMLPath+"#bab-3-kegiatan-akademik");
			
			break;
		
		case 37:
			fragment = new ViewFragment(HTMLPath+"#penyusunan-rencana-studi");
			
			break;
		
		case 38:
			fragment = new ViewFragment(HTMLPath+"#perwalian-dan-penentuan-mata-kuliah");
			
			break;
		
		case 39:
			fragment = new ViewFragment(HTMLPath+"#pendaftaran-mata-kuliah");
			
			break;
		
		case 40:
			fragment = new ViewFragment(HTMLPath+"#tahap-perkuliahan-awal");
			
			break;
		
		case 41:
			fragment = new ViewFragment(HTMLPath+"#perubahan-rencana-studi");
			
			break;
		
		case 42:
			fragment = new ViewFragment(HTMLPath+"#kegiatan-perkuliahan");
			
			break;
		
		case 43:
			fragment = new ViewFragment(HTMLPath+"#tata-cara-ujian");
			
			break;
		
		case 44:
			fragment = new ViewFragment(HTMLPath+"#syarat-mengikuti-ujian");
			
			break;
		
		case 45:
			fragment = new ViewFragment(HTMLPath+"#tata-tertib-ujian");
			
			break;
		
		case 46:
			fragment = new ViewFragment(HTMLPath+"#sanksi");
			
			break;
		
		case 47:
			fragment = new ViewFragment(HTMLPath+"#lain-lain");
			
			break;
		
		case 48:
			fragment = new ViewFragment(HTMLPath+"#cuti-dan-gencat-studi");
			
			break;
		
		case 49:
			fragment = new ViewFragment(HTMLPath+"#persyaratan-cuti-studi");
			
			break;
			
		case 50:
			fragment = new ViewFragment(HTMLPath+"#prosedur-cuti-studi");
			
			break;
			
		case 51:
			fragment = new ViewFragment(HTMLPath+"#gencat-studi");
			
			break;
			
		case 52:
			fragment = new ViewFragment(HTMLPath+"#pengunduran-diri-sebagai-mahasiswa");
			
			break;
			
		case 53:
			fragment = new ViewFragment(HTMLPath+"#bab-4-evaluasi-keberhasilan-belajar");
			
			break;
			
		case 54:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tiap-mata-kuliah");
			
			break;
			
		case 55:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-dalam-suatu-tahap-belajar");
			
			break;
			
		case 56:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tiap-semester");
			
			break;
			
		case 57:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-pertama");
			
			break;
			
		case 58:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-kedua");
			
			break;
			
		case 59:
			fragment = new ViewFragment(HTMLPath+"#evaluasi-keberhasilan-belajar-tahap-akhir");
			
			break;
			
		case 60:
			fragment = new ViewFragment(HTMLPath+"#kemampuan-bahasa-inggris-mahasiswa-unpar");
			
			break;
		
		}

		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
	}

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
			.setMessage("(c) 2015 eJuklakApp v1.0")
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
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	
	boolean doubleBackToExitPressedOnce;
	@Override
	public void onBackPressed() {
	    if (doubleBackToExitPressedOnce) {
		    new AlertDialog.Builder(this)
		        .setIcon(android.R.drawable.ic_dialog_alert)
		        .setTitle("Exit eJuklakApp")
		        .setMessage("Are you sure you want to exit?")
		        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
		        {
			        @Override
			        public void onClick(DialogInterface dialog, int which) {
			            finish();    
			        }
			
			    })
			    .setNegativeButton("No", null)
			    .show();	
	    }
	    else{
	    	ViewFragment fragment = new ViewFragment(HTMLPath);
		    getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
	    }
	    
	    this.doubleBackToExitPressedOnce = true;
	    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

	    
	    new Handler().postDelayed(new Runnable() {

	        @Override
	        public void run() {
	            doubleBackToExitPressedOnce=false;                       
	        }
	    }, 3000);
	    																						
	} 
}
