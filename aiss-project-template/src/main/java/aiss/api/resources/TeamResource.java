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
import javax.ws.rs.core.Response;

import aiss.model.Team;
import aiss.model.repository.MapCompetitionRepository;
import aiss.model.repository.CompetitionRepository;

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
		return null;
	}
	
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public Team get(@PathParam("name") String teamName)
	{
		
		return null;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addTeam(@Context UriInfo uriInfo, Team team) {
		return null;
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateTeam(Team team) {
		return null;
	}
	
	@DELETE
	@Path("/{name}")
	public Response removeTeam(@PathParam("name") String teamName) {
		return null;
	}
	
}
