/*
 * this observable interface updates the followers that a user has and 
 * updates the news feed if a user is following another
 */

/**
 *
 * @author mannyjuarez
 */
public interface Observable {

    public void updateFollowers(String message);

    public void updateTextFollowingUser();

}
