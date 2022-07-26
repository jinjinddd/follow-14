package com.example.sd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout btn_tt;
    LinearLayout btn_quiz;
    LinearLayout btn_search;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    LinearLayout abtn_url;
    LinearLayout bbtn_url;
    LinearLayout cbtn_url;
    WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        mWebView = (WebView) view.findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www3.chosun.ac.kr/chosun/220/subview.do");

        abtn_url = (LinearLayout) view.findViewById(R.id.btn_url);
        abtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www4.chosun.ac.kr/acguide/9326/subview.do"));
                startActivity(urlintent);
            }
        });

        bbtn_url=(LinearLayout) view.findViewById(R.id.sw_url);
        bbtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent swintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sw.chosun.ac.kr/home/kor/board.do?menuPos=62"));
                startActivity(swintent);
            }
        });
        cbtn_url = (LinearLayout) view.findViewById(R.id.cu_url);

        cbtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cuintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cuplus.chosun.ac.kr/main/#210"));
                startActivity(cuintent);
            }
        });


        btn_tt=(LinearLayout) view.findViewById(R.id.btn_tt);
        btn_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddCourseActivity.class);
                HomeFragment.this.startActivity(intent);
            }
        });
        btn_quiz=(LinearLayout) view.findViewById(R.id.btn_quiz);
        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), pplus_activity__.class);
                startActivity(i);
            }
        });
        btn_search = (LinearLayout) view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent library = new Intent(Intent.ACTION_VIEW, Uri.parse("http://220.67.198.53/Domian5.asp"));
                startActivity(library);
            }
        });


        return view;
    }
}