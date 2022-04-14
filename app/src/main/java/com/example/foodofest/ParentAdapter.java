package com.example.foodofest;

import static android.os.Build.VERSION_CODES.P;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
//creation of  Restaurant list using parent adapter
public class ParentAdapter extends RecyclerView
        .Adapter<ParentAdapter.ParentViewHolder> {

    private RecyclerView.RecycledViewPool
            viewPool
            = new RecyclerView
            .RecycledViewPool();
    private List<ParentItem> itemList;

    ParentAdapter(List<ParentItem> itemList)
    {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the parent item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(
                        R.layout.activity_parent_adapter,
                        viewGroup, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ParentViewHolder parentViewHolder,
            int position)
    {
        ParentItem parentItem
                = itemList.get(position);
        parentViewHolder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Itemlist.class);
                int i=parentViewHolder.getAbsoluteAdapterPosition();
                String j=parentViewHolder.ParentItemTitle.getText().toString();
                String k=parentViewHolder.parent_address.getText().toString();
                int l=parentItem.getimg();
//                creation bundle to pass ata fromone activity twoanother usin intent
                Bundle bundle =new Bundle();
                bundle.putInt("stuff", i);
                bundle.putString("stuff2",j);
                bundle.putString("stuff3",k);
                bundle.putInt("stuff4",l);
                intent.putExtra("bundle",bundle);

                view.getContext().startActivity(intent);
            }
        });

        // Create an instance of the ParentItem
        // class for the given position


        // For the created instance,
        // get the title and set it
        // as the text for the TextView
        parentViewHolder
                .ParentItemTitle
                .setText(parentItem.getParentItemTitle());
        parentViewHolder.parent_address.setText(parentItem.getParent_address());

        parentViewHolder.img.setImageResource(parentItem.getimg());
        // Create a layout manager
        // to assign a layout
        // to the RecyclerView.

        // Here we have assigned the layout
        // as LinearLayout with vertical orientation


        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method


        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool

    }

    // This method returns the number
    // of items we have added in the
    // ParentItemList i.e. the number
    // of instances we have created
    // of the ParentItemList
    @Override
    public int getItemCount()
    {

        return itemList.size();
    }

    // This class is to initialize
    // the Views present in
    // the parent RecyclerView
    class ParentViewHolder
            extends RecyclerView.ViewHolder {

        private final TextView ParentItemTitle;
        private final ImageView img;
        private final TextView parent_address;

        ParentViewHolder(final View itemView)
        {
            super(itemView);

            ParentItemTitle
                    = itemView
                    .findViewById(
                            R.id.parent_item_title);

            img=itemView.findViewById(R.id.restaurantimage);
            parent_address=itemView.findViewById(R.id.parent_address);
        }
    }


}