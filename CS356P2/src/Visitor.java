/*
 * implements the visitor design pattern. This visitor is then accepted by the 
 * node interface, which is implemented by TotalGroups, TotalPositive, TotalUsers,
 * and TotalVisitors
 */

/**
 *
 * @author mannyjuarez
 */
public interface Visitor {

    String visit(TotalUsers users);

    String visit(TotalGroups groups);

    String visit(TotalMessages messages);

    String visit(TotalPositive positive);

}
