package com.snoopgame.application.objectsForJSON;


import com.snoopgame.application.Entities.Order;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Iterable<Order> androidOrders;
    private Iterable<Order> iosOrders;
    private Iterable<Order> amazonOrders;
}
