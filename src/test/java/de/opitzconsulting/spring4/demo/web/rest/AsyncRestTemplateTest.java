package de.opitzconsulting.spring4.demo.web.rest;

import de.opitzconsulting.spring4.demo.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * Simple demo using the <code>AsyncRestTemplate</code>.
 * <p>Start the jetty before calling.
 */
public class AsyncRestTemplateTest {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncRestTemplateTest.class);

    public static void main(String[] args) {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<Person>> futureEntity = asyncRestTemplate.getForEntity("http://localhost:8080/spring4-java8-demo/person/{id}", Person.class, 1);

        futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<Person>>() {
            @Override
            public void onSuccess(ResponseEntity<Person> result) {
                LOG.info("onSuccess: {}", result.getBody());
            }

            @Override
            public void onFailure(Throwable t) {
                LOG.error(t.getMessage(), t);
            }
        });
    }

}
