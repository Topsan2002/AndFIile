package com.example.ex_list_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.opAddOrder){
            Toast.makeText(this,"Order ", Toast.LENGTH_SHORT).show();
            Intent page = new Intent(this, AddOrder.class);
            startActivity(page);
        }else if(item.getItemId() == R.id.opViewOrder){
            Toast.makeText(this,"Order ", Toast.LENGTH_SHORT).show();
            Intent page = new Intent(this, ViewOrder.class);
            startActivity(page);
            Toast.makeText(this,"View ", Toast.LENGTH_SHORT).show();

        }else if(item.getItemId() == R.id.Exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}