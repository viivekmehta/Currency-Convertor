package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void convert(View view) {
        BigDecimal multiplyBy;
        BigDecimal toValue;
        BigDecimal fromValue = null;
        EditText fromEditText = (EditText) findViewById(R.id.fromEditText);
        if(!((fromEditText.getText().toString()).equalsIgnoreCase("")) && !((fromEditText.getText().toString()).equalsIgnoreCase("Enter the amount to convert"))) {
            fromValue = new BigDecimal(fromEditText.getText().toString());
            Spinner fromCurrency = (Spinner) findViewById(R.id.spinnerFrom);
            Spinner toCurrency = (Spinner) findViewById(R.id.spinnerTo);
            TextView result = (TextView) findViewById(R.id.result);
            if ((fromCurrency.getSelectedItem().toString()).equalsIgnoreCase(toCurrency.getSelectedItem().toString())) {
                Toast.makeText(getBaseContext(), "\"From\" and \"To\" values cannot be same !!", Toast.LENGTH_SHORT).show();
            } else if ((fromCurrency.getSelectedItem().toString()).equalsIgnoreCase("Dollars")) {
                multiplyBy = new BigDecimal("71.43");
                result.setText("Rs. " + (fromValue.multiply(multiplyBy)).toString());
            } else {
                multiplyBy = new BigDecimal("0.01399");
                result.setText("$ " + (fromValue.multiply(multiplyBy)).toString());
            }
        } else {
            Toast.makeText(getBaseContext(),"Please enter the amount to convert !!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner fromCurrency =  (Spinner) findViewById(R.id.spinnerFrom);
        Spinner toCurrency = (Spinner) findViewById(R.id.spinnerTo);
        ArrayList<String> currenciesTo = new ArrayList<>();
        currenciesTo.add("Rupees");
        currenciesTo.add("Dollars");
        ArrayList<String> currenciesFrom = new ArrayList<>();
        currenciesFrom.add("Dollars");
        currenciesFrom.add("Rupees");
        ArrayAdapter<String> arrayAdapterTo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,currenciesTo);
        ArrayAdapter<String> arrayAdapterFrom = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,currenciesFrom);
        arrayAdapterTo.setDropDownViewResource(android.R.layout.simple_spinner_item);
        arrayAdapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_item);
        fromCurrency.setAdapter(arrayAdapterFrom);
        toCurrency.setAdapter(arrayAdapterTo);
        fromCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
