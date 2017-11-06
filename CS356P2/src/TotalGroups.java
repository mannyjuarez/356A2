/*
 * implements the element interface to accept visitors and keep track of groups
 */

/**
 *
 * @author mannyjuarez
 */
public class TotalGroups implements Element {

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
