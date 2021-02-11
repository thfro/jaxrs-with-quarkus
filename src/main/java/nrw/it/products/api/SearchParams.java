package nrw.it.products.api;

import javax.ws.rs.QueryParam;

public class SearchParams {
    @QueryParam("lastname")
    public String lastName;

    @QueryParam("firstName")
    public String firstName;

    @QueryParam("minAge")
    public String minAge;

    @QueryParam("maxAlter")
    public String maxAge;
}
