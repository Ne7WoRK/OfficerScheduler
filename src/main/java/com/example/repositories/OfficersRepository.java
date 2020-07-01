package com.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Officer;

@Repository
public interface OfficersRepository extends JpaRepository<Officer, Long>{
	

	@Query(value = "SELECT * FROM officers WHERE officers.id = ?1", nativeQuery = true)
	Officer getOfficer(int id);
	
	@Query(value = "SELECT photo FROM officers WHERE officers.id = ?1", nativeQuery = true)
	 byte[] loadPhoto(int officerId);


}
