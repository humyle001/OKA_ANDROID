package oka.codedieux.com.restaurant.activities;


import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oka.codedieux.com.restaurant.R;
import oka.codedieux.com.restaurant.config.Session;
import oka.codedieux.com.restaurant.operations.NetworkOperations;

public class LoginActivity extends AppCompatActivity {
    final int splash_timout = 4000;//4 seconds
    private Button login;

    private Context context;
//    private User newUser;
//test commet hello
    //git push
    private View layoutLogin,iota_button;
    ProgressDialog progressDialog;
    String loginMessage;
    private NetworkOperations networkOperations;
    boolean hasUserPreferences;
    EditText username, password;
    String usernameString, passwordString;
//    UserOperations userOperations;
    CheckBox rememberMe;
//    DatabaseOperations databaseOperations;
    private static final int PERMISSIONS_REQUEST_CODE = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
//changedddd

        setContentView(R.layout.activity_login);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkAndRequestPermissions()) {
// carry on the normal flow, as the case of permissions granted.
            }

        }

        login = (Button) findViewById(R.id.btn_login);
        layoutLogin = (View) findViewById(R.id.layoutlogin);
        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
//        databaseOperations = new DatabaseOperations(context);
        networkOperations = new NetworkOperations(context);
//        userOperations = new UserOperations(context);

//        if (!userOperations.getUserPreferences()) {
//            Intent loginActivity = new Intent(LoginActivity.this, MainTakerActivity.class);
//            loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            loginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            newUser = databaseOperations.getUser(databaseOperations.getPersistentUserID());
//            Session.setCurrentUser(newUser);
//            startActivity(loginActivity);
//            finish();
//        }

        rememberMe = (CheckBox) findViewById(R.id.remmemberme);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(networkOperations.getNetworkType() != null){
//                    performLogin();
                    Intent intent = new Intent(LoginActivity.this,RestaurantsActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(context,"weak or no network!",Toast.LENGTH_LONG).show();
                }

            }
        });



//
//        if ( null != Session.getCurrentUser()) {
//            System.out.println("Session is not null");
//
//            switchToSplash();
//        }

//        preEmptiveCheck();

    }

    @Override
    public void onBackPressed() {

    }

//    private void performLogin() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        getLogin();
//
//                    }
//                }, splash_timout);
//            }
//        });
//    }

//    private void getLogin() {
//        showProgressDialog();
//        runOnUiThread(new Runnable() {
//            public void run() {
//                actuateLogin();
//            }
//        });
//
//    }
//    public void preEmptiveCheck() {
//        hasUserPreferences = userOperations.getUserPreferences();
//        System.out.println("preEmpative check: hasUserPreference? " + hasUserPreferences);
//        if (hasUserPreferences) {
//
//            performLogin();
//        }
//    }


//    public void actuateLogin() {
//        newUser = new User();
//
//        usernameString = username.getText().toString();
//        passwordString = password.getText().toString();
//
//        newUser.setUsername(usernameString);
//        newUser.setPassword(passwordString);
//
//        userOperations.setUser(newUser);
//
//// performLoginTest(username, password); //for testing only
//        performProcessLogin();
//    }
//
//    public void performProcessLogin() {
//        boolean isUserValid = userOperations.authenticateUser();
//        dismissProgressDialog();
//
//
//        System.out.println("LoginActivity:348 performLogin: isUserValid? " + isUserValid);
//        if (isUserValid) {
//            System.out.println("LoginActivity:350 performLogin: inside IF");
//            if (rememberMe.isChecked()) {
//                System.out.println("LoginActivity:355 performLogin: Remember is checked");
//                System.out.println("LoginActivity:355 performLogin: Password: " + password);
//                Session.setCurrentUser(newUser);
//                userOperations.setUserPreferences();
//            }
//
//
//            Session.setCurrentUser(userOperations.getUser());
//
//            loginMessage = "Successfully logged in.";
//            System.out.println("performLogin: User valid, switching to Main Screen ");
//            switchToSplash();
//        } else {
//            System.out.println("performLogin: User NOT valid, isUserValid? " + isUserValid);
//            loginMessage = "Invalid user. Please try again.";
//            layoutLogin.setVisibility(View.VISIBLE);
//            circular_p_bar.setVisibility(View.GONE);
//        }
//        System.out.println("performLogin: hasUserPreferences? " + hasUserPreferences);
//
//        showLoginMessage();
//
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE: {

                Map<String, Integer> perms = new HashMap<>();
// Initialize the map with both permissions
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WAKE_LOCK, PackageManager.PERMISSION_GRANTED);

                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.RECORD_AUDIO, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.SEND_SMS, PackageManager.PERMISSION_GRANTED);
// Fill with actual results from user
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++)
                        perms.put(permissions[i], grantResults[i]);
// Check for both permissions
                    if (perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.WAKE_LOCK) == PackageManager.PERMISSION_GRANTED
                            ) {

// process the normal flow
//else any one or both the permissions are not granted
                    } else {

//permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
// // shouldShowRequestPermissionRationale will return true
//show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)
                                || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WAKE_LOCK)) {
                            showDialogOK("Service Permissions are required for this app",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (which) {
                                                case DialogInterface.BUTTON_POSITIVE:
                                                    checkAndRequestPermissions();
                                                    break;
                                                case DialogInterface.BUTTON_NEGATIVE:
// proceed with logic by disabling the related features or quit the app.
                                                    Intent intent = new Intent(Intent.ACTION_MAIN);
                                                    intent.addCategory(Intent.CATEGORY_HOME);
                                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    break;
                                            }
                                        }
                                    });
                        }
//permission is denied (and never ask again is checked)
//shouldShowRequestPermissionRationale will return false
                        else {
// Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG)
// .show();
// //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }

    }

    private void showDialogOK(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }


    //Permission Handling
    private boolean checkAndRequestPermissions() {
        int externalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int externalStoragePermissionREAD = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int phoneStatePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int phoneLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int warLockPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK);
        int bluetoothAdminPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN);
        int bluetoothPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (externalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (externalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (phoneStatePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }


        if (phoneLocationPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (warLockPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WAKE_LOCK);
        }

        if (bluetoothAdminPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.BLUETOOTH_ADMIN);
        }

        if (bluetoothPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.BLUETOOTH);
        }


        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }


//    private void switchToSplash() {
//        databaseOperations.close();
//
//
//        Intent loginActivity = new Intent(LoginActivity.this, MainTakerActivity.class);
//        loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        loginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(loginActivity);
//        circular_p_bar.setVisibility(View.GONE);
//        finish();
//
//    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Logging in. Please wait.");
        progressDialog.show();
    }

    private void dismissProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    private void showLoginMessage() {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(LoginActivity.this, loginMessage, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (databaseOperations != null) {
//            databaseOperations.close();
//        }
    }

}
