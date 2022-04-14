package com.example.foodofest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import android.view.View.OnClickListener;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Itemlist extends AppCompatActivity {
    int stuff;
    String stuff2;
    String stuff3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);
        //creation of child recyclerview
        RecyclerView
                ChildRecyclerViewItem
                = findViewById(
                R.id.child_recyclerview);

        // Initialise the Linear layout manager
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(Itemlist.this);
        //importing important parameters from different activity
        Bundle bundle = getIntent().getBundleExtra("bundle");
        stuff = bundle.getInt("stuff");
        stuff2=bundle.getString("stuff2");
        stuff3=bundle.getString("stuff3");
        TextView textView1,textView2;
        textView1=(TextView) findViewById(R.id.restaurantname);
        textView2=(TextView) findViewById(R.id.restaurantaddress);
        textView1.setText(stuff2);
        textView2.setText(stuff3);
        int image=bundle.getInt("stuff4");
        ImageView imageView=(ImageView) findViewById(R.id.restaurantimageinlist);
        imageView.setImageResource(image);
//        assigning different childitem list to different restaurant based on odd even position of restaurant in restaurant  list
        if(stuff%2==0)
        {
            ChildAdapter childItemAdapter = new ChildAdapter(ChildItemList1());
            ChildRecyclerViewItem.setAdapter(childItemAdapter);
            ChildRecyclerViewItem
                    .setAdapter(childItemAdapter);
            ChildRecyclerViewItem
                    .setLayoutManager(layoutManager);
        }
        else
        {
            ChildAdapter childItemAdapter = new ChildAdapter(ChildItemList2());
            ChildRecyclerViewItem.setAdapter(childItemAdapter);
            ChildRecyclerViewItem
                    .setAdapter(childItemAdapter);
            ChildRecyclerViewItem
                    .setLayoutManager(layoutManager);
        }
        int [] count=ChildAdapter.getCount();


        btn=(Button) findViewById(R.id.buttonToproceed);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Itemlist.this,Orderdetails.class);
                startActivity(i);
            }
        });


    }
//    creating different child list
    private List<ChildItem> ChildItemList1()
    {
        List<ChildItem> ChildItemList1 = new ArrayList<>();

        ChildItemList1.add(new ChildItem("Pancake",R.drawable.img_5,"0","-","+","1 pc","Price: ₹","125"));
        ChildItemList1.add(new ChildItem("Masala Dosa",R.drawable.img_8,"0","-","+","1 pc","Price: ₹","80"));
        ChildItemList1.add(new ChildItem("Doughnuts",R.drawable.img_9,"0","-","+","1 pc","Price: ₹","35"));
        ChildItemList1.add(new ChildItem("Burger",R.drawable.img_11,"0","-","+","1 pc","Price: ₹","75"));

        return ChildItemList1;

    }
    private List<ChildItem> ChildItemList2()
    {
        List<ChildItem> ChildItemList2 = new ArrayList<>();

        ChildItemList2.add(new ChildItem("Pancake",R.drawable.img_5,"0","-","+","1 pc","Price: ₹","125"));
        ChildItemList2.add(new ChildItem("Masala Dosa",R.drawable.img_8,"0","-","+","1 pc","Price: ₹","80"));
        ChildItemList2.add(new ChildItem("Doughnuts",R.drawable.img_9,"0","-","+","1 pc","Price: ₹","35"));
        ChildItemList2.add(new ChildItem("Burger",R.drawable.img_5,"0","-","+","1 pc","Price: ₹","75"));
        ChildItemList2.add(new ChildItem("Thali",R.drawable.img_10,"0","-","+","1 pc","Price: ₹","150"));
        ChildItemList2.add(new ChildItem("Samosa",R.drawable.img_12,"0","-","+","1 pc","Price: ₹","15"));
        ChildItemList2.add(new ChildItem("Fried Chicken",R.drawable.img_13,"0","-","+","1 pc","Price: ₹","200"));
        ChildItemList2.add(new ChildItem("Pizza",R.drawable.img_5,"0","-","+","1 pc","Price: ₹","375"));
        return ChildItemList2;
    }
}