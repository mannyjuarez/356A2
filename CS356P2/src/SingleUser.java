
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/*
 * This class implements the user interface. This is designed to create an 
 * individual user of the "Mini twitter"
 */
/**
 *
 * @author mannyjuarez
 */
public class SingleUser implements User {

    private long lastUpdateTime;
    private static int userCounter = 0;
    private long creationTime;
    private String id = null;
    private List<User> usersFollowing; // the list of users being followed by
    // this user
    private List<User> followedBy; // the list of users following this user
    private List<String> newsFeed;

    private UserViewPanel userPanel;

    public SingleUser(String id) {
        this.id = id;
        usersFollowing = new ArrayList<User>();
        followedBy = new ArrayList<User>();
        newsFeed = new ArrayList<String>();
        ++userCounter;
        creationTime = System.currentTimeMillis();
    }

    public long getLastUpdateTime()
    {
        return lastUpdateTime;
    }
    public long getCreationTime()
    {
        return creationTime;
    }
    public String toString() {
        return this.id;
    }

    /* ADDERS METHODS */
    public void addToNewsFeed(String message) {

        this.newsFeed.add(message);
        lastUpdateTime =  System.currentTimeMillis();
    }

    public void addFollowing(User user) {

        this.usersFollowing.add(user);

    }

    public void addFollowed(User u) {
        // TODO Auto-generated method stub
        this.followedBy.add(u);
    }

    /* GETTERS METHODS */
    public List<String> getNewsFeed() {
        return newsFeed;
    }

    // Who am i following
    public List<User> getFollowing() {
        return usersFollowing;
    }

    // Who's following me
    public List<User> getFollower() {
        return followedBy;
    }

    public static String getTotalUsers() {
        String result = Integer.toString(userCounter);
        return result;
    }

    public void setUserPanel(UserViewPanel userPanel) {
        this.userPanel = userPanel;
    }

    public UserViewPanel getUserPanel() {
        return this.userPanel;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return this.id;
    }
}
