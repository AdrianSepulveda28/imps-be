package com.imps.IMPS.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.imps.IMPS.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery = true)
    User findByEmailAndPassword(String email, String password);
    
    @Query(value = "SELECT * FROM USER WHERE is_head = 1", nativeQuery = true)
    User findHeadUser();
    
    @Query(value = "SELECT * FROM USER WHERE is_admin = 1", nativeQuery = true)
    User findAdminUser();

    @Query(value = "SELECT * FROM USER WHERE is_staff = 1", nativeQuery = true)
    User findStaffUser();

    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 AND PASSWORD = ?2 AND is_admin = 1", nativeQuery = true)
    User checkAdmin(String email, String password);
    
    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 AND is_admin = 1", nativeQuery = true)
    User checkAdminEmail(String email);
    
    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1", nativeQuery = true)
    User findByEmail(String email);
    
    @Query(value = "SELECT * FROM USER WHERE NAME = ?1", nativeQuery = true)
    User findByName(String name);
        
    @Query("SELECT u FROM User u")
    List<User> getAll();

    @Query("SELECT u.role, COUNT(u) FROM User u GROUP BY u.role")
    List<Object[]> countEmployeesByRole();

    
    @Query(value = "SELECT * FROM USER WHERE is_admin != 1", nativeQuery = true)
    Iterable<User> All();
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.Token = ?2 WHERE EMAIL = ?1", nativeQuery = true)
    int setNewToken(String email, String token);
    
    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 and Token = ?2", nativeQuery = true)
    User findByEmailAndToken(String email, String token);

    @Query(value = "SELECT COUNT(*) FROM USER", nativeQuery = true)
    int countAllUsers();

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.password = ?1 WHERE EMAIL = ?2 and Token = ?3", nativeQuery = true)
    int setNewPassword(String password, String email, String token);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.password = ?1 WHERE EMAIL = ?2", nativeQuery = true)
    int setNewPasswordNoToken(String password, String email);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.first_name = ?1 WHERE EMAIL = ?2", nativeQuery = true)
    int setNewFirstName(String name, String email);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.last_name = ?1 WHERE EMAIL = ?2", nativeQuery = true)
    int setNewLastName(String name, String email);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER u SET u.email = ?1 WHERE EMAIL = ?2", nativeQuery = true)
    int setNewEmail(String newEmail, String email);
    
    @Query(value = "SELECT * FROM USER WHERE school_id = ?1", nativeQuery = true)
    User findBySchoolId(String schoolId);

    @Query(value = "SELECT * FROM USER WHERE EMAIL = ?1 AND school_id = ?2", nativeQuery = true)
    User findByEmailAndSchoolId(String email, String schoolId);

    @Query(value = "SELECT * FROM USER WHERE role = ?1", nativeQuery = true)
    Iterable<User> findByRole(String role);

    @Query(value = "SELECT * FROM USER WHERE department = ?1", nativeQuery = true)
    Iterable<User> findByDepartment(String department);
    
    @Query(value = "SELECT * FROM USER WHERE role = ?1 AND department = ?2", nativeQuery = true)
    Iterable<User> findByRoleAndDepartment(String role, String department);
}
