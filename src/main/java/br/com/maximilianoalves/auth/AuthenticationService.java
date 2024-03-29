package br.com.maximilianoalves.auth;

import br.com.maximilianoalves.config.JwtService;
import br.com.maximilianoalves.error.ResourceNotFoundException;
import br.com.maximilianoalves.user.Role;
import br.com.maximilianoalves.user.User;
import br.com.maximilianoalves.user.UserRepository;
import io.jsonwebtoken.Jwts;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        AuthenticationResponse authenticationResponse = null;
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user);
            authenticationResponse = AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        return authenticationResponse;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .expire(jwtService.extractExpiration(jwtToken))
                .build();
    }

}
