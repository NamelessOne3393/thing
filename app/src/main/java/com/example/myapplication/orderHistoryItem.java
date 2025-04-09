package com.example.myapplication;

import static java.lang.Float.parseFloat;
import static java.lang.String.*;

import android.widget.Toast;

public class orderHistoryItem {
    //im gonna have both the full info and the partial info here
    String id;
    String day;
    String buyer;
    String seller;
    String total;
    String items;
    String[] split1;
    String[] temp;
    String[] temp2;

    public orderHistoryItem(String data) {
        this.split1 = data.split(",",6);
        this.items = "";
        this.id = split1[0];
        this.day = split1[1];
        this.buyer = split1[2];
        this.seller = split1[3];
        this.total = split1[4];


        this.temp = split1[5].split("~");
        String lastOne = "";
        for (String s : this.temp) {
            s = s.replace("!", ".");
            temp2 = s.split(":");
            lastOne +=  temp2[0] + "        " + temp2[1] + "    x    " + temp2[2] + "      =  " + format("%.2f", parseFloat(temp2[1]) * parseFloat(temp2[2])) + "\n";

        }
        this.items = lastOne;



    }

    public String getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getSeller() {
        return seller;
    }

    public String getTotal() {
        return total;
    }

    public String getItems() {
        return items;
    }

    public String[] getSplit1() {
        return split1;
    }

    public String[] getTemp() {
        return temp;
    }

    public String[] getTemp2() {
        return temp2;
    }
}
    /*
    order number,
    date,
    buyer,
    seller,
    item:count:price.
    item:count:price.
    item:count:price.
    item:count:price.
    */
