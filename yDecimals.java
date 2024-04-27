import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


/////////////////////////////////////////////////////////////////////////////////////////
//FUTURE IMPLEMENTATION TO PROJECT. ALLOW USERS TO ENTER DIFFERENT TYPES OF COORDINATES//
/////////////////////////////////////////////////////////////////////////////////////////


// Other possibilites:

// have a GUI showing fire history within a 100km radius the user inputted

// Find the forest types to get more accurate fire spread speeds

// Make a simulation, using forest types, precipitation, wind, sun/clouds, temperature..
// allowing the user to adjust accordingly and produce their own wild fire




public class yDecimals extends JFrame implements ItemListener, ActionListener {

    JFrame frame;
    JPanel panel, panel1, panel2, panel3, panelDecimals, panelMinutes;
    JCheckBox decimals, minutes;

    private JFrame testFrame = new JFrame("Test Frame");
    private JButton button = new JButton("Click Me");
//    private JPanel panel = new JPanel(new GridLayout(1, 1));
    public yDecimals() {

        // Layout Manager = Defines the natural layout for components within a container

        // FlowLayout = 	places components in a row, sized at their preferred size.
        //					If the horizontal space in the container is too small,
        //					the FlowLayout class uses the next available row.

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // new FlowLayout(FlowLayout.LEADING,0,0));  = left
        // new FlowLayout(FlowLayout.TRAILING,0,0));  = right
        // new FlowLayout(FlowLayout.CENTER,10,10)); = space between each button

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 250));
        //         panel.setPreferredSize(new Dimension(100,250));  = skinnier gray box // buttons are more vertical
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

//        panel.add(new JButton("1"));
//        panel.add(new JButton("2"));
//        panel.add(new JButton("3"));
//        panel.add(new JButton("4"));
//        panel.add(new JButton("5"));
//        panel.add(new JButton("6"));
//        panel.add(new JButton("7"));
//        panel.add(new JButton("8"));
//        panel.add(new JButton("9"));

//        frame.add(panel);
//        frame.setVisible(true);
//    }


        // build everything in the global position


        //    public static void test() {
        ButtonGroup coordsGroup;
        JCheckBox decimals, minutes;


        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(250, 250));
        panel1.setBackground(Color.lightGray);
        panel1.setLayout(new FlowLayout());

        panel1.add(new JLabel("T1: Are your coordinates in decimals or degrees/minutes/seconds?"));
        panel1.add(new JLabel("T2: Are your coordinates in decimals or degrees/minutes/seconds?"));


        // Create 2 check boxes for the different size of the pizza. Adding ItemListeners so can tell when selected
        decimals = new JCheckBox("Decimals", false);
        decimals.addItemListener(this);
        minutes = new JCheckBox("Degrees, Minutes, Seconds", false);
        minutes.addItemListener(this);


        // add each to a buttongroup so that only one size can be selected for a single pizza
        coordsGroup = new ButtonGroup();
        coordsGroup.add(decimals);
        coordsGroup.add(minutes);

        JPanel panelTwo = new JPanel();
        panelTwo.setPreferredSize(new Dimension(250, 100));
        panelTwo.setBackground(Color.lightGray);
        panelTwo.setLayout(new FlowLayout());

        panelTwo.add(decimals);
        panelTwo.add(minutes);


        // I dont think the panels need to be set Visible unless only want to make
        // visible once a selection is made...
//        panel1.setVisible(true);
//        panelTwo.setVisible(true);

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 500);
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        frame.add(panel1);
        frame.add(panelTwo);


        // JPanel3 will hold the space for panelDecimals and panelMinutes
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(250, 250));
        panel3.setBackground(Color.lightGray);
        panel3.setLayout(new FlowLayout());

        frame.add(panel3);






        // make an @override
        // if decimals is selected... set.visible(true) for panelDecimals
        // if minutes is selected... set.visible(true) for panelMinutes

        // or follow pizza application and make two global text boxes that are adjusted
        // based on the e.getsource() == decimals

        //panelMinutes and panelDecimals each get their own layout//enter button

        panelMinutes = new JPanel();
        JTextField degreesLong = new JTextField("Degrees: ");
        JTextField minsLong = new JTextField("Minutes: ");
        JTextField secondsLong = new JTextField("Seconds: ");
        JTextField degreesLat = new JTextField("Degrees: ");
        JTextField minsLat = new JTextField("Minutes: ");
        JTextField secondsLat = new JTextField("Seconds: ");


        JButton enterButtonMinutes = new JButton("Locate");
        enterButtonMinutes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Longitude
                String degreesLongText = degreesLong.getText();
                String minsLongText = minsLong.getText();
                String secondsLongText = secondsLong.getText();

                // Latitude
                String degreesLatText = degreesLat.getText();
                String minsLatText = minsLat.getText();
                String secondsLatText = secondsLat.getText();

                try {
                    int degreesLongNum = Integer.parseInt(degreesLongText);
                    int minsLongNum = Integer.parseInt(minsLongText);
                    double secondsLongNum = Double.parseDouble(secondsLongText);

                    int degreesLatNum = Integer.parseInt(degreesLatText);
                    int minsLatNum = Integer.parseInt(minsLatText);
                    double secondsLatNum = Double.parseDouble(secondsLatText);

                    // Handle the numeric value (e.g., display it or perform further actions)
                    System.out.println("Longitude: ");
                    System.out.println("User entered Degrees: " + degreesLongNum);
                    System.out.println("User entered Minutes: " + minsLongNum);
                    System.out.println("User entered Seconds: " + secondsLongNum);

                    System.out.println("Latitude: ");
                    System.out.println("User entered Degrees: " + degreesLatNum);
                    System.out.println("User entered Minutes: " + minsLatNum);
                    System.out.println("User entered Seconds: " + secondsLatNum);

                } catch (NumberFormatException ex) {
                    // Handle invalid input (non-numeric characters)
                    JOptionPane.showMessageDialog(null, "Please enter a valid integers " +
                            "for degrees and minutes. Double or Integer for seconds.");
                }
            }
        });


        panelDecimals = new JPanel();
        JTextField decimalsLong = new JTextField("Longitude: ");
        JTextField decimalsLat = new JTextField("Latitude: ");

        JButton enterButtonDecimals = new JButton("Locate");
        enterButtonDecimals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String decimalsLongText = decimalsLong.getText();
                String decimalsLatText = decimalsLat.getText();

                try {
                    double decimalsLongNum = Double.parseDouble(decimalsLongText);
                    double decimalsLatNum = Double.parseDouble(decimalsLatText);


                    // Handle the numeric value (e.g., display it or perform further actions)
                    System.out.println("User entered Longitude: " + decimalsLongNum + " Latitude: " + decimalsLatNum);

                } catch (NumberFormatException ex) {
                    // Handle invalid input (non-numeric characters)
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer or double.");
                }
            }
        });

        frame.add(enterButtonDecimals);
        frame.add(enterButtonMinutes);
        frame.setVisible(true);


        double age = Double.parseDouble(JOptionPane.showInputDialog("Enter your coordinates"));
        JOptionPane.showMessageDialog(null, "You are in danger");
//    }
    }


    public static void main(String args[]) { new yDecimals(); }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getSource() == decimals) {
//            panel3 = new JPanel();
//            panel3.setPreferredSize(new Dimension(250, 250));
//            panel3.setBackground(Color.lightGray);
//            panel3.setLayout(new FlowLayout());

//            JPanel panelDecimals = new JPanel();
            // make it
            //Itll be the global JTextField is updated and we put the update
            // AKA panelDecimals into this....
//            panelDecimals.setVisible(true);

//            panel3.add(panelDecimals);
            System.out.println("decimal");
            panel3 = panelDecimals;
            frame.add(panel3);
        } else if(e.getSource() == minutes) {
//            panel3 = new JPanel();
//            panel3.setPreferredSize(new Dimension(250, 250));
//            panel3.setBackground(Color.lightGray);
//            panel3.setLayout(new FlowLayout());



//            panel3.add(panelMinutes);
            System.out.println("Minutes");

            panel3 = panelMinutes;
            frame.add(panel3);
        } else {
            System.out.println("Nothing");

            panel.add(button);
            testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            testFrame.add(panel); // Add the panel to the frame
            testFrame.pack();
            testFrame.setLocation(400, 300);
            testFrame.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!e.getActionCommand().isBlank()) {
            e.getActionCommand().stripLeading().stripTrailing();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid entry");
        }

    }
}
