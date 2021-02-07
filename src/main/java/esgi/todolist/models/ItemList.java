package esgi.todolist.models;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ItemList {
    public static int id = 0;

    public String name;
    public String content;
    public LocalDateTime dateCreation;

    public ItemList(String name, String content){
        LocalDateTime ldt = LocalDateTime.now();

        this.name = name;
        this.content = content;
        this.dateCreation = ldt;

        this.id++;
    }

    public ItemList(String name, String content, LocalDateTime ldt){
        this.name = name;
        this.content = content;
        this.dateCreation = ldt;

        this.id++;
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

    public boolean isValid(){
        return StringUtils.isNotBlank(this.name)
                && StringUtils.isNotBlank(this.content)
                && StringUtils.length(this.content) <= 1000
                && this.dateCreation != null;
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
