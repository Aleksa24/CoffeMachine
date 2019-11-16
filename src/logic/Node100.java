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
public class Node100 extends Node {

    @Override
    public void getCurrency(Currency currency, Map<String, Integer> map, Map<String, Integer> kasa) {
        if (kasa.get("100") != 0 && currency.getAmount() > 100) {//dal ima u kasi novcanica
            int a = currency.getAmount() / 100;//novcanice
            int b = currency.getAmount() % 100;//ostatak
            if (kasa.get("100") >= a) {//ako ima dovoljno novcanica u kasi
                kasa.put("100", kasa.get("100") - a);//iz kase se uzme za a
                map.put("100", a);
            }
            if (kasa.get("100") < a) {//ako nema dovoljno novcanica u kasi
                b = (a - kasa.get("100")) * 100 + b;//poveca se za razliku
                a = kasa.get("100");//a uzme preostale novcanice iz kase
                kasa.put("100", 0);//sada kasa nema nista
                map.put("100", a);
            }
            if (b != 0) {//pita dal ima preostalog
                if (next != null) {//gleda dal ima sledeca novcanica
                    next.getCurrency(new Currency(b), map, kasa);
                } else {//ako nema sledeci nema da se uzima iz kase pa nema ni kusura
                    System.out.println("nema dovoljno novca u kasi!!!");
                }
            }
        } else if (next != null) {//ode na sledeceg ako postoji
            map.put("100", 0);
            next.getCurrency(currency, map, kasa);
        }
//        if (currency.getAmount() >= 100) {
//            int a = currency.getAmount() / 100;
//            int b = currency.getAmount() % 100;
//            map.put("100", a);
//            if (b != 0 && next != null) {
//                next.getCurrency(new Currency(b), map);
//            }
//        } else {
//            map.put("100", 0);
//            if (next != null) {
//                next.getCurrency(currency, map);
//            }
//        }
    }

}
