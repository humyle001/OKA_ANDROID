package oka.codedieux.com.restaurant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.models.Restaurant;

public class CustomRestaurantAdapter extends ArrayAdapter<Restaurant> {

    public CustomRestaurantAdapter(Context context, List<Restaurant> objects) {
        super(context, R.layout.custom_spinner_restaurant, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customView = inflater.inflate(R.layout.custom_spinner_restaurant, parent, false);

        TextView name = (TextView) customView.findViewById(R.id.restaurantName);




        name.setText(getItem(position).getName());

        return customView;
    }
}
