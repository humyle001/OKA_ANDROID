package oka.codedieux.com.restaurant.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.adapters.CustomCartItemAdapter;
import oka.codedieux.com.restaurant.models.CartItem;

public class CartActivity extends AppCompatActivity {
    private Context context;
    private List<CartItem> cartItems;
    private ListView cartItemListView;
    private CustomCartItemAdapter customCartItemAdapter;
    private Button checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        context = this;
        initializeView();
        cartItemListView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this,CheckoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initializeView(){
        cartItemListView = findViewById(R.id.cartItemsListView);
        checkout = findViewById(R.id.btn_checkout);
        cartItems = new ArrayList<>();
        CartItem i1 = new CartItem();CartItem i2 = new CartItem();CartItem i3 = new CartItem();CartItem i4 = new CartItem();CartItem i5 = new CartItem();CartItem i6 = new CartItem();
        i1.setName("Item 1");i2.setName("Item 2");i3.setName("Item 3");i4.setName("Item 4");i5.setName("Item 5");i6.setName("Item 6");
        cartItems.add(i6);cartItems.add(i5);cartItems.add(i4);cartItems.add(i3);cartItems.add(i2);cartItems.add(i1);
        customCartItemAdapter =new CustomCartItemAdapter(context,cartItems);
        cartItemListView.setAdapter(customCartItemAdapter);
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
        Intent intent = new Intent(CartActivity.this,RestaurantMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
