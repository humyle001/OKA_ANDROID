package oka.codedieux.com.restaurant.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import oka.codedieux.com.restaurant.R;

public class CheckoutActivity extends AppCompatActivity {
    private Context context;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        context = this;
        initializeView();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(context);
            }
        });
    }


    private void initializeView(){
        btn_send =findViewById(R.id.btn_send);
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
        Intent intent = new Intent(CheckoutActivity.this,CartActivity.class);
        startActivity(intent);
        finish();
    }

    private void showCustomDialog(final Context context) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_dialog_track_order, null, false);
        Button track = findViewById(R.id.btn_track);  /*HERE YOU CAN FIND YOU IDS AND SET TEXTS OR BUTTONS*/
        ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setContentView(view);
        final Window window = dialog.getWindow();
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.60);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        window.setLayout(width, height);
        window.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rounded_dialog_background));
        window.setGravity(Gravity.CENTER);
        dialog.setCancelable(false);
        dialog.show();
    }
}
