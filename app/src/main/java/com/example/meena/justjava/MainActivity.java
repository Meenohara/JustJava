package com.example.meena.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.meena.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "troubleshooting";
    int quantity=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(2);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox mTopping = (CheckBox)findViewById(R.id.topping_cream);
        boolean hasTopping = false;
        hasTopping = mTopping.isChecked();

        CheckBox mChoc = (CheckBox)findViewById(R.id.topping_choc);
        boolean hasChoc = false;
        //hasChoc = mChoc.isChecked();

        EditText text = (EditText)findViewById(R.id.name_field);
        String ca_name = text.getText().toString();

        int price = calculatePrice();

        displayMessage(createOrderSummary(ca_name, price, hasTopping, hasChoc));
    }



    private String createOrderSummary(String caname, int number, boolean cream, boolean choco){
        String summary = "Name: " + caname;
        summary +=        "\nAdd Whippeed Cream?" + cream;
        summary +=        "\nAdd chocolate?" + choco;
        summary +=        "\nQuantity:" + quantity;
        summary +=       "\nTotal: $" + number + "\nThank you!";
        return summary;
    }

    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

    private void displayMessage(String message) {
        TextView order_summaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        order_summaryTextView.setText(message);
    }

    public void increment(View view){
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity--;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);


    }
}