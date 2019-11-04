package jp.co.systena.tigerscave.springtest.application.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.springtest.application.model.Cart;
import jp.co.systena.tigerscave.springtest.application.model.Item;
import jp.co.systena.tigerscave.springtest.application.model.Order;
import jp.co.systena.tigerscave.springtest.application.service.ListForm;
import jp.co.systena.tigerscave.springtest.application.service.ListService;

@Controller  // Viewあり。Viewを返却するアノテーション
public class ShoppingController {
  @Autowired
  HttpSession session;                  // セッション管理
  @RequestMapping(value = "/ListView", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(HttpSession session, ModelAndView mav,
                            @RequestParam(name = "name", required = false) String name) {
    //public ModelAndView index(ModelAndView mav) {

    //ListForm listForm = (ListForm) session.getAttribute("form");
    //session.removeAttribute("form");
    //List<Item> items = (List<Item>) session.getAttribute("itemList");
    //session.getAttribute("itemList");
    //session.setAttribute("itemList");
//    if( items == null) {
//      items = new ArrayList<Item>();
//      //session.setAttribute("itemList", items);
//    }

    mav.addObject("items", new ListService().getItemList());

    mav.setViewName("ListView");
    // Viewのテンプレート名を返す
    //return "ListView";
    return mav;
  }

  @RequestMapping(value="/CartView", method = RequestMethod.POST)  // URLとのマッピング
  public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {

    // セッション取得
    Cart cart = (Cart) session.getAttribute("cartList");
    if (cart == null) {
      cart = new Cart();
    }


    //いらない？Item item = new Item();
    Map<String, Item> cartList = new HashMap<String, Item>();
    Map<String, Item> itemList = new ListService().getItemList();


    Order order = new Order();
    order.setId(listForm.getId());
    cart.addOrder(order);

    //いらない？item = itemList.get(String.valueOf(order.getId()));

    //cartListへ追加
    int i = 0;
    for (Order cartItem : cart.getOrderList()) {
      cartList.put(String.valueOf(cartItem.getId()), itemList.get(String.valueOf(cartItem.getId())));
      i++;
    }

    // セッション保存、テンプレートitemsに代入
    mav.addObject("items",cartList);
    session.setAttribute("cartList", cart);

    //mav.addObject("listForm",listForm);

    mav.setViewName("CartView");
    return mav;
  }
}
