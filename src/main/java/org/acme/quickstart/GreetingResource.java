package org.acme.quickstart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/hello")
public class GreetingResource {

    @Inject
    @Original
    Greeting service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name + "!");
    }

    @POST
    @Path("/file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response tratarArquivoRemessa(
        MultipartFormDataInput input
    ) throws Exception {
        System.out.println(input);
        System.out.println(input.getFormDataMap());
        
        List<InputPart> listInput = input.getFormDataMap().get("avatar");
        System.out.println(listInput.size());
        InputPart i = listInput.get(0);
        System.out.println(i.getBodyAsString());
        System.out.println(i.getMediaType());

        Map<String, List<InputPart>> inputMap = input.getFormDataMap();

        for (String k : inputMap.keySet()) {
            System.out.println("key = " + k);
        }

        if (!i.getMediaType().toString().equals("application/json")) {
            return Response.status(400).entity("Tipo de arquivo inválido").build();
        }

        ObjectMapper mapper = new ObjectMapper();
        Pessoa p = null;
        try {            
            p = mapper.readValue(i.getBodyAsString(), Pessoa.class);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Json inválido").build();
        }
        System.out.println(p);

        return Response.ok(true).build();
    }
}