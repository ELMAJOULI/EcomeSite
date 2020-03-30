package com.tawhidshop.dao;

import com.tawhidshop.connection.SingleTonConnection;
import com.tawhidshop.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProductDao implements IDao<Product> {
    private Connection connection = SingleTonConnection.CONNECTION.getConnection();
    @Override
    public int add(Product entity) {

        String query1 = "INSERT INTO products(title,description,image,price) VALUES (?,?,?,?)";
        String query2 = "SELECT MAX(ID) AS id FROM products";
        try(PreparedStatement statement = connection.prepareStatement(query1);){
            statement.setString(1,entity.getTitle());
            statement.setString(2,entity.getDescription());
            statement.setString(3,entity.getImage());
            statement.setDouble(4,entity.getPrice());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try(PreparedStatement statement = connection.prepareStatement(query2);){
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int removeById(int id) {
        String query = "DELETE FROM products WHERE ID = ?";
        try( PreparedStatement statement = connection.prepareStatement(query) ;) {
            statement.setInt(1,id);
            return statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Product entity) {
        String query = "UPDATE products SET title = ?, description = ?,image = ?, price = ? WHERE ID = ?";
        try( PreparedStatement statement = connection.prepareStatement(query) ;) {
            statement.setString(1,entity.getTitle());
            statement.setString(2,entity.getDescription());
            statement.setString(3,entity.getImage());
            statement.setDouble(4,entity.getPrice());
            statement.setInt(5,entity.getId());

           return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Set<Product> get(String keyWord) {
        HashSet<Product> products = new HashSet<>();
        String query = "SELECT  * FROM  products WHERE title LIKE  ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,"%"+keyWord+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),resultSet.getString("title")
                        ,resultSet.getString("description"), resultSet.getString("image")
                        ,resultSet.getDouble("price")
                        ))  ;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return products;
    }
}
