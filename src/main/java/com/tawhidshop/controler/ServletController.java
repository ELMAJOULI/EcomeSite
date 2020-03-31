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
@WebServlet(urlPatterns = {"/show.do","/addProduct.do","/remove.do","/update.do"})
public class ServletController extends HttpServlet {
    private ProductModel productModel ;
    private ProductDao productDao ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if(path.equals("/show.do")) {
            String keyword = "";
            if (req.getParameter("keyword") != null)
                keyword = req.getParameter("keyword");
            productModel.setProducts( productDao.get(keyword));
            req.setAttribute("products",productModel.getProducts());
            req.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(req, resp);
        }
        else if (path.equals("/addProduct.do")) {
            req.getRequestDispatcher("/WEB-INF/Views/addProduct.jsp").forward(req, resp);
        } else if (path.equals("/remove.do")) {
            productDao.removeById(Integer.valueOf(req.getParameter("id")));
            resp.sendRedirect("/show.do");
        }
        else if (path.equals("/update.do")) {
            int id =Integer.valueOf(req.getParameter("id")) ;
            Product product = productDao.get(id);
            product.setId(id);
            req.setAttribute("p", product);
            req.getRequestDispatcher("/WEB-INF/Views/updateProduct.jsp").forward(req,resp);
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
        if(req.getServletPath().equals("/addProduct.do")){
            productDao.add(product);
            doGet(req,resp);
        }
        else if (req.getServletPath().equals("/update.do")) {
            product.setId(Integer.valueOf(req.getParameter("id")));
            productDao.update(product);
            resp.sendRedirect("/show.do");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = new ProductDao();
        productModel = new ProductModel();

    }
}
