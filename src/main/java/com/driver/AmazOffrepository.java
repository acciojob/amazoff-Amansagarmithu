package com.driver;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class AmazOffrepository {

    HashMap<String,Order> orderdb = new HashMap<>();
    HashMap<String,DeliveryPartner> partner = new HashMap<>();
    HashMap<String,List<String>> order_partner = new HashMap<>();
    public void addOrder(Order order){
        orderdb.put(order.getId(),order);
    }
    public void addPartner(DeliveryPartner dp){
        partner.put(dp.getId(), dp);
    }
    public void assigning(String order_id,String partner_id){
        if(order_partner.containsKey(partner_id)){
            order_partner.get(partner_id).add(order_id);
        }
        else{
            List<String> ides = new ArrayList<>();
            ides.add(order_id);
            order_partner.put(partner_id,ides);
        }
        partner.get(partner_id).setNumberOfOrders(partner.get(partner_id).getNumberOfOrders()+1);
    }
    public Order getOrder(String order_id){
        return orderdb.get(order_id);
    }
    public DeliveryPartner getPartner(String partner_Id){
        return partner.get(partner_Id);
    }
    public int orderCount(String partnerId){
        int ans = partner.get(partnerId).getNumberOfOrders();
        return ans;
    }
    public List<String> listOfOrder(){
        List<String> ans = new ArrayList<>();
        for(String x:orderdb.keySet()){
            ans.add(x);
        }
        return ans;
    }
}
