package com.tawhidshop.controler;

import com.tawhidshop.dao.ProductDao;
import com.tawhidshop.entities.Product;
import com.tawhidshop.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/show.do","/addProduct.do","/remove.do"})
public class ServletController extends HttpServlet {
    private ProductModel productModel ;
    private ProductDao productDao ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/show.do")) {
            productModel.setProducts( productDao.get(""));
            req.setAttribute("products",productModel.getProducts());
            req.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(req, resp);
        }
        else if (path.equals("/addProduct.do")) {
            req.getRequestDispatcher("/WEB-INF/Views/addProduct.jsp").forward(req, resp);
        } else if (path.equals("/remove.do")) {
            productDao.removeById(Integer.valueOf(req.getParameter("id")));

            resp.sendRedirect("/show.do");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setTitle((String) req.getParameter("title"));
        product.setDescription((String) req.getParameter("description"));
        product.setPrice( Double.valueOf(req.getParameter("price")));
        product.setImage(null);
        System.out.println(product);
        productDao.add(product);
        doGet(req,resp);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = new ProductDao();
        productModel = new ProductModel();

    }
}
