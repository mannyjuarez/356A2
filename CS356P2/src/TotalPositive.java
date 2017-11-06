/*
 * implements the Element interface and accepts visitors to keep track of all
 * positive twitter messages
 */

/**
 *
 * @author mannyjuarez
 */
public class TotalPositive implements Element {

    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
