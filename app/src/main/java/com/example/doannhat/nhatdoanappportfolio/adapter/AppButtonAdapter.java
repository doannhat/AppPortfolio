package com.example.doannhat.nhatdoanappportfolio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.doannhat.nhatdoanappportfolio.R;

import java.util.ArrayList;

/**
 * Created by doannhat on 6/19/16.
 */
public class AppButtonAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    private Context context;

    public AppButtonAdapter(final ArrayList<String> list, final Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(final int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(final int pos) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View currentView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.list_item_app, null);
        }
        Button appButton = (Button) currentView.findViewById(R.id.list_app_bttn);
        CharSequence appName = list.get(position);
        appButton.setText(appName);
        appButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayString = String.format("This drawable_button will launch my "
                        + list.get(position) + " app!");
                Toast toast = Toast.makeText(context,
                        displayString, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return currentView;
    }
}

