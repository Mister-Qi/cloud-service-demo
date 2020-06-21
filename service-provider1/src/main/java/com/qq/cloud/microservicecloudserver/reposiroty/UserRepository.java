package com.qq.cloud.microservicecloudserver.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qq.cloud.microservicecloudserver.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
