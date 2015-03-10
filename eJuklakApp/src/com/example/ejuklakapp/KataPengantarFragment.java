package com.example.ejuklakapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class KataPengantarFragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "setion_number";
	
	public KataPengantarFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_katapengantar, container, false);
	}/*
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	public static KataPengantarFragment newInstance(int sectionNumber){
		KataPengantarFragment frag = new KataPengantarFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		frag.setArguments(args);
		return frag;
		
	}*/
	
}
