package oka.codedieux.com.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.adapters.CustomRestaurantAdapter;
import oka.codedieux.com.restaurant.models.Restaurant;

public class RestaurantsActivity extends AppCompatActivity {
    private Context context;
    private ListView restaurantsListView;
    private List<Restaurant> restaurants;
    private CustomRestaurantAdapter restaurantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        context = this;
        initializeView();

        restaurantsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent menuActivity = new Intent(RestaurantsActivity.this, RestaurantMenuActivity.class);
                startActivity(menuActivity);
                finish();
            }
        });
    }

    private void initializeView(){
        restaurantsListView = findViewById(R.id.restaurantsListView);
        restaurants = new ArrayList<>();
        restaurantsListView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        Restaurant res1 = new Restaurant();
        res1.setName("Restaurant 1");
        Restaurant res2 = new Restaurant();
        res2.setName("Restaurant 2");
        Restaurant res3 = new Restaurant();
        res3.setName("Restaurant 3");
        Restaurant res4 = new Restaurant();
        res4.setName("Restaurant 4");
        Restaurant res5 = new Restaurant();
        res5.setName("Restaurant 5");
        restaurants.add(res5);
        restaurants.add(res4);
        restaurants.add(res3);
        restaurants.add(res2);
        restaurants.add(res1);
        restaurantAdapter = new CustomRestaurantAdapter(context,restaurants);
        restaurantsListView.setAdapter(restaurantAdapter);
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

    }
}
