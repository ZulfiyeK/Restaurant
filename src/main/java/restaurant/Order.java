package restaurant;


import java.util.HashMap;

public class Order {
    private static int orderCount = 1000;// cod her zaman artmamali, sayac artmali
    private int orderCode;//siparis kodu
    private HashMap<MenuItem,Integer> items = new HashMap<>();// items HasMap'in icinde (pizza, 2adet)
    private double totalAmount = 0;//toplam fiyat

    public Order() {
        orderCode = orderCount++;//asil kod degismemeli, her obje olusturuldugunda kodun artmasi gerekir ama ilk kod da artar.
        //o yuzden counter'i sayac'i arttirip kod'a assign ettik.
    }

    public void addItem( MenuItem item,int adet){
        items.put(item,adet);//
        totalAmount += item.getPrice()*adet;// toplaya toplaya son fiyati verecek.
    }

    public int getOrderCode() {
        return orderCode;
    }

    public HashMap<MenuItem, Integer> getItems() {//yiyecekler ve siparis adetleri
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

}
