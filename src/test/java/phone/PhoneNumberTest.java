package phone;

import org.junit.Test;

public class PhoneNumberTest {

    @Test
    public void getPhoneNumberReg() {

        PhoneNumber phoneNumber = new PhoneNumber();

        String str = phoneNumber.getPhoneNumberReg();

        System.out.println(str);

    }

    @Test
    public void getPhoneNumberStr() {

        PhoneNumber phoneNumber = new PhoneNumber();

        String str = phoneNumber.getPhoneNumberStr();

        System.out.println(str);
    }

}
