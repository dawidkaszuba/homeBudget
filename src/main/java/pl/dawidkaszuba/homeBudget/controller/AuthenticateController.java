package pl.dawidkaszuba.homeBudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.homeBudget.app.configuration.JwtTokenUtil;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.model.JwtRequest;
import pl.dawidkaszuba.homeBudget.model.LoggedUser;
import pl.dawidkaszuba.homeBudget.model.UserDTO;
import pl.dawidkaszuba.homeBudget.service.UserService;
import pl.dawidkaszuba.homeBudget.serviceImpl.JwtUserDetailsService;

@RestController
@CrossOrigin
public class AuthenticateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UserService userService;

    @Autowired
    public AuthenticateController(AuthenticationManager authenticationManager,
                                  JwtTokenUtil jwtTokenUtil,
                                  JwtUserDetailsService userDetailsService,
                                  UserService userService) {

        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public LoggedUser createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        LOGGER.info("Authenticate: {}", authenticationRequest.toString());

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        User user = userService.findByUserName(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
<<<<<<< Updated upstream

        return new LoggedUser(user.getUserName(), user.getId(), token);
=======
        final Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(token);
        LoggedUser loggedUser = new LoggedUser(user.getUserName(), user.getId(), token, expirationDate);
        LOGGER.info("AuthenticateResponse: {}", loggedUser.toString());
        return loggedUser;
>>>>>>> Stashed changes
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
