package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.Education;
import io.javabrains.resumeportal.models.Job;
import io.javabrains.resumeportal.models.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String home() {
        System.out.println("Loading app data");

        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName("shruti");
        userProfileOptional.orElseThrow(()-> new RuntimeException("User not found varun"));
        UserProfile userProfile1 = userProfileOptional.get();
        
        Job j1 = new Job();
        j1.setCompany("Infosys C1");
        j1.setCurrentJob(false);
        j1.setId(1001);
        j1.setDesignation("System Engineer");
        j1.setStartDate(LocalDate.of(2020, 1, 1));
        j1.setCurrentJob(true);

        Job j2 = new Job();
        j2.setCompany("Cisco Systems C2");
        j2.setCurrentJob(true);
        j2.setId(1002);
        j2.setDesignation("Software Engineer 2");
        j2.setStartDate(LocalDate.of(2019, 5, 1));
        j2.setEndDate(LocalDate.of(2020, 1, 1));
        j2.setCurrentJob(false);
        
        userProfile1.getJobs().clear();
        userProfile1.getJobs().add(j1);
        userProfile1.getJobs().add(j2);

        userProfileRepository.save(userProfile1);

        return "index";
    }

    @GetMapping("/edit")
    public String edit() {
        return "profile-templates/1/index";
    }

    @GetMapping("/view/{userId}")
    public String viewFun(@PathVariable String userId,Model model) {

        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(()-> new RuntimeException("User not found "+userId));

        UserProfile userProfile = userProfileOptional.get();

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);
        
        System.out.println("user profile ="+userProfile.getJobs().get(0).getCompany());
        System.out.println("user profile ="+userProfile.getJobs().get(1).getCompany());

        return "profile-templates/" + userProfile.getId() + "/index" ;
    }



}
