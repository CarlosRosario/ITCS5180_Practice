package com.example.group26.inclass11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

public class ExpensesListActivity extends AppCompatActivity {

    List<Expense> expenseList = new ArrayList<Expense>();
    ListView listView;

    Firebase ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://luminous-torch-5331.firebaseio.com/");

        //ArrayAdapter<Expense> expenseAdapter = new ArrayAdapter<Expense>(ExpensesListActivity.this, android.R.layout.simple_list_item_1, expenseList);
        //listView = (ListView)findViewById(R.id.expenseListView);
        //listView.setAdapter(expenseAdapter);
        //expenseAdapter.setNotifyOnChange(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.expenselist_custom_actionbar, menu);
        return true;
    }


    public void addExpense(MenuItem item){
        Intent addExpenseActivity = new Intent(ExpensesListActivity.this, AddExpenseActivity.class);
        startActivityForResult(addExpenseActivity, 100);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Expense expense = (Expense)data.getSerializableExtra("EXPENSE");
            expenseList.add(expense);
        }
    }

    public void logout(MenuItem item){

        ref.unauth();
        finish();

    }
}

