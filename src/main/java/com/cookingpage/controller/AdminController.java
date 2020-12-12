package com.cookingpage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/adminPortal")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    public String getAdminPortalPage() {
        return "adminPortal";
    }
}
