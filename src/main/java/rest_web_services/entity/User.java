package rest_web_services.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private int id;
    @Size(min = 2, message = "Name should have atleast 2 char characters")
    private String name;
    @Past(message = "Date should be in the past")
    private LocalDate date;

    public User(int id, String name, LocalDate date){
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
