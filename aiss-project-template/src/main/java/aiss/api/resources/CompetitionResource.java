 package aiss.api.resources;

import java.net.URI;

import java.util.Collection;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Competition;
import aiss.model.Team;
import aiss.model.repository.MapCompetitionRepository;
import aiss.model.repository.CompetitionRepository;





@Path("/comp")
public class CompetitionResource {
	
	private static CompetitionResource _instance=null;
	CompetitionRepository repository;
	
	CompetitionResource() {
		repository=MapCompetitionRepository.getInstance();

	}
	
	public static CompetitionResource getInstance()
	{
		if(_instance==null)
				_instance=new CompetitionResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Competition> getAll()
	{
		return repository.getAllCompetitions();
	}
	
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public Competition get(@PathParam("name") String name)
	{
		Competition comp = repository.getCompetition(name);
		
		if (comp == null) {
			throw new NotFoundException("The competition named "+ name +" was not found");			
		}
		
		return comp;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCompetition(@Context UriInfo uriInfo, Competition competition) {
		if (competition.getName() == null || "".equals(competition.getName()))
			throw new BadRequestException("The name of the competition must not be null");
		
		if (competition.getTeams()!=null)
			throw new BadRequestException("The teams property is not editable.");

		repository.addCompetition(competition);

		// Builds the response. Returns the competition the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(competition.getName());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(competition);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateCompetition(Competition competition) {
		Competition oldCompetition = repository.getCompetition(competition.getName());
		if (oldCompetition == null) {
			throw new NotFoundException("The competition named "+ competition.getName() +" was not found");			
		}
		
		if (competition.getTeams()!=null)
			throw new BadRequestException("The teams property is not editable.");
		
		// Update country
		if (competition.getCountry()!=null)
			oldCompetition.setCountry(competition.getCountry());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{name}")
	public Response removeCompetition(@PathParam("name") String name) {
		Competition toberemoved=repository.getCompetition(name);
		if (toberemoved == null)
			throw new NotFoundException("The competition named "+ name +" was not found");
		else
			repository.deleteCompetition(name);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{competitionName}/{teamName}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addTeam(@Context UriInfo uriInfo,@PathParam("competitionName") String competitionName, @PathParam("teamName") String teamName)
	{				
		
		Competition competition = repository.getCompetition(competitionName);
		Team team = repository.getTeam(teamName);
		
		if (competition==null)
			throw new NotFoundException("The competition named " + competitionName + " was not found");
		
		if (team == null)
			throw new NotFoundException("The team named " + teamName + " was not found");
		
		if (competition.getTeam(teamName)!=null)
			throw new BadRequestException("The team is already in this competition.");
			
		repository.addTeam(competitionName, teamName);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(competitionName);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(competition);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{competitionName}/{teamName}")
	public Response removeTeam(@PathParam("competitionName") String competitionName, @PathParam("teamName") String teamName) {
		Competition competition = repository.getCompetition(competitionName);
		Team team = repository.getTeam(teamName);
		
		if (competition==null)
			throw new NotFoundException("The competition named " + competitionName + " was not found");
		
		if (team == null)
			throw new NotFoundException("The team named " + teamName + " was not found");
		
		
		repository.removeTeam(competitionName, teamName);		
		
		return Response.noContent().build();
	}
}