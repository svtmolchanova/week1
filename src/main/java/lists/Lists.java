package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lists {

    private static final int LIST_1_SIZE = 5;
    private static final int LIST_2_SIZE = 7;

    public void getLists() {

        ArrayList arrayList1 = new ArrayList();

        for (int i = 0; i < LIST_1_SIZE; i++) {
            arrayList1.add((int)(Math.random()*10));
        }

        System.out.println(arrayList1);
        Collections.sort(arrayList1);
        System.out.println(arrayList1);

        ArrayList arrayList2 = new ArrayList();

        for (int i = 0; i < LIST_2_SIZE; i++) {
            arrayList2.add((int)(Math.random()*10));
        }

        System.out.println(arrayList2);
        Collections.sort(arrayList2);
        System.out.println(arrayList2);

        ArrayList arrayList1new = new ArrayList(LIST_1_SIZE + LIST_2_SIZE);
        arrayList1new.addAll(arrayList1);
        arrayList1new.addAll(arrayList2);

        System.out.println(arrayList1new);
        Collections.sort(arrayList1new);
        arrayList1 = arrayList1new;
        System.out.println(arrayList1);

    }
}
