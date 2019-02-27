package com.snoopgame.application.objectsForJSON;


import com.snoopgame.application.Entities.Order;

public class Orders {
    private Iterable<Order> androidOrders;
    private Iterable<Order> iOSOrders;
    private Iterable<Order> amazonOrders;

    public Orders(Iterable<Order> androidOrders, Iterable<Order> iOSOrders, Iterable<Order> amazonOrders) {
        this.androidOrders = androidOrders;
        this.iOSOrders = iOSOrders;
        this.amazonOrders = amazonOrders;
    }

    public Iterable<Order> getAndroidOrders() {
        return androidOrders;
    }

    public void setAndroidOrders(Iterable<Order> androidOrders) {
        this.androidOrders = androidOrders;
    }

    public Iterable<Order> getiOSOrders() {
        return iOSOrders;
    }

    public void setiOSOrders(Iterable<Order> iOSOrders) {
        this.iOSOrders = iOSOrders;
    }

    public Iterable<Order> getAmazonOrders() {
        return amazonOrders;
    }

    public void setAmazonOrders(Iterable<Order> amazonOrders) {
        this.amazonOrders = amazonOrders;
    }

}
