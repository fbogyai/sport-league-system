package cz.muni.fi.pv243.sportleaguesystem.dao.interfaces;

import java.util.List;

import cz.muni.fi.pv243.sportleaguesystem.entities.League;
import cz.muni.fi.pv243.sportleaguesystem.entities.Sport;
import cz.muni.fi.pv243.sportleaguesystem.entities.User;


/**
*
* @author Filip Bogyai
*/
public interface LeagueDAO {

   /**
    * Adds new League to the database.
    *
    * @param league League to add.
    * @throws IllegalArgumentException if parameter is null or has assigned id.   
    */
   void create(League league);

   /**
    * Returns League with given id.
    *
    * @param id primary key of requested League.
    * @return League with given id or null if such League doesn't exist.   
    */
   League get(Long id);

   /**
    * Updates existing League.
    *
    * @param league League to update (specified by id) with new attributes.
    * @throws IllegalArgumentException if parameter is null.   
    */
   void update(League league);

   /**
    * Removes existing League.
    *
    * @param league League to remove (specified by id).
    * @throws IllegalArgumentException if parameter is null.   r.
    */
   void delete(League league);

   /**
    * Returns list of all Leagues in the database.
    *
    * @return all Leagues in the DB or empty list if there are none.   
    */
   List<League> findAll();

    /**
    * Returns list of Leagues in given sport.
    *
    * @return Leagues given sport or empty list if there are none.   
    */
   List<League> findLeaguesBySport(Sport sport);
}
