package cz.muni.fi.pv243.sportleaguesystem.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import cz.muni.fi.pv243.sportleaguesystem.entities.League;
import cz.muni.fi.pv243.sportleaguesystem.entities.Sport;
import cz.muni.fi.pv243.sportleaguesystem.service.interfaces.LeagueService;
import cz.muni.fi.pv243.sportleaguesystem.service.interfaces.SportService;

@Model
public class LeagueController {

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private LeagueService leagueService;
	
	@Inject
	private SportService sportService;
	
	private List<League> leagues;
	private League newLeague;
	private String sportId;
	private Sport sport;
	
	public String getSportId() {
		return sportId;
	}

	@Produces
	@Named
	public League getNewLeague() {
		return newLeague;
	}

	@Produces
	@Named
	public List<League> getLeagues() {
		return leagues;
	}
	
	public void add() throws IOException {
		newLeague.setSport(sport);
		leagueService.createLeague(newLeague);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Added!", "New League added successfully"));
		facesContext.getExternalContext().redirect("index.xhtml?sportID=" + sportId);
	}
	
	public void save() throws IOException {
		leagueService.updateLeague(newLeague);
		facesContext.getExternalContext().redirect("index.xhtml?sportID=" + sportId);
	}
	
	public void remove() throws IOException {
		leagueService.deleteLeague(newLeague);
		facesContext.getExternalContext().redirect("index.xhtml?sportID=" + sportId);
	}
	
	@PostConstruct
	public void populateLeagues() {
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		sportId = params.get("sportID");
		String filterName = params.get("filterName");
		String leagueId = params.get("leagueID");
		
		if (sportId != null) {
			sport = sportService.getById(Long.parseLong(sportId));
			
			if (filterName != null && !"".equals(filterName.trim()))
				leagues = leagueService.findByName(filterName, sport);
			else
				leagues = leagueService.findBySport(sport);
		}
		
		if (leagueId != null)
			newLeague = leagueService.getById(Long.parseLong(leagueId));
		else
			newLeague = new League();
	}
}
