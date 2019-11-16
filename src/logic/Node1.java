/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Currency;
import java.util.Map;

/**
 *
 * @author student1
 */
public class Node1 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map,Map<String,Integer> kasa) {
        if (kasa.get("1") != 0 && currency.getAmount() > 1) {//dal ima u kasi novcanica
//            int a = currency.getAmount() / 1;//novcanice
//            int b = currency.getAmount() % 1;//ostatak
            if (kasa.get("1") >= currency.getAmount()) {//ako ima dovoljno novcanica u kasi
                kasa.put("1", kasa.get("1") - currency.getAmount());//iz kase se uzme za a
                map.put("1", currency.getAmount());
            }
            if (kasa.get("1") < currency.getAmount()) {//ako nema dovoljno novcanica u kasi
                System.out.println("Nema dovoljno para u kasi!");
            }  
        } 
        if (kasa.get("1") == 0) {
            System.out.println("nema u kasi 1");
        }
//        if (currency.getAmount() >= 1) {
//            map.put("1", currency.getAmount());
//        } else {
//            map.put("1", 0);
//        }
    }

}
