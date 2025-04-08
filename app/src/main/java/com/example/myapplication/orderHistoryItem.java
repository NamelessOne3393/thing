package com.example.myapplication;

public class orderHistoryItem {
    //im gonna have both the full info and the partial info here
    String id;
    String day;
    String buyer;
    String seller;
    String total;
    String[] split1;


    public orderHistoryItem(String data) {
        this.split1 = data.split(",");

        this.id = split1[0];
        this.day = split1[1];
        this.buyer = split1[2];
        this.seller = split1[3];



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
