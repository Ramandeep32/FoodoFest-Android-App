package com.example.foodofest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class ChildAdapter extends RecyclerView
        .Adapter<ChildAdapter.ChildViewHolder> {

    private static int[] count={0,0,0,0,0,0,0,0,0,0};  //count of item
    private static int[] price={0,0,0,0,0,0,0,0,0,0};//price of item
    private List<ChildItem> ChildItemList;
    public static int[] getCount()
    {
        return count;
    }
    public static int[] getPrice(){return price;}
    public void  setcount(int[] count)
    {
        count=count;
    }

    // Constructor
    ChildAdapter(List<ChildItem> childItemList)  //itemadapter
    {

        this.ChildItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.activity_child_adapter,
                        viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ChildViewHolder childViewHolder,
            int position)

    {     final ChildItem childItem = ChildItemList.get(position);
        int i=childViewHolder.getAbsoluteAdapterPosition();
        final int[] counter = {childItem.getcurrentcounter()};
        count= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        childViewHolder.ChildItemcount.setText(Integer.toString(count[i]));
        childViewHolder.ChildItemcountminus.setOnClickListener(new View.OnClickListener() {   //counter execution
        @Override
        public void onClick(View view) {
            int i=childViewHolder.getAbsoluteAdapterPosition();
            if(count[i]>0)
                count[i]--;
                price[i]=Integer.parseInt(childItem.getprice());
                childItem.setCurrentCount(count[i]);
                childViewHolder.ChildItemcount.setText(Integer.toString(count[i]));


        }
        });
        childViewHolder.ChildItemcountplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=childViewHolder.getAbsoluteAdapterPosition();
                count[i]++;
                price[i]=Integer.parseInt(childItem.getprice());
                childItem.setCurrentCount(count[i]);
                childViewHolder.ChildItemcount.setText(Integer.toString(count[i]));
//                int i=childViewHolder.getAbsoluteAdapterPosition();
//                count[i]=counter[0];

            }
        });
        //printing parametrs
        childViewHolder.ChildItemTitle.setText(childItem.getChildItemTitle());
        childViewHolder.ChildItemdes.setText(childItem.getChildItemdes());
        childViewHolder.ChildItemcount.setText(childItem.getChildItemcount());
        childViewHolder.ChildItemcountminus.setText(childItem.getChildItemcountminus());
        childViewHolder.ChildItemcountplus.setText(childItem.getChildItemcountplus());
        childViewHolder.ChildItemprice.setText(childItem.getChildItemprice());
        childViewHolder.price.setText(childItem.getprice());
        childViewHolder.img.setImageResource(childItem.getimg());
    }

    @Override
    public int getItemCount()
    {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size();
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder
            extends RecyclerView.ViewHolder {

        TextView ChildItemTitle;
        TextView ChildItemdes;
        TextView ChildItemcount;
        TextView ChildItemcountminus;
        TextView ChildItemcountplus;
        TextView ChildItemprice;
        TextView child_name;
        TextView child_address;
        TextView price;

        private final ImageView img;
        ChildViewHolder(View itemView)
        {
            super(itemView);
            ChildItemTitle = itemView.findViewById(R.id.child_item_title);
            ChildItemdes = itemView.findViewById(R.id.child_item_des);
            ChildItemcount = itemView.findViewById(R.id.count_item );
            ChildItemcountminus = itemView.findViewById(R.id.count_minus );
            ChildItemcountplus = itemView.findViewById(R.id.count_plus );
            ChildItemprice = itemView.findViewById(R.id.child_item_price);
            img=itemView.findViewById(R.id.img_child_item);
            child_name=itemView.findViewById(R.id.restaurantname);
            child_address=itemView.findViewById(R.id.restaurantaddress);
            price=itemView.findViewById(R.id.price);

        }
    }
}