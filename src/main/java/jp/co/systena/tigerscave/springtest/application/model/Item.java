package jp.co.systena.tigerscave.springtest.application.model;

public class Item {
  private int id;
  private String name;
  private int price;

//  public Item(int id, String name, int price) {
//    this.id = id;
//    this.name = name;
//    this.price = price;
//  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
 }