package fr.epita.android.mealdbapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomList  extends ArrayAdapter<String> {

    private final Activity context;
    public CustomList(Activity context) {
        super(context, R.layout.activity_main );
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_main, null, true);
        ListView listv = (ListView) rowView.findViewById(R.id.list);



        return rowView;
    }
}

