package com.cookingpage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/userPortal")
    @PreAuthorize("hasAnyRole('ROLE_USER')")

    public String getAdminPortalPage() {
        return "userPortal";
    }
}
