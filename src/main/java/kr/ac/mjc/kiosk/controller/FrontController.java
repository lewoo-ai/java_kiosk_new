package kr.ac.mjc.kiosk.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kiosk.mvc.model.dto.Bundle;
import kiosk.mvc.model.dto.Orders;
import kiosk.mvc.model.dto.OrdersDetails;
import kiosk.mvc.model.service.CustomerService;
import kr.ac.mjc.kiosk.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/front")
public class FrontController {

    @Autowired
    private CustomerService cs;

    @GetMapping("/initProducts")
    public String initProducts(Model model) {
        Gson gson = new Gson();
        try {
            List<Category> list = cs.SelectProductByCategory();
            String data = gson.toJson(list);
            System.out.println(data);

            model.addAttribute("data", data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productsPage";
    }

    @GetMapping("/initBundles")
    public String initBundles(Model model) {
        Gson gson = new Gson();
        try {
            List<Bundle> list = cs.selectBundle();
            String data = gson.toJson(list);
            System.out.println(data);

            model.addAttribute("data", data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "bundlesPage";
    }

    @PostMapping("/insertOrders")
    public String insertOrders(@RequestBody String input) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<OrdersDetails>>() {
        }.getType();

        List<OrdersDetails> list = gson.fromJson(input, listType);
        Orders orders = new Orders();
        orders.setOrdersDetailsList(list);

        try {
            cs.insertOrders(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/front/initProducts";
    }
}
