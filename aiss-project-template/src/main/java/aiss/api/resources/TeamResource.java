package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.model.Team;
import aiss.model.repository.MapCompetitionRepository;
import aiss.model.repository.CompetitionRepository;

import java.net.URI;
import java.util.Collection;



@Path("/teams")
public class TeamResource {

	public static TeamResource _instance=null;
	CompetitionRepository repository;
	
	TeamResource(){
		repository=MapCompetitionRepository.getInstance();
	}
	
	public static TeamResource getInstance()
	{
		if(_instance==null)
			_instance=new TeamResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Team> getAll()
	{
		return repository.getAllTeams();
	}
	
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public Team get(@PathParam("name") String name)
	{
		
		Team team = repository.getTeam(name);
		
		if (team == null) {
			throw new NotFoundException("The team named "+ name +" was not found");			
		}
		
		return team;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTeam(@Context UriInfo uriInfo, Team team) {
		if (team.getName() == null || "".equals(team.getName()))
			throw new BadRequestException("The name of the team must not be null");

		repository.addTeam(team);

		// Builds the response. Returns the competition the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(team.getName());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(team);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateTeam(Team team) {
		Team oldTeam = repository.getTeam(team.getName());
		if (oldTeam == null) {
			throw new NotFoundException("The team named "+ team.getName() +" was not found");			
		}
		
		// Update city
		if (team.getCity()!=null)
			oldTeam.setCity(team.getCity());
		
		// Update country
		if (team.getCountry()!=null)
			oldTeam.setCountry(team.getCountry());
		
		// Update stadium
		if (team.getStadium()!=null)
			oldTeam.setStadium(team.getStadium());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{name}")
	public Response removeTeam(@PathParam("name") String name) {
		Team toberemoved = repository.getTeam(name);
		if (toberemoved == null)
			throw new NotFoundException("The team named "+ name +" was not found");
		else
			repository.deleteTeam(name);
		
		return Response.noContent().build();
	}
	
}
