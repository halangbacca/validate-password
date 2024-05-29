package com.halan.secure_password.controller;

import com.halan.secure_password.controller.dto.BodyRequest;
import com.halan.secure_password.controller.dto.FailureResponse;
import com.halan.secure_password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(value = "/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request) {
        var failures = passwordService.validatePassword(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }
}
