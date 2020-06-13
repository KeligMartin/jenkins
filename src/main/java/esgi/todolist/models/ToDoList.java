package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ToDoList {
    ArrayList<ItemList> itemLists;

    public ToDoList() {
        itemLists = new ArrayList<ItemList>();
    }

    public void addItem(ItemList itemList) throws TooManyItemsException, CreationDateException, FieldIsNotUniqueException {
        if(itemLists.size() < 10) {
            long minutes;

            if(!itemLists.isEmpty()){
                minutes = (itemLists.get(itemLists.size() - 1).getDateCreation()).until( itemList.getDateCreation().plusMinutes(1), ChronoUnit.MINUTES );}
            else
                minutes = 45;

            if(minutes >= 30) {
                boolean nameExist = itemLists.stream().anyMatch(x -> x.getName().equals(itemList.getName()));
                if(!nameExist){
                    itemLists.add(itemList);
                }else
                    throw new FieldIsNotUniqueException();
            }else
                throw new CreationDateException();
        }else
            throw new TooManyItemsException();
    }

    public ArrayList<ItemList> getItemLists() {
        return itemLists;
    }

    public ItemList getByName(String name) {
        return this.itemLists.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst()
                .orElse(null);
    }

    public void setItemLists(ArrayList<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    public boolean isValid(){
        try{
            for(ItemList itemList : this.itemLists){
                if(!itemList.isValid())
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
                "items=" + itemLists +
                '}';
    }
}
