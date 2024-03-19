
package com.example.ex_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class ViewOrder extends AppCompatActivity  implements SearchView.OnQueryTextListener{
    SearchView searchView;
    ListView listView;
    FileMange fileMange;
    String orderDatas[];

    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        fileMange = new FileMange("data/data/"+getPackageName()+"/order.txt");
        searchView = (SearchView) findViewById(R.id.searView);
        listView = (ListView) findViewById(R.id.listView);
        orderDatas = fileMange.getData().split("\n");
        for (int i = 0; i < orderDatas.length; i++) {
            orderDatas[i] =  orderDatas[i].replace(","," ");
        }

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, orderDatas);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(this);
     }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        arrayAdapter.getFilter().filter(newText);
        return false;
    }
}