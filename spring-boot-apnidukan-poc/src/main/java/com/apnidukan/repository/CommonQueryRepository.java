package com.apnidukan.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.apnidukan.model.SearchProduct;

@Component
public class CommonQueryRepository {
	
	@Autowired
    private JdbcTemplate template;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String,Object>> getRowsOfTable(String tableName){
        return template.queryForList("select * from " + tableName);
    }

    public List<Map<String,Object>> getQuestionDetails(){
        return template.queryForList("SELECT a.id, a.title, a.description, a.tag, a.created_at, a.updated_at, a.user_Id, concat(concat(b.first_name,' '),b.last_name) name FROM question a inner join user b on a.user_id=b.id");
    }

    public <T> void save(T t){
        entityManager.persist(t);
    }

    public void resetCounter(String sequenceName, Long count){
        template.execute("ALTER SEQUENCE " + sequenceName + " RESTART WITH " + count + ";");
    }

    public List<Map<String,Object>> getCartCount(long custId){
        return template.queryForList("SELECT * from cart where CUST_ID="+custId);
    }

    public List<Map<String,Object>> getCartDetails(long custId){
        return template.queryForList("SELECT i.ITEM_ID itemId, i.ITEM_NAME itemName, i.ITEM_PRICE itemPrice, i.item_image itemImage, SUM(ITEM_PRICE) totalPrice, count(*) itemCount from item i inner join cart c on i.ITEM_ID=c.ITEM_ID where cust_id="+custId+" group by i.ITEM_ID");
    }

    public Map<String, Object> getMaxId(String table, String column){
        return template.queryForMap("select max("+column+")+1 newId from "+table);
    }

    public List<Map<String, Object>> getOrderDetails(long id){
        return template.queryForList("select ");
    }

    //Helps us get next AutoIncrement Value from the database
	public Map<String, Object> getAutoIncrementId(String table,String column) {
		// TODO Auto-generated method stub
		System.out.println("Executing autoincrement query");
		System.out.println();
		 return template.queryForMap("SELECT auto_increment newId FROM INFORMATION_SCHEMA.TABLES WHERE table_name = '"+ table+"';");
		 
	}
	
	public List<SearchProduct> getProductsByPage(int pageid,int total){  
	    String sql="select * from product_details limit "+(pageid-1)+","+total;  
	    return template.query(sql,new RowMapper<SearchProduct>(){  
	        public SearchProduct mapRow(ResultSet rs, int row) throws SQLException {  
	        	SearchProduct e=new SearchProduct();  
	           // e.setProductId(Long.parseLong(rs.getString("id")));  
	        	 e.setProductId((rs.getInt("id")));
	            e.setProductName(rs.getString("product_name"));  
	            e.setProductDescription(rs.getString("product_description"));  
	            return e;  
	        }  
	    });  
	}

	public List<SearchProduct> getProductsByPageAndSearch(int pageid, int total, String searchField) {
		  String sql = "select * from product_details";
		 // String sql="select * from product_details";
		/*  if(searchField.equals("")){
			//  sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
		  }
		  else*/ 
		  if(searchField.equals("*")) {
			 // sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
			  sql = "select * from product_details";
		  }else if(!searchField.equals("")){
			  sql = sql + " WHERE id like '%"+searchField+"%' OR product_name like '%"+searchField+"%'";
		  }
		  sql = sql + " limit "+(pageid-1)+","+total;  
		  
		  System.out.println("SQL search getProductsByPageAndSearch : " + sql);
		    return template.query(sql,new RowMapper<SearchProduct>(){  
		        public SearchProduct mapRow(ResultSet rs, int row) throws SQLException {  
		        	SearchProduct e=new SearchProduct();  
		            e.setProductId((rs.getInt("id")));
		            //System.out.println("product ID");
		            e.setProductName(rs.getString("product_name"));
		            //System.out.println("product ID");
		            e.setProductDescription(rs.getString("product_description")); 
		            //System.out.println("product ID");
		            e.setProductImageExists(rs.getBoolean("product_image_exists"));
		            //System.out.println("product ID");
		            e.setProductNumItems(rs.getInt("product_num_items"));
		            //System.out.println("product ID");
		            e.setProductPrice(rs.getDouble("product_price"));
		            //System.out.println("product ID");
		            e.setCategoryId(Long.parseLong(rs.getString("category_id")));
		            e.setProductArchived(rs.getBoolean("product_archived"));
		            e.setProductImageName(rs.getString("product_image_name"));
		            //System.out.println("Name : " + e.getProductId() + " Image flag : " +e.isProductArchived() );
		            return e;  
		        }  
		    });
	} 
	
	public List<SearchProduct> getProductsSearchSize(int pageid, int total, String searchField) {
		  String sql = "select * from product_details";
		 // String sql="select * from product_details";
		  /*if(!searchField.equals("")){
			  sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
		  }*/
		  //sql = sql + " limit "+(pageid-1)+","+total;  
		  
		  if(searchField.equals("*")) {
				 // sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
				  sql = "select * from product_details";
			  }else if(!searchField.equals("")){
				  sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
			  }
		  System.out.println("SQL search : " + sql);
		    return template.query(sql,new RowMapper<SearchProduct>(){  
		        public SearchProduct mapRow(ResultSet rs, int row) throws SQLException {  
		        	SearchProduct e=new SearchProduct();  
		            e.setProductId((rs.getInt("id")));  
		            e.setProductName(rs.getString("product_name"));  
		            e.setProductDescription(rs.getString("product_description"));  
		            //e.setProductArchived(rs.getBoolean("product_image_exists"));
		            return e;  
		        }  
		    });
	} 
}
