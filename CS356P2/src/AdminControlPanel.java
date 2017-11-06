
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/*
 * Follows Singleton Design Pattern. There is a method that allows for one 
 * to get the instance, and methods to get singleton data
 * otherwise this class just creates the control panel JPanel GUI
 */
/**
 *
 * @author mannyjuarez
 */
public class AdminControlPanel extends JPanel {

    private static AdminControlPanel instance = null;

    private static final long serialVersionUID = 1L;

    private List<User> users;
    private List<User> groups;

    private JTextField tfUserID;
    private JTextField tfGroupID;
    private JLabel lMessage;

    private JFrame frame;

    private JButton btnMessageTotal;
    private JButton btnPositivePercentage;
    private JButton btnAddUser;
    private JButton btnAddGroup;
    private JButton btnOpenUserView;
    private JButton btnUserTotal;
    private JButton btnGroupTotal;

    private JTree tree;

    private DefaultTreeModel model;

    private DefaultMutableTreeNode selectedNode;
    private DefaultMutableTreeNode addUser;
    private DefaultMutableTreeNode addGroup;

    /**
     * Create the panel.
     */
    private AdminControlPanel() {
        initialize();
        frame.setVisible(true);
    }

    /* Initialize Widgets */
    private void initialize() {
        /* Making the frame */
        frame = new JFrame("Mini Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 500);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        users = new ArrayList<User>();
        groups = new ArrayList<User>();

        /* Tree */
        UserGroup rootGroup = new UserGroup("Root");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootGroup);
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
        JScrollPane scrollTree = new JScrollPane(tree);
        scrollTree.setBounds(10, 11, 381, 413);
        frame.getContentPane().add(scrollTree);

        /* Label */
        lMessage = new JLabel("");
        lMessage.setForeground(Color.RED);
        lMessage.setBounds(425, 218, 316, 14);
        frame.getContentPane().add(lMessage);

        /* Text Fields */
        tfUserID = new JTextField("");
        tfUserID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tfUserID.setBounds(425, 11, 151, 40);
        tfUserID.setColumns(10);
        frame.getContentPane().add(tfUserID);

        tfGroupID = new JTextField("");
        tfGroupID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tfGroupID.setColumns(10);
        tfGroupID.setBounds(425, 62, 151, 40);
        frame.getContentPane().add(tfGroupID);

        /* Buttons */
        btnMessageTotal = new JButton("Show Messages Total");
        btnMessageTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnMessageTotal.setBounds(425, 384, 170, 40);
        frame.getContentPane().add(btnMessageTotal);

        btnPositivePercentage = new JButton("Show Positive Percentage");
        btnPositivePercentage.setFont(new Font("Times New Roman", Font.PLAIN,
                15));
        btnPositivePercentage.setBounds(620, 384, 170, 40);
        frame.getContentPane().add(btnPositivePercentage);

        btnAddUser = new JButton("Add User");
        btnAddUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnAddUser.setBounds(600, 11, 170, 40);

        btnAddGroup = new JButton("Add Group");
        btnAddGroup.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnAddGroup.setBounds(600, 62, 170, 40);

        btnOpenUserView = new JButton("Open User View");
        btnOpenUserView.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnOpenUserView.setBounds(425, 113, 345, 40);
        frame.getContentPane().add(btnOpenUserView);

        btnUserTotal = new JButton("Show User Total");
        btnUserTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnUserTotal.setBounds(425, 332, 170, 40);

        btnGroupTotal = new JButton("Show Group Total");
        btnGroupTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnGroupTotal.setBounds(620, 332, 170, 40);
        frame.getContentPane().add(btnGroupTotal);

        /* Action Listeners for all the Buttons */
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUsers();
            }
        });
        frame.getContentPane().add(btnAddUser);

        btnAddGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGroups();
            }
        });
        frame.getContentPane().add(btnAddGroup);

        btnOpenUserView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                openView();
            }
        });
        frame.getContentPane().add(btnUserTotal);

        /* Using the Visitor Pattern for statistics */
        btnUserTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TotalUsers total = new TotalUsers();
                TotalVisitors tdv = new TotalVisitors();
                lMessage.setText(tdv.visit(total));
            }
        });

        btnGroupTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TotalGroups total = new TotalGroups();
                TotalVisitors tdv = new TotalVisitors();
                lMessage.setText(tdv.visit(total));
            }
        });

        btnMessageTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TotalMessages total = new TotalMessages();
                TotalVisitors tdv = new TotalVisitors();
                lMessage.setText(tdv.visit(total));
            }
        });

        btnPositivePercentage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TotalPositive total = new TotalPositive();
                TotalVisitors tdv = new TotalVisitors();
                lMessage.setText(tdv.visit(total));
            }
        });
    }

    //adds users to the selected group
    public void addUsers() {
        lMessage.setText("");
        model = (DefaultTreeModel) tree.getModel();
        selectedNode = (DefaultMutableTreeNode) tree
                .getLastSelectedPathComponent();

        if (selectedNode != null) {
            if (!tfUserID.getText().trim().equals("")) {
                if (selectedNode.getUserObject() instanceof UserGroup) {
                    System.out.println(groups);
                    for (int i = 0; i < users.size(); ++i) {
                        if (users.get(i).getId()
                                .equalsIgnoreCase(tfUserID.getText())) {
                            lMessage.setText("Please enter a unique id");
                            return;
                        }
                    }

                    for (int i = 0; i < groups.size(); ++i) {
                        if (groups.get(i).getId()
                                .equalsIgnoreCase(tfUserID.getText())) {
                            lMessage.setText("Please enter a unique id");
                            return;
                        }
                    }

                    users.add(new SingleUser(tfUserID.getText()));
                    addUser = new DefaultMutableTreeNode(
                            users.get(users.size() - 1));
                    model.insertNodeInto(addUser, selectedNode,
                            selectedNode.getChildCount());
                    tfUserID.setText("");
                    model.reload();
                } else if (selectedNode.getUserObject() instanceof SingleUser) {
                    lMessage.setText("User cannot be a parent");
                }
            }
        } else {
            lMessage.setText("Please enter a valid User ID");
        }
    }
    
    // adds group to the root group
    public void addGroups() {
        lMessage.setText("");
        model = (DefaultTreeModel) tree.getModel();
        selectedNode = (DefaultMutableTreeNode) tree
                .getLastSelectedPathComponent();
        if (selectedNode != null) {
            if (tfGroupID.getText().trim().equals("") == false) {
                if (selectedNode.getUserObject() instanceof SingleUser) {
                    lMessage.setText("A user cannot be parent");
                } else if (selectedNode.getUserObject() instanceof UserGroup) {
                    for (int i = 0; i < users.size(); ++i) {
                        if (users.get(i).toString()
                                .equalsIgnoreCase(tfGroupID.getText())) {
                            lMessage.setText("Please enter a unique id");
                            return;
                        }
                    }

                    for (int i = 0; i < groups.size(); ++i) {
                        if (groups.get(i).getId()
                                .equalsIgnoreCase(tfGroupID.getText())) {
                            lMessage.setText("Please enter a unique id");
                            return;
                        }
                    }
                    groups.add(new UserGroup(tfGroupID.getText()));
                    System.out.println("\n" + groups.get(groups.size() - 1)); // TESTING
                    addGroup = new DefaultMutableTreeNode(groups.get(groups
                            .size() - 1));
                    model.insertNodeInto(addGroup, selectedNode,
                            selectedNode.getChildCount());
                    tfGroupID.setText("");
                }
            } else {
                lMessage.setText("You must enter a Group ID");
            }
        } else {
            lMessage.setText("You must choose a parent node to insert");
        }
    }

    // if a user is selected and the open user view button is pressed a 
    // UserViewPanel will be opened
    public void openView() {
        selectedNode = (DefaultMutableTreeNode) tree
                .getLastSelectedPathComponent();

        if (selectedNode == null) {

            lMessage.setText("Select a user");

        } else if (selectedNode.getUserObject() instanceof SingleUser) {
            User selectedUser = (SingleUser) selectedNode.getUserObject();

            UserViewPanel.getInstance(selectedUser);
        } else if (selectedNode.getUserObject() instanceof UserGroup) {
            lMessage.setText("Select an User ID. Not a group");
        }
    }
    
    //returns the list of users in the system
    public List<User> getUsers() {
        return users;
    }
    
    //returns the list of groups in the system
    public List<User> getGroups() {
        return groups;
    }

    //returns the instance of the control panel
    public static AdminControlPanel getInstance() {
        if (instance == null) {
            instance = new AdminControlPanel();
        }
        return instance;
    }
}
