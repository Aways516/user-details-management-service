package com.aways.userdetailsmgmtservice.repository;

import com.aways.userdetailsmgmtservice.entity.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity,Long> {


}

