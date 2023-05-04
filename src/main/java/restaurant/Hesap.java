package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hesap {
    private ArrayList<Order> orders = new ArrayList<>();
    public void addOrder(Order order){
        orders.add(order);
    }
    public double getTotalAmount(){//toplam siparis tutari
        return orders.//orderlarin bulundugu bir liste yaptik- [1001, 1002, 1003, 1004]
                stream().
                mapToDouble(Order::getTotalAmount).
                sum();
    }

    public void printHesap(){
        System.out.println("************* Hesap fisi ************");

        for (Order order :orders ) {//siparisler listesini ele aldik- restorana gelen herkesin siparisi var[1001,1002,1003,1004]
            System.out.println("Siparis Kodu: "+order.getOrderCode());
            System.out.print("Yiyecekler: ");
            HashMap<MenuItem, Integer> items  = order.getItems();

            for (Map.Entry<MenuItem,Integer> entry: items.entrySet()) {//kisi kisi fatura yazdiracagim.entry set ile entrilerimi set'e ceviriyorum.ayri ayri ele aliyorum.
                MenuItem item = entry.getKey();// 2 tane hamburger ise hamburger burada
                int adet = entry.getValue();//2 adet burada gorunecek.
                System.out.printf("%-20s   %d x   %.2f TL ",
                        item.getName(),adet,item.getPrice());//formatli yazdirir.
                //%formatli olarak yazdirir,
                // - sola yasla ve 20 karakterlik yer ac,
                // s ==>string, d==> tamsayi,
                // %.2==> basamakli sayilarda noktadan sonra 2 basamak yazdir,
                // f==> ondalikli sayilar icin

            }
            System.out.println(order.getTotalAmount());//sadece bir kisinin siparisi

        }//for e tum yiyecekler
        System.out.println(getTotalAmount());//bir masanin toplam siparisi

    }
}
