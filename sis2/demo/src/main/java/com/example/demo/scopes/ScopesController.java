package com.example.demo.scopes;

import com.example.demo.scopes.model.HelloMessageGenerator;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scopes")
public class ScopesController {

    @Resource(name = "requestScopedBean")
    private HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    private HelloMessageGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    private HelloMessageGenerator applicationScopedBean;

    @GetMapping("/request")
    public String getRequestScopeMessage() {
        String previousMessage = requestScopedBean.getMessage();
        requestScopedBean.setMessage("Good morning!");
        return "Previous: " + previousMessage + ", Current: " + requestScopedBean.getMessage();
    }

    @GetMapping("/session")
    public String getSessionScopeMessage() {
        String previousMessage = sessionScopedBean.getMessage();
        sessionScopedBean.setMessage("Good afternoon!");
        return "Previous: " + previousMessage + ", Current: " + sessionScopedBean.getMessage();
    }

    @GetMapping("/application")
    public String getApplicationScopeMessage() {
        String previousMessage = applicationScopedBean.getMessage();
        applicationScopedBean.setMessage("Good evening!");
        return "Previous: " + previousMessage + ", Current: " + applicationScopedBean.getMessage();
    }
}
