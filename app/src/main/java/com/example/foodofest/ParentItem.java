package com.example.foodofest;
import java.util.List;
public class ParentItem {
    private String ParentItemTitle;
//a  class  to for defining one item of parent list or  restaurant
    private int img;
    private String parent_address;
    // Constructor of the class
    // to initialize the variables
    public ParentItem(
            String ParentItemTitle,int img,String parent_address)
    {

        this.ParentItemTitle = ParentItemTitle;
        this.img=img;
        this.parent_address=parent_address;

    }

    // Getter and Setter methods
    // for each parameter
    public String getParentItemTitle()
    {
        return ParentItemTitle;
    }

    public void setParentItemTitle(
            String parentItemTitle)
    {
        ParentItemTitle = parentItemTitle;
    }

    public int getimg()
    {

        return img;
    }

    public void setImg(int img)
    {
        img=img;
    }
    public String getParent_address()
    {
        return parent_address;
    }

    public void setParent_address(
            String parent_address)
    {
        parent_address = parent_address;
    }
}
