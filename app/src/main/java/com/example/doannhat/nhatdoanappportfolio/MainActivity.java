package com.example.doannhat.nhatdoanappportfolio;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.doannhat.nhatdoanappportfolio.adapter.AppButtonAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final String [] appArray = {"POPULAR MOVIES",
                "STOCK HAWK",
                "BUILD IT BIGGER",
                "MAKE YOUR APP MATERIAL",
                "GO UBIQUITOUS",
                "CAPSTONE"};
            ArrayList<String> appList = new ArrayList<>(Arrays.asList(appArray));

            AppButtonAdapter appButtonAdapter = new AppButtonAdapter(appList, getContext());

            ListView listview = (ListView) rootView.findViewById(R.id.listView_apps);
            listview.setAdapter(appButtonAdapter);

            return rootView;
        }
    }
}
