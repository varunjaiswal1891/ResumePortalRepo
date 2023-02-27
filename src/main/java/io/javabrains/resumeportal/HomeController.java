package io.javabrains.resumeportal;

import io.javabrains.resumeportal.models.Education;
import io.javabrains.resumeportal.models.Job;
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

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/edit")
    public String edit() {
        return "profile-edit";
    }

    @GetMapping("/view/{userId}")
    public String viewFun(@PathVariable String userId,Model model) {
        model.addAttribute("userId", userId);
        return "profile";
    }



}
