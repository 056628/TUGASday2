package com.example.tugas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextQuantity;
    RadioButton radioButtonPulsa, radioButtonToken, radioButtonEmoney;
    RadioGroup radioGroupItems, radioGroupMembership;
    Button buttonProcess;
    TextView textViewReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextQuantity = findViewById(R.id.editTextQuantity);
        radioButtonPulsa = findViewById(R.id.radioButtonPulsa);
        radioButtonToken = findViewById(R.id.radioButtonToken);
        radioButtonEmoney = findViewById(R.id.radioButtonEmoney);
        radioGroupItems = findViewById(R.id.radioGroupItems);
        radioGroupMembership = findViewById(R.id.radioGroupMembership);
        buttonProcess = findViewById(R.id.buttonProcess);
        textViewReceipt = findViewById(R.id.textViewReceipt);


        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processTransaction();
            }
        });
    }

    private void processTransaction() {
        String NamaBarang = "";
        double itemPrice = 0;
        double adminFee = 0;
        double totalPrice = 0;
        int quantity = Integer.parseInt(editTextQuantity.getText().toString());


        if (radioButtonPulsa.isChecked()) {
            NamaBarang = "Pulsa";
            itemPrice = 10000;
            adminFee = 2000;
        } else if (radioButtonToken.isChecked()) {
            NamaBarang = "Token";
            itemPrice = 15000;
            adminFee = 2500;
        } else if (radioButtonEmoney.isChecked()) {
            NamaBarang = "E-Money";
            itemPrice = 20000;
            adminFee = 3000;
        }


        totalPrice = (itemPrice * quantity) + adminFee;


        double discount = 0;
        if (radioGroupMembership.getCheckedRadioButtonId() == R.id.radioButtonMembership) {
            discount = 0.05;
        }

        totalPrice -= totalPrice * discount;


        String receipt = "Nama Barang: " + NamaBarang + "\n" +
                "Banyak Barang: " + quantity + "\n" +
                "Harga per Barang: " + itemPrice + "\n" +
                "Biaya Admin: " + adminFee + "\n" +
                "Total Harga: " + (itemPrice * quantity) + "\n" +
                "Diskon: " + (discount * 100) + "%" + "\n" +
                "Total Bayar: " + totalPrice;
        textViewReceipt.setText(receipt);
    }
}
