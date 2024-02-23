package com.example.swiftandroidexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    // Declare a native method in Java, with the implementation in Swift
    private native String swiftHelloWorld();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Swift runtime and Swift Foundation library
        try {
            org.swift.swiftfoundation.SwiftFoundation.Initialize(this, false);
        } catch (Exception err) {
            android.util.Log.e("Swift", "Can't initialize Swift Foundation: " + err.toString());
        }

        // Load JNI library containing Swift code
        System.loadLibrary("SwiftAndroidExample");

        // Call the swiftHelloWorld method implemented in Swift
        String msg = swiftHelloWorld();

        // Display the value returned from swift in the text view
        android.widget.TextView text = new android.widget.TextView(this);
        text.setText(msg);
        text.setGravity(android.view.Gravity.CENTER_VERTICAL |
                        android.view.Gravity.CENTER_HORIZONTAL);
        text.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(
                android.widget.RelativeLayout.LayoutParams.MATCH_PARENT,
                android.widget.RelativeLayout.LayoutParams.MATCH_PARENT));
        setContentView(text);
    }
}