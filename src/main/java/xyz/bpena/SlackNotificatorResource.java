package xyz.bpena;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/notification")
public class SlackNotificatorResource {

    @Inject
    public SlackNotificatorService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendNotification() {
        return service.sendMessage();
    }
}