import java.util.ArrayList;
/*
 * implements the User interface. This follows the composite pattern and 
 * is one of the children of the User component. The users in this include 
 * this group and a single user.
 */

/**
 *
 * @author mannyjuarez
 */
public class UserGroup implements User {

    public long lastUpdateTime;
    public long creationTime;
    private String id = "";
    private ArrayList<User> usersInGroup;
    private ArrayList<User> groupsInGroup;
    private static int groupCounter = 0;

    public UserGroup(String id) {
        this.id = id;
        usersInGroup = new ArrayList<User>();
        groupsInGroup = new ArrayList<User>();
        ++groupCounter;
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
    
    public void add(User user) {
        usersInGroup.add(user);
    }

    public void addGroup(UserGroup group) {
        groupsInGroup.add(group);
    }

    public static String getGroupCounter() {
        String result = Integer.toString(groupCounter);
        return result;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id + " Group Folder";
    }

    @Override
    public ArrayList<User> getFollowing() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<User> getFollower() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<String> getNewsFeed() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addFollowing(User u) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFollowed(User u) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addToNewsFeed(String s) {
        // TODO Auto-generated method stub

    }

    public UserViewPanel getUserPanel() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setUserPanel(UserViewPanel userViewPanel) {
        // TODO Auto-generated method stub

    }

}
