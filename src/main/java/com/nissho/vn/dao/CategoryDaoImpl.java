package com.nissho.vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nissho.vn.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Category> getAllCategories() {
		String sql = "SELECT * FROM category";
	    List<Category> listCategory = jdbcTemplate.query(sql, new RowMapper<Category>() {
	    	
	        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Category p = new Category();
	        	p.setCtgCode(rs.getString("ctg_code"));
	        	p.setCtgName(rs.getString("ctg_name"));
	            return p;
	        }
	    });
	 
	    return listCategory;
	}

}
