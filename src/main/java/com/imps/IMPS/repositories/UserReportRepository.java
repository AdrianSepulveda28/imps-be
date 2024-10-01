package com.imps.IMPS.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.imps.IMPS.models.UserReport;

public interface UserReportRepository extends CrudRepository<UserReport, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE UserReport ur SET ur.role = :role, ur.status = :status WHERE ur.email = :email")
    int updateUserReport(@Param("role") String role, @Param("status") String status, @Param("email") String email);

    UserReport findByEmail(String email);

    @Query("SELECT COUNT(u) FROM UserReport u WHERE u.status = 'Accepted'")
    int countAcceptedUsers();

    @Query("SELECT COUNT(u) FROM UserReport u WHERE u.status = 'Declined'")
    int countDeclinedUsers();
    
    @Query("SELECT COUNT(u) FROM UserReport u")
    int countAllUsers();
}
