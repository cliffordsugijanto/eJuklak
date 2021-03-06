package com.example.ejuklakapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Fragment used for managing interactions for and presentation of a navigation
 * drawer. See the <a href=
 * "https://developer.android.com/design/patterns/navigation-drawer.html#Interaction"
 * > design guidelines</a> for a complete explanation of the behaviors
 * implemented here.
 */
public class NavigationDrawerFragment extends Fragment {

	/**
	 * Remember the position of the selected item.
	 */
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	/**
	 * Per the design guidelines, you should show the drawer on launch until the
	 * user manually expands it. This shared preference tracks this.
	 */
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	/**
	 * A pointer to the current callbacks instance (the Activity).
	 */
	private NavigationDrawerCallbacks mCallbacks;

	/**
	 * Helper component that ties the action bar to the navigation drawer.
	 */
	private ActionBarDrawerToggle mDrawerToggle;
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerListView;
	private View mFragmentContainerView;
	private String[] titles;
	private int mCurrentSelectedPosition = 0;
	private boolean mFromSavedInstanceState;
	private boolean mUserLearnedDrawer;

	public NavigationDrawerFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Read in the flag indicating whether or not the user has demonstrated
		// awareness of the
		// drawer. See PREF_USER_LEARNED_DRAWER for details.
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState
					.getInt(STATE_SELECTED_POSITION);
			mFromSavedInstanceState = true;
		}

		// Select either the default item (0) or the last selected item.
		selectItem(mCurrentSelectedPosition);
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Indicate that this fragment would like to influence the set of
		// actions in the action bar.
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mDrawerListView = (ListView) inflater.inflate(
				R.layout.fragment_navigation_drawer, container, false);
		mDrawerListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						selectItem(position);
					}
				});
		mDrawerListView.setAdapter(new ArrayAdapter<String>(getActionBar()
				.getThemedContext(), android.R.layout.simple_list_item_1,
				android.R.id.text1, new String[] {
					"Kata Pengantar",
					"BAB 1 PENDAHULUAN",
					"+ 1.1 Sejarah Fakultas Teknologi dan Sains",
					"+ 1.2 Visi, Misi, Tujuan dan Sasaran FTIS",
					">> 1.2.1 Visi FTIS",
					">> 1.2.2 Misi FTIS",
					">> 1.2.3 Tujuan FTIS",
					">> 1.2.4 Sasaran FTIS",
					"+ 1.3 Keberhasilan FTIS",
					"+ 1.4 Pengelola Fakultas",
					"+ 1.5 Daftar Dosen FTIS",
					"BAB 2 PENYELENGGARAAN MATA KULIAH",
					"+ 2.1 Mata Kuliah Pilihan",
					"+ 2.2 Mata Kuliah Prasyarat",
					"+ 2.3 Mata Kuliah Layanan",
					">> 2.3.1 Mata Kuliah Layanan Program Studi Matematika",
					">> 2.3.2 Mata Kuliah Layanan Program Studi Fisika",
					">> 2.3.3 Mata Kuliah Layanan Program Studi Teknik Informatika",
					"+ 2.4 Mata Kuliah Umum",
					">> 2.4.1 Susunan Mata Kuliah Umum",
					">> 2.4.2 Uraian Singkat Mata Kuliah Umum",
					"+ 2.5 Kurikulum Program Studi Matematika",
					">> 2.5.1 Susunan Mata Kuliah",
					">> 2.5.2 Mata Kuliah Pilihan Program Studi Matematika",
					">> 2.5.3 Peta dan Prasyarat",
					">> 2.5.4 Deskripsi Singkat Mata Kuliah Program Studi Matematika",
					"+ 2.6 Kurikulum Program Studi Fisika",
					">> 2.6.1 Susunan Mata Kuliah",
					">> 2.6.2 Mata Kuliah Pilihan Program Studi Fisika",
					">> 2.6.3 Peta dan Prasyarat",
					">> 2.6.4 Deskripsi Singkat Mata Kuliah Program Studi Fisika",
					"+ 2.7 Kurikulum Program Studi Teknik Informatika",
					">> 2.7.1 Susunan Mata Kuliah",
					">> 2.7.2 Mata Kuliah Pilihan Program Studi Teknik Informatika",
					">> 2.7.3 Peta dan Prasyarat",
					">> 2.7.4 Deskripsi Singkat Mata Kuliah Program Studi Teknik Informatika",
					"BAB 3 KEGIATAN AKADEMIK",
					"+ 3.1 Penyusunan Rencana Studi",
					">> 3.1.1 Perwalian dan Penentuan Mata Kuliah",
					">> 3.1.2 Pendataran Mata Kuliah",
					">> 3.1.3 Tahap Perkuliahan Awal",
					">> 3.1.4 Perubahan Rencana Studi",
					"+ 3.2 Kegiatan Perkuliahan",
					"+ 3.3 Tata Cara Ujian",
					">> 3.3.1 Syarat Mengikuti Ujian",
					">> 3.3.2 Tata Tertib Ujian",
					">> 3.3.3 Sanksi",
					">> 3.3.4 Lain-lain",
					"+ 3.4 Cuti dan Gencat Studi",
					">> 3.4.1 Persyaratan Cuti Studi",
					">> 3.4.2 Prosedur Cuti Studi",
					">> 3.4.3 Gencat Studi",
					"+ 3.5 Pengunduran Diri Sebagai Mahasiswa",
					"BAB 4 EVALUASI KEBERHASILAN BELAJAR",
					"+ 4.1 Evaluasi Keberhasilan Belajar Tiap Mata Kuliah",
					"+ 4.2 Evaluasi Keberhasilan Belajar Dalam Satu Tahap Belajar",
					">> 4.2.1 Evaluasi Keberhasilan Belajar Tiap Semester",
					">> 4.2.2 Evaluasi Keberhasilan Belajar Tahap Pertama",
					">> 4.2.3 Evaluasi Keberhasilan Belajar Tahap Kedua",
					">> 4.2.4 Evaluasi Keberhasilan Belajar Tahap Akhir",
					"+ 4.3 Kemampuan Bahasa Inggris Mahasiswa UNPAR",
				}
				
				));
		mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
		return mDrawerListView;
	}

	
	public boolean isDrawerOpen() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	/**
	 * Users of this fragment must call this method to set up the navigation
	 * drawer interactions.
	 *
	 * @param fragmentId
	 *            The android:id of this fragment in its activity's layout.
	 * @param drawerLayout
	 *            The DrawerLayout containing this fragment's UI.
	 */
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// set up the drawer's list view with items and click listener

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.navigation_drawer_open, /*
										 * "open drawer" description for
										 * accessibility
										 */
		R.string.navigation_drawer_close /*
										 * "close drawer" description for
										 * accessibility
										 */
		) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				if (!isAdded()) {
					return;
				}

				getActivity().invalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					return;
				}

				if (!mUserLearnedDrawer) {
					// The user manually opened the drawer; store this flag to
					// prevent auto-showing
					// the navigation drawer automatically in the future.
					mUserLearnedDrawer = true;
					SharedPreferences sp = PreferenceManager
							.getDefaultSharedPreferences(getActivity());
					sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true)
							.commit();
				}

				getActivity().invalidateOptionsMenu(); // calls
																// onPrepareOptionsMenu()
			}
		};

		// If the user hasn't 'learned' about the drawer, open it to introduce
		// them to the drawer,
		// per the navigation drawer design guidelines.
		if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	private void selectItem(int position) {
		mCurrentSelectedPosition = position;
		if (mDrawerListView != null) {
			mDrawerListView.setItemChecked(position, true);
		}
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// If the drawer is open, show the global app actions in the action bar.
		// See also
		// showGlobalContextActionBar, which controls the top-left area of the
		// action bar.
		if (mDrawerLayout != null && isDrawerOpen()) {
			inflater.inflate(R.menu.global, menu);
			showGlobalContextActionBar();
		}
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * Per the navigation drawer design guidelines, updates the action bar to
	 * show the global app 'context', rather than just what's in the current
	 * screen.
	 */
	private void showGlobalContextActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setTitle(R.string.app_name);
	}

	private ActionBar getActionBar() {
		return ((ActionBarActivity) getActivity()).getSupportActionBar();
	}

	/**
	 * Callbacks interface that all activities using this fragment must
	 * implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);
	}
}
