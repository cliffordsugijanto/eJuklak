package com.example.ejuklakapp;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ViewFragment extends Fragment {

	private static final String ARG_SECTION_NUMBER = "setion_number";
	
	String HTMLPath;
	WebView webView;


	public ViewFragment(String HTMLPath) {
		this.HTMLPath = HTMLPath;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view, container, false);
        webView = (WebView) rootView.findViewById(R.id.webView); 
        webView.loadUrl(HTMLPath); 
        return rootView;
    }
	
	
}
