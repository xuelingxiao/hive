package com.xlx.product.repository.repo;

import com.xlx.product.repository.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean saveProduct(Product product) {
        boolean success = false;
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into product(name) values (?)");
            statement.setString(1,"xlx");
            int rs=  statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public List<Product> selectAll(){
        List<Product> productList ;
        productList= jdbcTemplate.query("select id,name from product", new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                return product;
            }
        });
        return productList;
    }
}
