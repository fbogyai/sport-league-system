package cz.muni.fi.pv243.sportleaguesystem.dao.interfaces;

import java.util.Date;
import java.util.List;

import cz.muni.fi.pv243.sportleaguesystem.entities.League;
import cz.muni.fi.pv243.sportleaguesystem.entities.Match;
import cz.muni.fi.pv243.sportleaguesystem.entities.User;


/**
 * 
 * @author Filip Bogyai
 */
public interface MatchDAO {
    
    /**
     * Creates a new Match in the database.
     *
     * @param Match Match to create.    
     */
    void create(Match Match);

    
    /**
     * Returns the Match that has the specified ID.
     *
     * @param id id to search for.
     * @return Match with corresponding id,  null if such Match doesn't exist.     
     */
    Match get(Long id);

    /**
     * Updates existing Match.
     *
     * @param match Match to update (specified by id) with new attributes.
     * @throws IllegalArgumentException if parameter is null.   
     */
    void update(Match match);
    
    /**
     * Removes existing Match it from database
     *
     * @param Match Match to remove.    
     */
    void delete(Match Match);
    
    /**
     * Returns all Matches or null if no match exists
     *
     * @return all Matches or empty list if there are none.     
     */
    List<Match> findAllMatches();
    
    /**		
     * Return all Matches of given user.		
     *		
     * @param user user
     * @return Matches of given user.		     	
     */		
    List<Match> findMatchesByUser(User user);

}
