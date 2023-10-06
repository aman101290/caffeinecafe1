package com.example.appclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MenuPage extends AppCompatActivity {
    /**
     * This app displays an order form to order coffee.
     */
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        getSupportActionBar().setTitle("Menu");
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String value = nameField.getText().toString();
        //Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        //Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        //Figure out if the user wants chicken wrap
        CheckBox chickenwrap = (CheckBox) findViewById(R.id.chicken_wrap);
        boolean hasChickenWrap = chickenwrap.isChecked();
        //Figure out if the user wants veggie wrap
        CheckBox veggiewrap = (CheckBox) findViewById(R.id.veggie_wrap);
        boolean hasVeggieWrap = veggiewrap.isChecked();
        //Figure out if the user wants muffin
        CheckBox muffin = (CheckBox) findViewById(R.id.muffin);
        boolean hasMuffin = muffin.isChecked();
        //Figure out if the user wants bagel
        CheckBox bagel = (CheckBox) findViewById(R.id.bagel);
        boolean hasBagel = bagel.isChecked();
        //Figure out if the user wants fries
        CheckBox fries = (CheckBox) findViewById(R.id.fries);
        boolean hasFries = fries.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate, hasChickenWrap, hasVeggieWrap, hasMuffin, hasBagel, hasFries);
        String priceMessage = createOrderSummary(value, price, hasWhippedCream, hasChocolate,
                hasChickenWrap, hasVeggieWrap, hasMuffin, hasBagel, hasFries);
        displayMessage(priceMessage);
    }

    /**
     * This method calculates the total price.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addchickenwrap,
                               boolean addveggiewrap, boolean addMuffin, boolean addBagel, boolean addFries) {
        //Price of 1 cup of coffee
        int basePrice = 5;
        //Add $1 if the user wants whipped cream
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        //Add $2 if the user wants chocolate
        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        if (addchickenwrap) {
            basePrice = basePrice + 7;
        }

        if (addveggiewrap) {
            basePrice = basePrice + 6;
        }

        if (addMuffin) {
            basePrice = basePrice + 3;
        }

        if (addBagel) {
            basePrice = basePrice + 2;
        }

        if (addFries) {
            basePrice = basePrice + 4;
        }
        //Calculate the total order price
        return quantity * basePrice;
    }

    /**
     * This method creates a summary of order.
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate,
                                      boolean addchickenwrap, boolean addveggiewrap, boolean addMuffin,
                                      boolean addBagel, boolean addFries) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Whipped Cream = " + addWhippedCream;
        priceMessage += "\nAdd Chocolate = " + addChocolate;
        priceMessage += "\nAdd Chicken Wrap = " + addchickenwrap;
        priceMessage += "\nAdd Veggie Wrap = " + addveggiewrap;
        priceMessage += "\nAdd Muffin = " + addMuffin;
        priceMessage += "\nAdd Bagel = " + addBagel;
        priceMessage += "\nAdd Fries= " + addFries;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nYour Order's Total: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);

    }

}