package by.academy.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {
}
