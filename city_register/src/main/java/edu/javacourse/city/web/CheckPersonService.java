package edu.javacourse.city.web;

import edu.javacourse.city.dao.PersonCheckDao;
import edu.javacourse.city.dao.PoolConnectionBuilder;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exeption.PersonCheckerException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/check")
@Singleton
public class CheckPersonService {
    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    
    private PersonCheckDao dao;
    
    @PostConstruct
    public void init(){
    logger.info("SERVICE is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    
    }
    
        
    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse ckeckPerson(PersonRequest request) throws PersonCheckerException {
        logger.info(request.toString());
        return dao.checkPerson(request);
    }
}


//GET /city_register-1.0/rest/check/101?name=value