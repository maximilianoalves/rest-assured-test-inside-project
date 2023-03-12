package br.com.maximilianoalves.auth;

import br.com.maximilianoalves.error.ResourceNotFoundDetails;
import br.com.maximilianoalves.error.UserAlreadyExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "", description = "Register a new auth user", tags = { "POST - Auth" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = UserAlreadyExists.class)))})
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        AuthenticationResponse authenticationResponse = authenticationService.register(request);
        if (authenticationResponse == null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "User already exists.");
            return new ResponseEntity<>(jsonObject, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(authenticationResponse, HttpStatus.CREATED);
        }
    }

    @Operation(summary = "", description = "Create and generate token for a user", tags = { "POST - Auth" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = UserAlreadyExists.class)))})
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
