package com.aways.userdetailsmgmtservice.controller;

import com.aways.userdetailsmgmtservice.entity.UserDataEntity;
import com.aways.userdetailsmgmtservice.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping({"/userlist", "/"})
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("user-information-list");
        mav.addObject("userList", userDataService.getAllUserDetails());
        mav.addObject("userInfo", userDataService.getUserLoggingInfo());
        return mav;
    }

    @GetMapping("/addnewuser")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("add-new-user");
        mav.addObject("newUserForm", new UserDataEntity());
        return mav;
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute UserDataEntity userDataEntity) {
        userDataService.saveNewUserDetails(userDataEntity);
        return "redirect:/userlist";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("add-new-user");
        mav.addObject("newUserForm", userDataService.getUserDetailsById(userId));
        return mav;
    }

    @GetMapping("/deleteUser")
    public String deleteUserInformation(@RequestParam Long userId) {
        userDataService.deleteUserDataById(userId);
        return "redirect:/userlist";
    }
}

