package com.snoopgame.application.objectsForJSON;

import com.snoopgame.application.Entities.Phone;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phones {
    private Iterable<Phone> androidPhones;
    private Iterable<Phone> iosPhones;
    private Iterable<Phone> amazonPhones;
}

