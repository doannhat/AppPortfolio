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
            List<String> appList = new ArrayList<>(Arrays.asList(appArray));

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
                    R.layout.list_item_app, R.id.list_app_bttn, appList);
            ListView listview = (ListView) rootView.findViewById(R.id.listView_apps);
            listview.setAdapter(arrayAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    String selectedApp = appArray[position];
                    String displayString = String.format("This button will launch my " + selectedApp
                            + " app!");
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            displayString, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            return rootView;
        }
    }
}
