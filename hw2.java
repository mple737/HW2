import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myApp extends JFrame implements ActionListener {
   
    //initlized hte textfield, label, panel, button
    private JTextField bioData, mathData, statData, engData;
    private JLabel avgLabel, bioLabel, mathLabel, statLabel, engLabel;
    private JPanel bioPanel, mathPanel, statPanel, engPanel, avgPanel, calcPanel, 
                   panelToLeft, panelInMiddle, panelToRight;
    private JButton aButton;

    public myApp(String title) {
        super(title);

        //initlizae the input field for the 4 subjects grade
        //also the label with the correct size so it can looks neats
        bioLabel = new JLabel("BIO:");
        bioData = new JTextField(10);
        bioLabel.setPreferredSize(new Dimension(50, 15));
        
        mathLabel = new JLabel("MATH:");
        mathData = new JTextField(10);
        mathLabel.setPreferredSize(new Dimension(50, 15));
        
        statLabel = new JLabel("STAT:");
        statData = new JTextField(10);
        statLabel.setPreferredSize(new Dimension(50, 15));
        
        engLabel = new JLabel("ENG:");
        engData = new JTextField(10);
        engLabel.setPreferredSize(new Dimension(50, 15));
        
        avgLabel = new JLabel("Average: ");

        //initialize the panels
        //set the layouts and add components or button
        bioPanel = new JPanel();
        bioPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        bioPanel.add(bioLabel);
        bioPanel.add(bioData);

        mathPanel = new JPanel();
        mathPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        mathPanel.add(mathLabel);
        mathPanel.add(mathData);

        statPanel = new JPanel();
        statPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        statPanel.add(statLabel);
        statPanel.add(statData);

        engPanel = new JPanel();
        engPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        engPanel.add(engLabel);
        engPanel.add(engData);

        avgPanel = new JPanel();
        avgPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        avgPanel.add(avgLabel);

        calcPanel = new JPanel();
        calcPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //add calculate button
        
        aButton = new JButton("Calculate");
        
        //set action command
        aButton.setActionCommand("button1");

        //add action listener
        aButton.addActionListener(this);
        calcPanel.add(aButton);

        //create left middle and right panels
        panelToLeft = new JPanel();
        panelToLeft.setLayout(new BoxLayout(panelToLeft, BoxLayout.Y_AXIS));
        panelToLeft.add(bioPanel);
        panelToLeft.add(mathPanel);

        panelInMiddle = new JPanel();
        panelInMiddle.setLayout(new BoxLayout(panelInMiddle, BoxLayout.Y_AXIS));
        panelInMiddle.add(statPanel);
        panelInMiddle.add(engPanel);

        panelToRight = new JPanel();
        panelToRight.setLayout(new BoxLayout(panelToRight, BoxLayout.Y_AXIS));
        panelToRight.add(avgPanel);
        panelToRight.add(calcPanel);

        //add left middle right compoents
        add(panelToLeft);
        add(panelInMiddle);
        add(panelToRight);

    }
    //action performed function
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            //getting the user input
            double bioClass = Double.parseDouble(bioData.getText());
            double mathClass = Double.parseDouble(mathData.getText());
            double statClass = Double.parseDouble(statData.getText());
            double engClass = Double.parseDouble(engData.getText());

            double averageGrade = (bioClass + mathClass + statClass + engClass) / 4;
            avgLabel.setText("Average: " + String.format("%.4f", averageGrade));
       
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Wrong input value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //main functions
    public static void main(String[] args) {
    
        myApp frame = new myApp("Layout Box Alignment HW 2");

        //set the default size of the main window to 250x250 pixels
        frame.setSize(250, 250);

        //close when user choose X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //help with resizing the frame
        frame.setLayout(new FlowLayout()); 
        frame.setVisible(true);
     
    }
}