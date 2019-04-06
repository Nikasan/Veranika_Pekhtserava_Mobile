package hw3.pageobject.app.entities;


import java.util.Objects;
import java.util.Random;


public class Contact {
    private static Contact contact;

    private String name;
    private String phone;
    private String email;

    private Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    public static Contact getContact() {
        if (Objects.isNull(contact)) {
            contact = new Contact(
                    String.format("Veronika %s", Integer.toString(new Random().nextInt())),
                    "123-123-123",
                    "qwe@mail.com");
        }
        return contact;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
