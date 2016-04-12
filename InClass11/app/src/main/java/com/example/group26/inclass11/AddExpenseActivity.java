package com.example.group26.inclass11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class AddExpenseActivity extends AppCompatActivity {

    Spinner spinner;
    String selectedCategory;
    EditText amountEditText;
    EditText expenseNameEditText;
    EditText dateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        spinner = (Spinner)findViewById(R.id.categorySpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = (String)spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        amountEditText = (EditText)findViewById(R.id.amountEditText);
        dateEditText = (EditText)findViewById(R.id.dateEditText);
        expenseNameEditText = (EditText)findViewById(R.id.phoneBillEditText);

        findViewById(R.id.addExpenseButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense = new Expense();
                expense.setAmount(amountEditText.getText().toString());
                expense.setCategory(selectedCategory);
                expense.setDate(dateEditText.getText().toString());
                expense.setExpenseName(expenseNameEditText.getText().toString());


            }
        });
    }


}
