package esgi.todolist.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Item {
    public static int id = 0;

    public String name;
    public String content;
    public LocalDateTime dateCreation;

    public Item(String name, String content, LocalDateTime dateCreation){
        this.name = name;
        this.content = content;
        this.dateCreation = dateCreation;

        this.id++;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
