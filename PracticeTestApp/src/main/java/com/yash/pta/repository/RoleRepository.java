package com.yash.pta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.pta.model.Role;
import com.yash.pta.model.RoleName;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
