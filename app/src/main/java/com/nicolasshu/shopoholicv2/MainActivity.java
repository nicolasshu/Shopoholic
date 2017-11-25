package com.nicolasshu.shopoholicv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static ItemNum_class itemNum_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemNum_msg = new ItemNum_class();
        setContentView(R.layout.activity_main);
    }
    public void fn_item1(View v){
        int num = 1;
        EditText searchQueryET = (EditText) findViewById(R.id.item1);
        String searchQuery_str = searchQueryET.getText().toString();

        itemNum_msg.setNum(num);
        itemNum_msg.setSearchQuery(searchQuery_str);

        Intent myIntent = new Intent(this,SearchResultsActivity.class);
        this.startActivity(myIntent);
    }
}
