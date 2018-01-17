package com.nissho.vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nissho.vn.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM product";
	    List<Product> listProducts = jdbcTemplate.query(sql, new RowMapper<Product>() {
	    	
	        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Product p = new Product();
	        	p.setProductCode(rs.getString("product_code"));
	        	p.setProductName(rs.getString("product_name"));
	        	p.setSalesStartDate(rs.getString("sales_start_date"));
	        	p.setSalesPrice(rs.getInt("sales_price"));
	        	p.setCostPrice(rs.getInt("cost_price"));
	        	p.setDiscountLimit(rs.getInt("discount_limit"));
	 
	            return p;
	        }
	 
	    });
	 
	    return listProducts;
	}

}
