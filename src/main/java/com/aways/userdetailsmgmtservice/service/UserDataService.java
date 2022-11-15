package com.aways.userdetailsmgmtservice.service;

import com.aways.userdetailsmgmtservice.entity.UserDataEntity;
import com.aways.userdetailsmgmtservice.entity.UserLoggingData;

import java.util.List;

public interface UserDataService {

    List<UserDataEntity> getAllUserDetails();

    void saveNewUserDetails(UserDataEntity userDataEntity);

    UserDataEntity getUserDetailsById(Long userId);

    void deleteUserDataById(Long userId);

    UserLoggingData getUserLoggingInfo();
}
