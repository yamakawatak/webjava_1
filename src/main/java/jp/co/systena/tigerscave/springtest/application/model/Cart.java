package jp.co.systena.tigerscave.springtest.application.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
  private List<Order> orderList = new ArrayList<Order>();


  public void addOrder(Order order) {
    orderList.add(order);
  }

  public List<Order> getOrderList() {
    return orderList;
  }
}
