package com.cs2415.tempratureconversionapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputTemperature;
    private Spinner conversionSpinner;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.editTextTemperature);
        conversionSpinner = findViewById(R.id.spinnerConversion);
        resultText = findViewById(R.id.textViewResult);

        String[] conversionTypes = {"Celsius to Fahrenheit", "Fahrenheit to Celsius", "Same Unit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, conversionTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        conversionSpinner.setAdapter(adapter);

        conversionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle selection if needed
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void convertTemperature(View view) {
        try {
            double temperature = Double.parseDouble(inputTemperature.getText().toString());
            String conversionType = conversionSpinner.getSelectedItem().toString();

            double result;
            switch (conversionType) {
                case "Celsius to Fahrenheit":
                    result = (temperature * 9 / 5) + 32;
                    break;
                case "Fahrenheit to Celsius":
                    result = (temperature - 32) * 5 / 9;
                    break;
                default:
                    result = temperature;
                    break;
            }

            resultText.setText(String.format("Result: %.2f %s", result, conversionType.charAt(conversionType.length() - 1)));
        } catch (NumberFormatException e) {
            resultText.setText("Invalid input. Please enter a valid temperature.");
        }
    }
}
