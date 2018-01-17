package com.nissho.vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nissho.vn.model.Category;
import com.nissho.vn.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Product> getAllProducts() {
		
		String sql = "SELECT * FROM product";
	    List<Product> listProducts = jdbcTemplate.query(sql, new RowMapper<Product>() {
	    	
	        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Product p = new Product();
	        	p.setProductCode(rs.getString("product_code"));
	        	p.setProductName(rs.getString("product_name"));
	        	p.setCtgCode(rs.getString("ctg_code"));
	        	p.setSalesStartDate(rs.getString("sales_start_date"));
	        	p.setSalesPrice(rs.getInt("sales_price"));
	        	p.setCostPrice(rs.getInt("cost_price"));
	        	p.setDiscountLimit(rs.getInt("discount_limit"));
	 
	            return p;
	        }
	 
	    });
	 
	    return listProducts;
	}

	public Product findOne(String code) {
		 String sql = "SELECT * FROM product WHERE product_code='" + code +"'";
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {
		 
		        public Product extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Product p = new Product();
			        	p.setProductCode(rs.getString("product_code"));
			        	p.setProductName(rs.getString("product_name"));
			        	p.setCtgCode(rs.getString("ctg_code"));
			        	p.setSalesStartDate(rs.getString("sales_start_date"));
			        	p.setSalesPrice(rs.getInt("sales_price"));
			        	p.setCostPrice(rs.getInt("cost_price"));
			        	p.setDiscountLimit(rs.getInt("discount_limit"));
		                return p;
		            }
		 
		            return null;
		        }
		 
		    });
	}

}
