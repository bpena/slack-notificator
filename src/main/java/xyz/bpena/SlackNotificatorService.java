package xyz.bpena;

import java.util.concurrent.ExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class SlackNotificatorService {
    @ConfigProperty(name = "slack.path")
    String path;

    @Inject
    @RestClient
    SlackService slack;

    public Response sendMessage() {
        Response response = null;
        try {
            SlackMessage message = SlackMessage.builder().text("Saludando 1.2.3").build();
            slack.sendMessage(message.toString(), path);
            response = Response.ok(message).build();
        } catch(WebApplicationException e) {
            response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getResponse().getEntity()).build();
        } catch(Exception e) {
            log.error(e.getClass().getName());
            log.error(e.getLocalizedMessage());
            log.error(e.getMessage());
            response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}
