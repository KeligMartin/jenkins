package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.TooManyItemsException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class List {
    ArrayList<Item> items;

    public List() {
        items = new ArrayList<Item>();
    }

    public void addItem(String name, String content, LocalDateTime dateCreation) throws TooManyItemsException, CreationDateException {
        if(items.size() < 11) {
            long minutes = items.get(items.size() - 1).getDateCreation().until( dateCreation, ChronoUnit.MINUTES );
            System.out.println(minutes);
            if(minutes > 30) {
                Item item = new Item(name, content, dateCreation);
                items.add(item);
            }else{
                throw new CreationDateException();
            }
        }else{
            throw new TooManyItemsException();
        }

    }

}
