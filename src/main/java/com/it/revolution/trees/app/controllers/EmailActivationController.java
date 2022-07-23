package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.common.settings.WebSettings;
import com.it.revolution.trees.app.model.entity.User;
import com.it.revolution.trees.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activate")
@CrossOrigin
public class EmailActivationController {

    private final WebSettings webSettings;
    private final UserService customerService;

    @GetMapping("/email/{id}/{activationCode}")
    public RedirectView activate(@PathVariable(name = "id") Long id,
                                 @PathVariable(name = "activationCode") String code) throws URISyntaxException {
        User user = customerService.findById(id).orElse(null);
        if (Objects.nonNull(user) && user.getActivationCode().equals(code)) {
            user.setActivationCode("");
            user = customerService.save(user);
        }
        Optional<User> customerOptional = Optional.ofNullable(user);
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost(webSettings.getFrontend().getHost())
                .setPath("/login")
                .addParameter("emailConfirm", String.valueOf(customerOptional.map(User::isActivated).orElse(false)))
                .addParameter("email", customerOptional.map(User::getEmail).orElse("")).build();
        return new RedirectView(uri.toString());
    }

}
