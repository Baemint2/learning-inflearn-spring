package hello.itemservice.domain.item;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, hello.itemservice.domain.item.Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public hello.itemservice.domain.item.Item save(hello.itemservice.domain.item.Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public hello.itemservice.domain.item.Item findById(Long id) {
        return store.get(id);
    }

    public List<hello.itemservice.domain.item.Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, hello.itemservice.domain.item.Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setItemType(updateParam.getItemType());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
    }

    public void clearStore() {
        store.clear();
    }

}
