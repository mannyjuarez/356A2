
import java.util.List;

/*
 * This interface implements the composite design pattern.
 * UserGroup and SingleUser are child components that have their behavior 
 * modeled after this class.
 */

/**
 *
 * @author mannyjuarez
 */
public interface User {

	public String toString();

	public String getId();

	public List<User> getFollowing();

	public List<User> getFollower();

	public List<String> getNewsFeed();

	public void addFollowing(User u);

	public void addFollowed(User u);

	public void addToNewsFeed(String s);

	public UserViewPanel getUserPanel();

	public void setUserPanel(UserViewPanel userViewPanel);

}