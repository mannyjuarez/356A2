/*
 * implements the Element interface and accepts visitors to keep track of 
 * total messages
 */

/**
 *
 * @author mannyjuarez
 */
public class TotalMessages implements Element {

    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }

}
