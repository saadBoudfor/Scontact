package com.example.saad.scontact;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saad on 2/11/16.
 */
public class monAdapter extends SimpleAdapter {
    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    public monAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        ListView listView= (ListView) parent.findViewById(R.id.listviewperso);
        HashMap<String, String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
        Contact contact = (new ContactDAO(parent.getContext())).read(map.get("id"));

        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT

        // generate random color
        int color1 = generator.getRandomColor();

        // generate color based on a key (same key returns the same color), useful for list/grid views
        int color2 = generator.getColor(contact.getEmail());

        // declare the builder object once.
        TextDrawable.IBuilder builder = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .endConfig()
                .roundRect(10);

        TextDrawable ic1 = builder.build(String.valueOf(contact.getNom().charAt(0)).toUpperCase(), color1);


        ImageView imageView = (ImageView)  view.findViewById(R.id.img);
        imageView.setImageDrawable(ic1);
        return view;

    }
}
