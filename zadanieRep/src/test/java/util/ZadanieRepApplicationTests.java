package util;

import com.example.bartoszjarzab.zadanieRep.model.GitHubEntity;
import util.RetrieveUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZadanieRepApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void checkStatusCode() throws IOException {


        HttpUriRequest request = new HttpGet( "http://localhost:8080//repositories/users/god/repos");


        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);


        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void checkUserOfRepository() throws IOException {


        HttpUriRequest request = new HttpGet( "http://localhost:8080//repositories/users/god/repos" );


        HttpResponse response = HttpClientBuilder.create().build().execute( request );


        GitHubEntity resource = RetrieveUtil.retrieveResourceFromResponse(response, GitHubEntity.class);
        assertThat( "god", Matchers.is(resource.getNameOfRepository()));
    }

}
