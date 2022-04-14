package com.example.foodofest;

public class ChildItem {

        // Declaration of the variable
        private String ChildItemTitle;
        private String ChildItemcountminus;
        private String ChildItemcount;
        private String ChildItemcountplus;
        private String ChildItemdes;
        private String ChildItemprice;
        private String price;
        private int img;
        int currentCount = 0;
        // Constructor of the class
        // to initialize the variable*
        public ChildItem(String childItemTitle,int img,String childItemcount,String childItemcountminus,String childItemcountplus,String childItemdes,String childItemprice,String price)
        {

                this.ChildItemTitle = childItemTitle;
                this.ChildItemcount = childItemcount;
                this.ChildItemcountminus = childItemcountminus;
                this.ChildItemcountplus = childItemcountplus;
                this.ChildItemdes = childItemdes;
                this.ChildItemprice = childItemprice;
                this.img=img;
                this.price=price;
        }

        // Getter and Setter method
        // for the parameter
        public String getChildItemTitle()
        {
            return ChildItemTitle;
        }
        public void setChildItemTitle(String childItemTitle) { ChildItemTitle = childItemTitle; }

        public String getprice() { return price; }
        public void setPrice(String price) { price = price; }

        public String getChildItemdes()
        {
                return ChildItemdes;
        }
        public void setChildItemdes(String childItemdes) { ChildItemdes = childItemdes; }

        public String getChildItemcount()
        {
                return ChildItemcount;
        }
        public void setChildItemcount(String childItemcount) { ChildItemcount = childItemcount; }

        public String getChildItemcountminus()
        {
                return ChildItemcountminus;
        }
        public void setChildItemcountminus(String childItemcountminus) { ChildItemcountminus = childItemcountminus; }

        public String getChildItemcountplus()
        {
                return ChildItemcountplus;
        }
        public void setChildItemcountplus(String childItemcountplus) { ChildItemcountplus = childItemcountplus; }

        public String getChildItemprice()
        {
                return ChildItemprice;
        }
        public void setChildItemprice(String childItemprice) { ChildItemprice = childItemprice; }

        public int getimg() { return img; }
        public void setImg(int img)
        {
                img=img;
        }
        public int getcurrentcounter()
        {
                return currentCount;
        }
        public void setCurrentCount(int currentCount) { ChildItemcount = Integer.toString(currentCount); }
}
