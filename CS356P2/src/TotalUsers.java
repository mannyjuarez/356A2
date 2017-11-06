/*
 * implements the element interface and accepts visitors to keep track of
 * the total users in the system
 */

/**
 *
 * @author mannyjuarez
 */
public class TotalUsers implements Element {

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
