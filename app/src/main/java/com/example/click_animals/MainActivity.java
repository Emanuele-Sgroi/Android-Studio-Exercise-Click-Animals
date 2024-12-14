package com.example.click_animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView textInfo;
    private Button buttonClear;
    private ImageView imageShiba, imageCapybara, imageCats;

    // Tracking of original states
    private String initialText = "Please Touch on one of the animal icons";
    // Initial text color and button background color
    private int initialColor;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        textInfo = findViewById(R.id.text_info);
        buttonClear = findViewById(R.id.button_clear);
        imageShiba = findViewById(R.id.image_dog);
        imageCapybara = findViewById(R.id.image_capybara);
        imageCats = findViewById(R.id.image_cats);

        // Set initial text and color
        textInfo.setText(initialText);
        initialColor = ContextCompat.getColor(this, R.color.black);;
        currentColor = initialColor;
        buttonClear.setBackground(getMainButton(initialColor));

        // Set OnClickListeners for images and call onAnimalClicked() method
        imageShiba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnimalClicked("cute dog!");
            }
        });

        imageCapybara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnimalClicked("capybara with a bird on it!");
            }
        });

        imageCats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnimalClicked("group of cute cats!");
            }
        });

        // Clear button resets everything to original state
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetApp();
            }
        });
    }

    // This method is called when an animal is clicked
    private void onAnimalClicked(String clickedOn) {
        // Change text
        textInfo.setText("You clicked on the " + clickedOn);
        // Change color
        int newColor;
        switch (clickedOn) {
            case "cute dog!":
                newColor = ContextCompat.getColor(this, R.color.fuchsia);
                break;
            case "capybara with a bird on it!":
                newColor = ContextCompat.getColor(this, R.color.orange);
                break;
            case "group of cute cats!":
                newColor = ContextCompat.getColor(this, R.color.blue);
                break;
            default:
                newColor = initialColor;
        }

        currentColor = newColor;
        textInfo.setTextColor(currentColor);
        buttonClear.setBackground(getMainButton(currentColor));
    }

    // Reset the app to initial state
    private void resetApp() {
        textInfo.setText(initialText);
        textInfo.setTextColor(initialColor);
        currentColor = initialColor;
        buttonClear.setBackground(getMainButton(initialColor));
    }

    // Helper to create a button with a given color
    private GradientDrawable getMainButton(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(50f);
        drawable.setColor(color);
        return drawable;
    }
}