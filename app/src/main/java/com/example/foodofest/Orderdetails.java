package com.example.foodofest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Orderdetails extends AppCompatActivity {
//    to  store count and price
    int[] count=ChildAdapter.getCount();
    int[] price=ChildAdapter.getPrice();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int itemvalue=0;
        setContentView(R.layout.activity_orderdetails);
//        calculating total price
        for(int i=0;i<10;i++)
        {
            itemvalue+=count[i]*price[i];
        }
        TextView textView1=(TextView) findViewById(R.id.itemvalue2);
        textView1.setText(Integer.toString(itemvalue));

        double tax=itemvalue*0.05;
        TextView textView2=(TextView) findViewById(R.id.taxcal);
        textView2.setText(Double.toString(tax));
//        adding discount
        int delivery=0;
        if(itemvalue>500)
        {
            delivery=0;
        }
        else
        {
            delivery=40;
        }
        TextView textView3=(TextView) findViewById(R.id.deliverycal);
        textView3.setText(Integer.toString(delivery));

        double discount=0;
        if(itemvalue>=300 && itemvalue<400)
        {
            discount=0.05*itemvalue;
        }
        else if(itemvalue>=400 && itemvalue<500)
        {
            discount=0.07*itemvalue;
        }
        else if(itemvalue>=500)
        {
            discount=0.1*itemvalue;
        }
        TextView textView4=(TextView) findViewById(R.id.discountcal);
        textView4.setText(Double.toString(discount));
        final int[] tip = {0};
        Button btn1,btn2,btn3,btn4;
        btn1=(Button) findViewById(R.id.tip15);
        btn2=(Button)findViewById(R.id.tip20);
        btn3=(Button)findViewById(R.id.tip30);
        btn4=(Button)findViewById(R.id.tip50);
        TextView textView5=findViewById(R.id.tipcal);

        textView5.setVisibility(View.INVISIBLE);
        int finalItemvalue = itemvalue;
        int finalDelivery = delivery;
        double finalDiscount = discount;
//for  tip
        double grandtotal= finalItemvalue +tax+ delivery - discount +tip[0];
        TextView textView6=(TextView) findViewById(R.id.grandtotalcal);
        textView6.setText(Double.toString(grandtotal));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip[0] =15;
                textView5.setText(Integer.toString(tip[0]));
                textView5.setVisibility(View.VISIBLE);
                double grandtotal= finalItemvalue +tax+ finalDelivery - finalDiscount +tip[0];
                TextView textView6=(TextView) findViewById(R.id.grandtotalcal);
                textView6.setText(Double.toString(grandtotal));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip[0]=20;
                textView5.setText(Integer.toString(tip[0]));
                textView5.setVisibility(View.VISIBLE);
                double grandtotal= finalItemvalue +tax+ finalDelivery - finalDiscount +tip[0];
                TextView textView6=(TextView) findViewById(R.id.grandtotalcal);
                textView6.setText(Double.toString(grandtotal));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip[0]=30;
                textView5.setText(Integer.toString(tip[0]));
                textView5.setVisibility(View.VISIBLE);
                double grandtotal= finalItemvalue +tax+ finalDelivery - finalDiscount +tip[0];
                TextView textView6=(TextView) findViewById(R.id.grandtotalcal);
                textView6.setText(Double.toString(grandtotal));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip[0]=50;
                textView5.setText(Integer.toString(tip[0]));
                textView5.setVisibility(View.VISIBLE);
                double grandtotal= finalItemvalue +tax+ finalDelivery - finalDiscount +tip[0];
                TextView textView6=(TextView) findViewById(R.id.grandtotalcal);
                textView6.setText(Double.toString(grandtotal));
            }

        });

    }
}