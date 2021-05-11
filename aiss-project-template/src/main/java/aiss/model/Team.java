package aiss.model;

public class Team {

	private String name;
	private String city;
	private String country;
	private String stadium;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}
	
	public Team(String name, String city, String country, String stadium) {
		
		this.name = name;
		this.city = city;
		this.country = country;
		this.stadium = stadium;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

}
