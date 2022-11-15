package com.aways.userdetailsmgmtservice.serviceimpl;

import com.aways.userdetailsmgmtservice.entity.UserDataEntity;
import com.aways.userdetailsmgmtservice.entity.UserLoggingData;
import com.aways.userdetailsmgmtservice.repository.UserDataRepository;
import com.aways.userdetailsmgmtservice.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public List<UserDataEntity> getAllUserDetails() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<UserDataEntity> userDataEntities = userDataRepository.findAll();
        userDataEntities = userDataEntities.stream().map(user -> {
            user.setsNo(atomicInteger.incrementAndGet());
            return user;
        }).collect(Collectors.toList());
        return userDataEntities ;
    }

    @Override
    public void saveNewUserDetails(UserDataEntity userDataEntity) {

        userDataRepository.save(userDataEntity);
    }

    @Override
    public UserDataEntity getUserDetailsById(Long userId) {

       return userDataRepository.findById(userId).get();
    }

    @Override
    public void deleteUserDataById(Long userId) {

        userDataRepository.deleteById(userId);
    }

    @Override
    public UserLoggingData getUserLoggingInfo() {
        UserLoggingData userData = new UserLoggingData();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userData.setLoggedInUserName(authentication.getName());
        return userData;
    }
}

