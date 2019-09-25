package oka.codedieux.com.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.adapters.CustomRestaurantMenuAdapter;
import oka.codedieux.com.restaurant.models.Item;

public class RestaurantMenuActivity extends AppCompatActivity {
    private Context context;
    private ListView itemListView;
    private CustomRestaurantMenuAdapter customRestaurantMenuAdapter;
    private List<Item> items;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        context = this;
        initializeView();
        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent menuActivity = new Intent(RestaurantMenuActivity.this, CartActivity.class);
                startActivity(menuActivity);
                finish();
            }
        });
        itemListView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    private void initializeView(){
        itemListView = findViewById(R.id.itemsListView);
        tabLayout = findViewById(R.id.catLayout);
        items = new ArrayList<>();
        Item i1 = new Item();Item i2 = new Item();Item i3 = new Item();Item i4 = new Item();Item i5 = new Item();Item i6 = new Item();
        i1.setName("Item 1");i2.setName("Item 2");i3.setName("Item 3");i4.setName("Item 4");i5.setName("Item 5");i6.setName("Item 6");
        items.add(i6);items.add(i5);items.add(i4);items.add(i3);items.add(i2);items.add(i1);
        customRestaurantMenuAdapter = new CustomRestaurantMenuAdapter(context,items);
        itemListView.setAdapter(customRestaurantMenuAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Cat 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat 5"));
        tabLayout.addTab(tabLayout.newTab().setText("Cat 6"));


    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RestaurantMenuActivity.this,RestaurantsActivity.class);
        startActivity(intent);
        finish();
    }
}
