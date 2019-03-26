package com.snoopgame.application.objectsForJSON;

import com.snoopgame.application.Entities.Phone;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Phones {
    @NonNull
    private Iterable<Phone> androidPhones;
    @NonNull
    private Iterable<Phone> iOSPhones;
    @NonNull
    private Iterable<Phone> amazonPhones;
}

