package com.snoopgame.application.objectsForJSON;



import com.snoopgame.application.Entities.Order;

import java.util.ArrayList;

public class Orders {
    private Iterable<Order>orders;

    public Iterable<Order> getOrders() {
        return orders;
    }

    public void setOrders(Iterable<Order> orders) {
        this.orders = orders;
    }


    public Orders(Iterable<Order> orders) {

        this.orders = orders;
    }

}
