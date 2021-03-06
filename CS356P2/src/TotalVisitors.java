/*
 * is used to implement the TotalVisitors feature
 */

/**
 *
 * @author mannyjuarez
 */
public class TotalVisitors implements Visitor {

    @Override
    public String visit(TotalUsers users) {
        // TODO Auto-generated method stub
        return "Total Users: "
                + AdminControlPanel.getInstance().getUsers().size();
    }

    @Override
    public String visit(TotalGroups groups) {
        // TODO Auto-generated method stub
        return "Total Groups: "
                + (AdminControlPanel.getInstance().getGroups().size() + 1);
    }

    @Override
    public String visit(TotalMessages messages) {
        // TODO Auto-generated method stub
        String result = Integer.toString(UserViewPanel.getTotalMessages());
        return "Total Messages: " + result;
    }

    @Override
    public String visit(TotalPositive positive) {
        // TODO Auto-generated method stub

        return "Positive Percentage: " + UserViewPanel.getPositivePercentage();
    }

}
