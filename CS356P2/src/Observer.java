/*
 * implements the observer design pattern
 */

/**
 *
 * @author mannyjuarez
 */
public interface Observer {

    // The observable in this parameter calls the custom made observable
    // not java's observable
    public void update(User user);

}
