/**
 * 
 */
package com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.AddressEntity;
import com.springboot.model.Major;

/**
 * @author Junaid.khan
 *
 */
@Repository
public interface RequestCaptureRepository extends CrudRepository<RequestCaptureEntity, RequestCapturePrimaryKey> {

//	@Query("insert into spring_cloud.request (id,last_name,address,age,first_name,major,unique_id,verify_value)"
//			+ "value (:id,:last_name,:address,:age,:first_name,:major,:unique_id,:verify_value)")

	@Query("insert into spring_cloud.request (id,last_name,address,age,first_name,major,unique_id,verify_value)"
			+ "value (:id,:last_name,:address,:age,:first_name,:major,:verify_value)")
	boolean captureIncomingRequests(@Param("id") int  id, @Param("last_name") String lastName,
			@Param("address") AddressEntity addressEntity, @Param("age") int age, @Param("first_name") String firstName,
			 @Param("major") Major maths, @Param("verify_value") String generateVerifyValue);
}
