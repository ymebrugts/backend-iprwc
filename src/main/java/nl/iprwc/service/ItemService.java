package nl.iprwc.service;
import nl.iprwc.model.Item;
import nl.iprwc.persistence.*;

import javax.inject.Inject;

public class ItemService {

    private final ItemDao itemDao;

    @Inject
    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Item getItemFromId(int id) {
        return itemDao.getItemFromId(id);
    }



}
