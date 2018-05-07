package GUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
/**
 *  
 *@author Alex Holm
 *
 **/
public class GUI extends JFrame implements Observer {
	
	/**
	 * I Have no idea what I've done but this is a generated serial 
	 * instead of a default
	**/
	private static final long serialVersionUID = 4465181114406422996L;
	
	public static final int WIDTH = 400;

	public static final int HEIGHT = 300;

	
	public GUI() {
        super("Title");
        loadLayout();
	}
	
	//this is to initialize components
	
	private void initComponents() {
		JFrame mainFrame = new JFrame();
		JTabbedPane pane = new JTabbedPane();
		//Store Variables
		JPanel storeTab = new JPanel(); 
		//Inventory Varibles
	    JPanel inventoryTab  = new JPanel();
	    JTable inventoryTable = new JTable();
	    //Document Variables
	    JPanel documentTab = new JPanel();
	    JTextArea propertiesTextArea = new JTextArea(1, 20);
	    JTextArea manifestTextArea = new JTextArea(1, 20);
	    JTextArea salesTextArea = new JTextArea(1, 20);
	    JFileChooser propertiesChooser = new JFileChooser();
	    JFileChooser manifestChooser = new JFileChooser();
	    JFileChooser salesChooser = new JFileChooser();
	    JButton propertiesButton = new JButton("Properties");
	    JButton manifestButton = new JButton("Manifest");
	    JButton salesButton = new JButton("Sales");

		mainFrame = new JFrame("Title");
		
		mainFrame.setSize(WIDTH, HEIGHT);
		
		mainFrame.setLayout(new GridBagLayout());
		
		mainFrame.add(pane);
		

        pane.add("Store", storeTab);
        storeTab.add(new JLabel("Tab 1"));
		
        pane.add("Inventory", inventoryTab);
        inventoryTab.add(new JLabel("Tab 2"));
        
        pane.add("Documents", documentTab);
        documentTab.setLayout(new GridBagLayout());
        GridBagConstraints docuTabLayout = new GridBagConstraints();
        docuTabLayout.fill = GridBagConstraints.HORIZONTAL;
        docuTabLayout.anchor = GridBagConstraints.WEST;
        docuTabLayout.gridy = 0;
        
        //Make properties Text area and button to open file chooser
        docuTabLayout.gridx = 0;
        documentTab.add(propertiesTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(propertiesButton, docuTabLayout);
        
        docuTabLayout.gridy = 1;
        
        docuTabLayout.gridx = 0;
        documentTab.add(propertiesTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(propertiesButton, docuTabLayout);
        
        docuTabLayout.gridy = 2;
        
        docuTabLayout.gridx = 0;
        documentTab.add(manifestTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(manifestButton, docuTabLayout);
        
        docuTabLayout.gridy = 3;
        
        docuTabLayout.gridx = 0;
        documentTab.add(salesTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(salesButton, docuTabLayout);
        
        
        documentTab.add(salesButton, docuTabLayout);
        getContentPane().add(pane);
        
		
	}
	
	private void loadLayout() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setPreferredSize(new Dimension(400, 300));
        setLocation(new Point(100, 100));
        pack();
        setVisible(true);
        
/*        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if(returnVal==JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        String filename = file.getAbsolutePath();
        } else if(returnVal==JFileChooser.CANCEL_OPTION) {
        }*/
    }
	
	  public static void main(String[] args) {
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        new GUI();
	    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	}

