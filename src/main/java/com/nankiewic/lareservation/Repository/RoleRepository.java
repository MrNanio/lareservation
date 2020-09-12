package com.nankiewic.lareservation.Repository;

import com.nankiewic.lareservation.Entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRole(String name);
}
