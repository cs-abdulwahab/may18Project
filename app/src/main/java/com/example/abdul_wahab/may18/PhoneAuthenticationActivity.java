package com.example.abdul_wahab.may18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;


import java.util.Arrays;

public class PhoneAuthenticationActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_authentication);
/*


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {

            if (!firebaseAuth.getCurrentUser().getPhoneNumber().isEmpty()) {

                Log.d(TAG, "onCreate: authenticated user");

            } else {
                Log.d(TAG, "onCreate: else case");
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(Arrays.asList(
                                        new AuthUI.IdpConfig.PhoneBuilder().build()
                                ))
                                .setIsSmartLockEnabled(false,true)
                                .build(),
                        RC_SIGN_IN);
            }

        }
        else{

            Log.d(TAG, "onCreate: current user is null");
        }
*/

    }
}
