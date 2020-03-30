import com.tawhidshop.dao.ProductDao;
import com.tawhidshop.entities.Product;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {
    private ProductDao productDao = new ProductDao();
    @Test
    void add() {

        Product product = new Product();
        product.setPrice(107.00);
        product.setTitle("STICK DEODORANT");
        product.setImage("D:\\Images HDD\\EcomeSite\\product3.jpg");
        product.setDescription("Forever Aloe Ever-Shield Deodorant Stick by Forever Living Products contains no aluminium salts, parabens or alcohol that are usually found in antiperspirant deodorants. " +
                "The Forever Aloe Vera deodorant formula provides effective, all-day protection.");

        assertNotEquals(-1,productDao.add(product));
    }

    @Test
    void removeById() {
        assertNotEquals(-1,productDao.removeById(2));
        assertNotEquals(-1,productDao.removeById(5));
    }

    @Test
    void update() {
        assertNotEquals(0,productDao.update(new Product(3,"EVERSHIELD DEODORANT",
                "Forever Aloe Ever-Shield Deodorant Stick by Forever Living Products contains no aluminium salts, parabens or alcohol that are usually found in antiperspirant deodorants. \" +\n" +
                        "                \"The Forever Aloe Vera deodorant formula provides effective, all-day protection."
                ,"D:\\Images HDD\\EcomeSite\\product3.jpg",99.99)));
    }

    @Test
    void get() {
        Set<Product> products  = productDao.get("");
        for (Product p : products
             ) {
            System.out.println(p.toString());
        }
        assertNotNull(products);
    }
}