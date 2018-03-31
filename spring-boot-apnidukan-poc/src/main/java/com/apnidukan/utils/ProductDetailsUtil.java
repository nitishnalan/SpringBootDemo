package com.apnidukan.utils;

import java.util.Map;

import com.apnidukan.repository.CommonQueryRepository;

public class ProductDetailsUtil {
	
	public static Long getMaxId(String table, String column, CommonQueryRepository commonRepository) {
        Map<String, Object> map = commonRepository.getMaxId(table,column);
        if(map.get("newId") != null){
            return (Long)map.get("newId");
        }else{
            return 1L;
        }
    }	
	
	public static String getAutoIncrementId(String table, String column,CommonQueryRepository commonRepository) {
        Map<String, Object> map = commonRepository.getAutoIncrementId(table,column);
        System.out.println("After Executing autoincrement query");
        if(map.get("newId") != null){
        	System.out.println("returning newId for autoincrement");
        	System.out.println("NEWId : " + map.get("newId"));
            return map.get("newId").toString();
        }else{
            return "0";
        }
    }
	
	
}
