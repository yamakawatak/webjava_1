package jp.co.systena.tigerscave.springtest.application.service;

import java.util.HashMap;
import java.util.Map;
import jp.co.systena.tigerscave.springtest.application.model.Item;

public class ListService {
  public Map<String, Item> getItemList(){
    Item item1 =new Item();
    item1.setId(1);
    item1.setName("商品1");
    item1.setPrice(1000);
    Item item2 =new Item();
    item2.setId(2);
    item2.setName("商品2");
    item2.setPrice(2000);
    Item item3 =new Item();
    item3.setId(3);
    item3.setName("商品3");
    item3.setPrice(3000);
    Map<String, Item> items = new HashMap<String, Item>();
    items.put("1",item1);
    items.put("2",item2);
    items.put("3",item3);
    return items;
  }
}