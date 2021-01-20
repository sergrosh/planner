package com.familyplanner.planner.api;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiRedirectController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public void redirectToSwagger(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/api/v1/swagger-ui/index.html");
    }

}
