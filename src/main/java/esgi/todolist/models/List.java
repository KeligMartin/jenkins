package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class List {
    ArrayList<Item> items;

    public List() {
        items = new ArrayList<Item>();
    }

    public void addItem(String name, String content) throws TooManyItemsException, CreationDateException, FieldIsNotUniqueException {
        if(items.size() < 11) {

            long minutes;

            if(!items.isEmpty())
                minutes = items.get(items.size() - 1).getDateCreation().until( LocalDateTime.now(), ChronoUnit.MINUTES );
            else
                minutes = 45;

            if(minutes > 30) {
                if(!items.contains(name)){
                    Item item = new Item(name, content);
                    items.add(item);
                }else
                    throw new FieldIsNotUniqueException();
            }else
                throw new CreationDateException();
        }else
            throw new TooManyItemsException();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "List{" +
                "items=" + items +
                '}';
    }
}
