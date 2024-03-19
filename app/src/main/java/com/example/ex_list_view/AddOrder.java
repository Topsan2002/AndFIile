package com.example.ex_list_view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class AddOrder extends AppCompatActivity {

        AutoCompleteTextView user, product;
        EditText amount, price;

        String usersData[] = {"User1","User2","User3"};
        String prodcutData[] = {"Pro1","Pro2","Pro3"};

        FileMange fileMange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        user = (AutoCompleteTextView) findViewById(R.id.User);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersData);
        user.setAdapter(adapter);
        ArrayAdapter<String> prodata = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prodcutData);
        product = (AutoCompleteTextView) findViewById(R.id.product);
        product.setAdapter(prodata);

        amount = (EditText) findViewById(R.id.amount);
        price = (EditText) findViewById(R.id.price);

        fileMange = new FileMange("data/data/"+getPackageName()+"/order.txt");

    }

    public  void addProduct(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Comfitm");
        builder.setMessage("Are You sure Add Product ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fileMange.addData(dataNow());
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    private String dataNow(){
        int id =  fileMange.getId();
        String data = "";
        data += id + ",";
        data += user.getText().toString()+","+product.getText().toString()+",";
        data += amount.getText().toString()+","+price.getText().toString()+"\n";
        return data;
    }

}