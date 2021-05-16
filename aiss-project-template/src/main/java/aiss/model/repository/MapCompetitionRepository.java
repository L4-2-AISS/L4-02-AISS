package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Competition;
import aiss.model.Team;


public class MapCompetitionRepository implements CompetitionRepository{

	Map<String, Competition> competitionMap;
	Map<String, Team> teamMap;
	private static MapCompetitionRepository instance=null;			
	
	
	public static MapCompetitionRepository getInstance() {
		
		if (instance==null) {
			instance = new MapCompetitionRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		competitionMap = new HashMap<String,Competition>();
		teamMap = new HashMap<String,Team>();
		
		// Create teams
		Team realMadrid = new Team();
		realMadrid.setName("Real Madrid CF");
		realMadrid.setCity("Madrid");
		realMadrid.setCountry("Spain");
		realMadrid.setStadium("Santiago Bernabéu");
		addTeam(realMadrid);
		
		Team barcelona = new Team();
		barcelona.setName("FC Barcelona");
		barcelona.setCity("Barcelona");
		barcelona.setCountry("Spain");
		barcelona.setStadium("Camp Nou");
		addTeam(barcelona);
		
		Team sevilla = new Team();
		sevilla.setName("Sevilla FC");
		sevilla.setCity("Sevilla");
		sevilla.setCountry("Spain");
		sevilla.setStadium("Ramon Sánchez Pizjuán");
		addTeam(sevilla);
		
		Team atleticoMadrid = new Team();
		atleticoMadrid.setName("Club Atlético de Madrid");
		atleticoMadrid.setCity("Madrid");
		atleticoMadrid.setCountry("Spain");
		atleticoMadrid.setStadium("Wanda Metropolitano");
		addTeam(atleticoMadrid);
		
		Team betis = new Team();
		betis.setName("Real Betis Balompié");
		betis.setCity("Sevilla");
		betis.setCountry("Spain");
		betis.setStadium("Benito Villamarín");
		addTeam(betis);
		
		Team psg = new Team();
		psg.setName("Paris Saint-Germain");
		psg.setCity("Paris");
		psg.setCountry("France");
		psg.setStadium("Parc Des Princes");
		addTeam(psg);
		
		Team monaco = new Team();
		monaco.setName("AS Monaco");
		monaco.setCity("Monaco");
		monaco.setCountry("Monaco");
		monaco.setStadium("Stade Louis II");
		addTeam(monaco);
		
		Team lyon = new Team();
		lyon.setName("Olympique Lyonnais");
		lyon.setCity("Lyon");
		lyon.setCountry("France");
		lyon.setStadium("Parc Olympique Lyonnais");
		addTeam(lyon);
		
		Team marsella = new Team();
		marsella.setName("Olympique de Marseille");
		marsella.setCity("Marseille");
		marsella.setCountry("France");
		marsella.setStadium("Stade Vèlodrome");
		addTeam(marsella);
		
		Team mcity = new Team();
		mcity.setName("Manchester City FC");
		mcity.setCity("Manchester");
		mcity.setCountry("England");
		mcity.setStadium("Etihad Stadium");
		addTeam(mcity);
		
		Team munited = new Team();
		munited.setName("Manchester United F.C");
		munited.setCity("Manchester");
		munited.setCountry("England");
		munited.setStadium("Old Trafford");
		addTeam(munited);
		
		Team leicester = new Team();
		leicester.setName("Leicester City F.C");
		leicester.setCity("Leicester");
		leicester.setCountry("England");
		leicester.setStadium("King Power Stadium");
		addTeam(leicester);
		
		Team chelsea = new Team();
		chelsea.setName("Chelsea F.C");
		chelsea.setCity("London");
		chelsea.setCountry("England");
		chelsea.setStadium("Stamford Bridge");
		addTeam(chelsea);
		
		// Create competitions
		Competition ligaSantander=new Competition();
		ligaSantander.setName("LaLiga Santander");
		ligaSantander.setCountry("Spain");
		addCompetition(ligaSantander);
		
		Competition championsLeague=new Competition();
		championsLeague.setName("UEFA Champions League");
		championsLeague.setCountry("Europe");
		addCompetition(championsLeague);
		
		Competition ligue1=new Competition();
		ligue1.setName("Ligue 1");
		ligue1.setCountry("France");
		addCompetition(ligue1);
		
		Competition premier=new Competition();
		premier.setName("Premier League");
		premier.setCountry("United Kingdom");
		addCompetition(premier);
		
		// Add teams to competitions
		addTeam(ligaSantander.getName(), realMadrid.getName());
		addTeam(ligaSantander.getName(), barcelona.getName());
		addTeam(ligaSantander.getName(), sevilla.getName());
		addTeam(ligaSantander.getName(), atleticoMadrid.getName());
		addTeam(ligaSantander.getName(), betis.getName());
		
		addTeam(championsLeague.getName(), realMadrid.getName());
		addTeam(championsLeague.getName(), barcelona.getName());
		addTeam(championsLeague.getName(), atleticoMadrid.getName());
		addTeam(championsLeague.getName(), psg.getName());
		addTeam(championsLeague.getName(), mcity.getName());
		
		addTeam(ligue1.getName(), psg.getName());
		addTeam(ligue1.getName(), monaco.getName());
		addTeam(ligue1.getName(), lyon.getName());
		addTeam(ligue1.getName(), marsella.getName());
		
		addTeam(premier.getName(), mcity.getName());
		addTeam(premier.getName(), munited.getName());
		addTeam(premier.getName(), leicester.getName());
		addTeam(premier.getName(), chelsea.getName());
	}
	
	// Competition related operations
	@Override
	public void addCompetition(Competition c) {
		competitionMap.put(c.getName(),c);
	}
	
	@Override
	public Collection<Competition> getAllCompetitions() {
			return competitionMap.values();
	}

	@Override
	public Competition getCompetition(String name) {
		return competitionMap.get(name);
	}
	
	@Override
	public void updateCompetition(Competition c) {
		competitionMap.put(c.getName(), c);
	}

	@Override
	public void deleteCompetition(String name) {	
		competitionMap.remove(name);
	}
	

	@Override
	public void addTeam(String competitionName, String teamName) {
		Competition competition = getCompetition(competitionName);
		competition.addTeam(teamMap.get(teamName));
	}

	@Override
	public Collection<Team> getAll(String competitionName) {
		return getCompetition(competitionName).getTeams();
	}

	@Override
	public void removeTeam(String competitionName, String teamName) {
		getCompetition(competitionName).deleteTeam(teamName);
	}

	
	// Team related operations
	
	@Override
	public void addTeam(Team t) {
		teamMap.put(t.getName(), t);
	}
	
	@Override
	public Collection<Team> getAllTeams() {
			return teamMap.values();
	}

	@Override
	public Team getTeam(String teamName) {
		return teamMap.get(teamName);
	}

	@Override
	public void updateTeam(Team t) {
		Team team = teamMap.get(t.getName());
		team.setCity(t.getCity());
		team.setCountry(t.getCountry());
		team.setStadium(t.getStadium());
		
	}

	@Override
	public void deleteTeam(String teamName) {
		teamMap.remove(teamName);
	}
	
}
