package oka.codedieux.com.restaurant.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.models.CartItem;
import oka.codedieux.com.restaurant.models.Restaurant;

public class CustomCartItemAdapter extends ArrayAdapter<CartItem> {

    public CustomCartItemAdapter(Context context, List<CartItem> objects) {
        super(context, R.layout.custom_spinner_cart_item, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customView = inflater.inflate(R.layout.custom_spinner_cart_item, parent, false);

        TextView name = (TextView) customView.findViewById(R.id.cartItemName);




        name.setText(getItem(position).getName());

        return customView;
    }
}
