package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class List {
    ArrayList<Item> items;

    public List() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) throws TooManyItemsException, CreationDateException, FieldIsNotUniqueException {
        if(items.size() < 10) {
            long minutes;

            if(!items.isEmpty()){
                minutes = (items.get(items.size() - 1).getDateCreation()).until( item.getDateCreation().plusMinutes(1), ChronoUnit.MINUTES );}
            else
                minutes = 45;

            if(minutes >= 30) {
                boolean nameExist = items.stream().anyMatch(x -> x.getName().equals(item.getName()));
                if(!nameExist){
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

    public Item getByName(String name) {
        return this.items.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst()
                .orElse(null);
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean isValid(){
        try{
            for(Item item: this.items){
                if(!item.isValid())
                    return false;
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "List{" +
                "items=" + items +
                '}';
    }
}
