package com.example.foodofest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//this activity  is for creation of restaurant list by adding value  to  it
public class Restaurant extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        RecyclerView
                ParentRecyclerViewItem
                = findViewById(
                R.id.parent_recyclerview);

        // Initialise the Linear layout manager
        LinearLayoutManager
                layoutManager
                = new LinearLayoutManager(
                Restaurant.this);
        ParentAdapter parentItemAdapter = new ParentAdapter(ParentItemList());
        ParentRecyclerViewItem.setAdapter(parentItemAdapter);
        ParentRecyclerViewItem
                .setAdapter(parentItemAdapter);
        ParentRecyclerViewItem
                .setLayoutManager(layoutManager);

    }
    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList
                = new ArrayList<>();

        ParentItem item
                = new ParentItem(
                "Sharma Bhojnalaya",R.drawable.img_1,"Shop1,Near Jawahar Chow Bus Stand,New Market,TT Nagar,Bhopal.");
        itemList.add(item);
        ParentItem item1
                = new ParentItem(
                "Briyani Baba",R.drawable.img_2,"Stall 2,Food court, third floor, DB Mall, Arera hills,Mahrana pratap nagar, Bhopal");
        itemList.add(item1);
        ParentItem item2
                = new ParentItem(
                "Garlic Bread",R.drawable.img_3,"Shop 1, Indira Market, Opposite Bittan ground, Arera colony, Bhopal");
        itemList.add(item2);
        ParentItem item3
                = new ParentItem(
                "Sagar Gaire Fast Food Nehru Nagar",R.drawable.img_4,"Shop 3, Gomati colony, Main road, Nehru nagar, TT nagar, Bhopal");
        itemList.add(item3);

        ParentItem item4
                = new ParentItem(
                "Sharma Bhojnalaya",R.drawable.img_1,"Shop1,Near Jawahar Chow Bus Stand,New Market,TT Nagar,Bhopal.");
        itemList.add(item4);
        ParentItem item5
                = new ParentItem(
                "Briyani Baba",R.drawable.img_2,"Stall 2,Food court, third floor, DB Mall, Arera hills,Mahrana pratap nagar, Bhopal");

        itemList.add(item5);
        ParentItem item6
                = new ParentItem(
                "Garlic Bread",R.drawable.img_3,"Shop 1, Indira Market, Opposite Bittan ground, Arera colony, Bhopal");
        itemList.add(item6);
        ParentItem item7
                = new ParentItem(
                "Sagar Gaire Fast Food Nehru Nagar",R.drawable.img_4,"Shop 3, Gomati colony, Main road, Nehru nagar, TT nagar, Bhopal");
        itemList.add(item7);
        ParentItem item8
                = new ParentItem(
                "Sharma Bhojnalaya",R.drawable.img_1,"Shop1,Near Jawahar Chow Bus Stand,New Market,TT Nagar,Bhopal.");
        itemList.add(item8);
        ParentItem item9
                = new ParentItem(
                "Briyani Baba",R.drawable.img_2,"Stall 2,Food court, third floor, DB Mall, Arera hills,Mahrana pratap nagar, Bhopal");
        itemList.add(item9);
        ParentItem item10
                = new ParentItem(
                "Garlic Bread",R.drawable.img_3,"Shop 1, Indira Market, Opposite Bittan ground, Arera colony, Bhopal");
        itemList.add(item10);
        ParentItem item11
                = new ParentItem(
                "Sagar Gaire Fast Food Nehru Nagar",R.drawable.img_4,"Shop 3, Gomati colony, Main road, Nehru nagar, TT nagar, Bhopal");
        itemList.add(item11);
        return itemList;
    }

}