import java.util.*;

class ProductFactory {
    public List<Product> listOfProducts(int numOfProducts) {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= numOfProducts; i++) {
            products.add(createProduct(i));
        }
        return products;
    }
    public Product createProduct(int num){
        Product obj = new Product();
        String [] nameArray = new String[]{"A","B","C","D"};
        String [] catArray = new String[]{"electronics","vehicles","wallets","shoes"};
        obj.name = nameArray[num%4] + num/4;
        obj.category = catArray[(int) (Math.random()*4)];
        obj.price = (int) (Math.random()*1000 + 100);
        return obj;
    }

}
class Product{
    String name;
    String category;
    int price;
}
public class advques3 {
    public static void main(String[] args) {
        ProductFactory obj1 = new ProductFactory();
        List<Product> number = obj1.listOfProducts(10);
        List<Product> products_in_range = new ArrayList<>();
        // products in a given range
        int min_price = 100;
        int max_price = 900;
        number.stream().forEach(x -> {
            if (x.price >= min_price && x.price <= max_price) {
                products_in_range.add(x);
            }
        });
        System.out.println(products_in_range);
        // number of categories of projects
        Map<String, Integer> mp = new HashMap<>();
        Map<String, Integer> mi = new HashMap<>();
        Map<String, Integer> ma = new HashMap<>();
        number.stream().forEach(x -> {
            if (mp.containsKey(x.category)) {
                mp.put(x.category, mp.get(x.category) + 1);
                mi.put(x.category, Math.min(mi.get(x.category), x.price));
                ma.put(x.category, Math.max(ma.get(x.category), x.price));
            } else {
                mp.put(x.category, 1);
                mi.put(x.category, x.price);
                ma.put(x.category, x.price);
            }
        });
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey());
        }
        //max and min of each product
        System.out.println("Minimum values of products in each category");
        for (Map.Entry<String, Integer> entry : mi.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("Maximum value of products in each category");
        for (Map.Entry<String, Integer> entry : ma.entrySet()) {
            System.out.println(entry);
        }
    }
}

