package cz.muni.fi.pv243.sportleaguesystem.service.interfaces;

import java.util.List;

import cz.muni.fi.pv243.sportleaguesystem.entities.Principal;
import cz.muni.fi.pv243.sportleaguesystem.entities.User;

public interface PrincipalService {
	
   /**
    * Adds new principal to the database.
    * 
    * @param principal principal to add. 
    * @throws IllegalArgumentException if parameter is null or if principal loginName/password is null.    
    */
   void create(Principal principal);
    
   
   /**
    * Updates existing principal.
    * 
    * @param principal principal to update (specified by id) with new attributes.   
    * @throws IllegalArgumentException if parameter is null or if principal does not exist.  
    */
   void update(Principal principal);
   
   /**
    * Removes existing principal.
    * 
    * @param principal principal to remove (specified by loginName).  
    * @throws IllegalArgumentException if parameter is null.  
    */
   void delete(Principal principal);
   
   /**
    * Returns principal of given user.
    * 
    * @param user of requested pricipal
    * @return principal of given user 
    * @throws IllegalArgumentException if parameter is null.  
    */
   Principal findPrincipalByUser(User user);

   /**
    * Returns principal with given loginName.
    * 
    * @param loginName of requested pricipal
    * @return principal of given loginName
    * @throws IllegalArgumentException if parameter is null.  
    */
   Principal findPrincipalByLoginName(String loginName);
}
