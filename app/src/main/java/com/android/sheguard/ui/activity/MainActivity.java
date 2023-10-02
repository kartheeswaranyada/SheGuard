package com.android.sheguard.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.sheguard.R;
import com.android.sheguard.databinding.ActivityMainBinding;
import com.android.sheguard.util.ObservableVariable;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static ObservableVariable<Boolean> shakeDetection = new ObservableVariable<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null || !firebaseAuth.getCurrentUser().isEmailVerified()) {
            startActivity(new Intent(MainActivity.this, OnBoardingActivity.class));
            finishAffinity();
        }
    }
}