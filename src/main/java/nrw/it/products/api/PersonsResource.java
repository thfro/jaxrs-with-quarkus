package nrw.it.products.api;

import nrw.it.products.Person;
import nrw.it.products.services.PersonService;
import org.jboss.logging.annotations.Param;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Path("/persons")
public class PersonsResource {

    @Inject
    PersonService personService;


    // GET /persons?lastname=Maus&firstName=xxx&minAge=20&maxAge=60
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(@BeanParam SearchParams params) {
        Collection<Person> result = personService.getAllPersons();

        if (params.lastName!=null) {
            result = result.stream().filter(p -> p.getLastName().equals(params.lastName)).collect(Collectors.toList());
        }

        return Response.ok().entity(result).build();
    }

    // POST /persons
    // Im Request Body => Person im JSON-Format enthalten sein
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        Long personId = personService.addPerson(person);
        URI personURI =
            UriBuilder.fromUri("http://localhost:8080/persons/{id}")
                      .resolveTemplate("id", personId)
                      .build();
        return Response.created(personURI).build();
    }


    // DELETE /persons/{id}
    @DELETE
    @Path("{personId}")
    public Response deletePerson(@PathParam("personId") Long id) {
        try {
            personService.deletePerson(id);
            return Response.ok().build();

        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND)
                           .header("MeinResponseHeader", "TestWert")
                           .entity("Fehler: " + ex.getMessage())
                           .build();
        }
    }


    // Kleine Demonstration von Streams
    public void test() {
        List<String> result =
            personService.getAllPersons()
                         .parallelStream()
                         .map(Person::getLastName)
                         .filter(nachname -> nachname.length() > 3)
                         .filter(nachname -> nachname.startsWith("A"))
                         .collect(Collectors.toList());
    }

}