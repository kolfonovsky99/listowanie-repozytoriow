package  com.example.bartoszjarzab.zadanieRep.service;

import com.example.bartoszjarzab.zadanieRep.model.GitHubEntity;
import com.example.bartoszjarzab.zadanieRep.util.GitHubHelper;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
public class GithubControllerRestApiController {

    @RequestMapping("/users/{username}/repos")
    public String getRepoDetailsByOwner(@PathVariable String username) {


        return githubWrapperRepo(username).toString();

    }

    private List<GitHubEntity> githubWrapperRepo(String user) {

        HttpEntity<String> entity = new HttpEntity("parameters", GitHubHelper.getUserAgentHeader());

        RestTemplate rest = new RestTemplate();
        ResponseEntity<List<GitHubEntity>> exchange = rest.exchange(
                "https://api.github.com/users/" + user + "/repos",
                HttpMethod.GET,
                entity, new ParameterizedTypeReference<List<GitHubEntity>>() {
                }
        );

        return exchange.getBody();
    }

    private Gson getGson() {
        return new Gson();
    }

    private Map getMapFromJson(String jsonString) {
        return getGson().fromJson(jsonString, Map.class);
    }

}