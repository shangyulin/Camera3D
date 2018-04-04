package com.example.shangyulin.camera3d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shangyulin on 2018/4/4.
 */

public class PictureAdapter extends ArrayAdapter<Picture> {

    public PictureAdapter(Context context, int textViewResourceId, List<Picture> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Picture picture = getItem(position);
        View view;
        if (convertView == null) {
            view = View.inflate(getContext(), android.R.layout.simple_list_item_1, null);
        } else {
            view = convertView;
        }
        TextView text1 = view.findViewById(android.R.id.text1);
        text1.setText(picture.getName());
        return view;
    }
}
