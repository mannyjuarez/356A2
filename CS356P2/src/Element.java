/*
 * implements the visitor design pattern. This node, or element has a method
 * that accepts a visitor.
 */

/**
 *
 * @author mannyjuarez
 */
public interface Element {

    void accept(Visitor visitor);

}
