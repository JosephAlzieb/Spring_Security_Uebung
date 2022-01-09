package de.hhu.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class WebController {

    @GetMapping("/")
    public String getIndex(Model model, @AuthenticationPrincipal OAuth2User userObject) {
//        model.addAttribute("user",
//                userObject != null ? userObject.getAttribute("login") : null
//        );
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }

    @GetMapping("/tokeninfo")
    @ResponseBody
    public Map<String, Object> tokeninfo(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        OAuth2AccessToken gitHubAccessToken = authorizedClient.getAccessToken();
        return Map.of("token", gitHubAccessToken);
    }
}