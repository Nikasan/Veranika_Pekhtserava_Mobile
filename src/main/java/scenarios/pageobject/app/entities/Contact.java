package scenarios.pageobject.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Random;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private static Contact contact;

    private String name;
    private String phone;
    private String email;

    public static Contact getContact() {
        if (Objects.isNull(contact)) {
            contact = new Contact(
                    String.format("Veronika%s", Integer.toString(new Random().nextInt())),
                    "123-123-123",
                    "qwe@mail.com");
        }
        return contact;
    }
}
