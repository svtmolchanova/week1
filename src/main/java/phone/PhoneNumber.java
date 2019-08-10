package phone;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneNumber {

    private static final String REGEX = ", ";

    public String getPhoneNumberReg() {

        ArrayList list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        list.add(0);

        String str = list.toString().replaceAll("\\[|\\]|,\\s", "");

        String s = "(" + str.substring(0, 3) + ")"  + str.substring(3, 6) + "-" + str.substring(6);

        return s;

    }

    public String getPhoneNumberStr() {

        ArrayList list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        list.add(0);

        String str = (String) list.stream().map(Object::toString).collect(Collectors.joining(""));

        String s = new StringBuilder().append("(").append(str, 0, 3).append(")").append(str, 3, 6).append("-").append(str, 6, str.length()).toString();

        return s;

    }
}
