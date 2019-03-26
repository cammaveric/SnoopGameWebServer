package com.snoopgame.application.objectsForJSON;


import com.snoopgame.application.Entities.Order;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Orders {
    @NonNull
    private Iterable<Order> androidOrders;
    @NonNull
    private Iterable<Order> iOSOrders;
    @NonNull
    private Iterable<Order> amazonOrders;
}
