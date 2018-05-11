package GUI;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
/**
 *  
 *@author Alex Holm
 *
 **/
public class GUI extends JFrame implements Observer, ActionListener
{
	
	/**
	 * I Have no idea what I've done but this is a generated serial 
	 * instead of a default
	**/
	private static final long serialVersionUID = 4465181114406422996L;
	
	public static final int WIDTH = 500;

	public static final int HEIGHT = 300;

	JFrame mainFrame = new JFrame();
	JTabbedPane pane = new JTabbedPane();
	
	//Store Variables
	JPanel storeTab = new JPanel(); 
	
	//Inventory Variables
    JPanel inventoryTab  = new JPanel();
    String[] inventoryColumnNames
    = {"Name", "Cost", "Price", "Reorder Point", "Reorder Amount", "Temperature"};
   
    public Object[][]data
    = {
    		{"Name", "Cost", "Price", "Reorder Point", "Reorder Amount", "Temperature"},
    		};
    JTable inventoryTable = new JTable(data, inventoryColumnNames);
    
    //Document Variables
    JPanel documentTab = new JPanel();
    
    ImageIcon folderIcon = new ImageIcon("images/OpenFolder.png", "Open the File Chooser");
    
    
    //Items for the properties section. With A label, text area, a filechooser
    //icon and buttons
    JLabel propLabel = new JLabel("Item Properties");
    JTextArea propertiesTextArea = new JTextArea(1, 20);
    JFileChooser propertiesChooser = new JFileChooser();
    JButton propertiesChooseButton = new JButton(folderIcon);
    JButton propertiesButton = new JButton("Load");

    JLabel maniLabel = new JLabel("Manifests");
    JTextArea manifestTextArea = new JTextArea(1, 20);
    JFileChooser manifestChooser = new JFileChooser();
    JButton manifestChooseButton = new JButton(folderIcon);
    JButton manifestButton = new JButton("Load");
    
    JLabel exportLabel = new JLabel("Export Manifest");
    JTextArea exportTextArea = new JTextArea(1, 20);
    JFileChooser exportChooser = new JFileChooser();
    JButton exportChooseButton = new JButton(folderIcon);
    JButton exportButton = new JButton("Export");
    
    JLabel salesLabel = new JLabel("Sales Log");
    JTextArea salesTextArea = new JTextArea(1, 20);
    JFileChooser salesChooser = new JFileChooser();
    JButton salesChooseButton = new JButton(folderIcon);
    JButton salesButton = new JButton("Load");
    

    
    
	public GUI() {
        super("Title");
        loadLayout();
	}
	

	//this is to initialize components
	
	private void initComponents() {
		//THis can be directories only but CEEB'd doing that rn
		
		mainFrame = new JFrame("Title");
		mainFrame.setSize(HEIGHT, WIDTH);		
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.add(pane);
		

        pane.add("Store", storeTab);
        storeTab.add(new JLabel("Tab 1"));
		
        pane.add("Inventory", inventoryTab);
        //inventoryTab.add(new JLabel("Please load in item properties"));
        inventoryTab.add(inventoryTable);
        inventoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        pane.add("Documents", documentTab);
        
        propertiesTextArea.setEditable(true);
        exportTextArea.setEditable(true);
        manifestTextArea.setEditable(true);
        salesTextArea.setEditable(true);
        
        //This can change to files only or files and directories but i dunno what was a good choice
        propertiesChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		exportChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		manifestChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		salesChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//Sets the directory of the file choosers to Home
	    propertiesChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    exportChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    manifestChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        salesChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	    //Make properties Text area and button to open file choose
        propertiesChooseButton.addActionListener(this);
        manifestChooseButton.addActionListener(this);
        exportChooseButton.addActionListener(this);
        salesChooseButton.addActionListener(this);
        
        
        documentTab.setLayout(new GridBagLayout());
        GridBagConstraints docuTabLayout = new GridBagConstraints();
        docuTabLayout.fill = GridBagConstraints.HORIZONTAL;
        docuTabLayout.anchor = GridBagConstraints.WEST;

        docuTabLayout.gridy = 0;
        docuTabLayout.gridx = 0;
        documentTab.add(propLabel, docuTabLayout);
        docuTabLayout.gridy = 1;
        documentTab.add(propertiesTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(propertiesChooseButton, docuTabLayout);
        docuTabLayout.gridx = 2;
        documentTab.add(propertiesButton, docuTabLayout);
        
        docuTabLayout.gridy = 2;
        docuTabLayout.gridx = 0;
        documentTab.add(maniLabel, docuTabLayout);
        docuTabLayout.gridy = 3;
        documentTab.add(manifestTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(manifestChooseButton, docuTabLayout);
        docuTabLayout.gridx = 2;
        documentTab.add(manifestButton, docuTabLayout);

        docuTabLayout.gridy = 4;
        docuTabLayout.gridx = 0;
        documentTab.add(exportLabel, docuTabLayout);
        docuTabLayout.gridy = 5;
        documentTab.add(exportTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(exportChooseButton, docuTabLayout);
        docuTabLayout.gridx = 2;
        documentTab.add(exportButton, docuTabLayout);
        
        docuTabLayout.gridy = 6;
        docuTabLayout.gridx = 0;
        documentTab.add(exportLabel, docuTabLayout);
        docuTabLayout.gridy = 7;
        documentTab.add(exportTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(exportChooseButton, docuTabLayout);
        docuTabLayout.gridx = 2;
        documentTab.add(exportButton, docuTabLayout);
        
        docuTabLayout.gridy = 8;
        docuTabLayout.gridx = 0;
        documentTab.add(salesLabel, docuTabLayout);
        docuTabLayout.gridy = 9;
        documentTab.add(salesTextArea, docuTabLayout);
        docuTabLayout.gridx = 1;
        documentTab.add(salesChooseButton, docuTabLayout);
        docuTabLayout.gridx = 2;
        documentTab.add(salesButton, docuTabLayout);
        
        
        
        
        getContentPane().add(pane);
        
	}
	
	private void loadLayout() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == propertiesChooseButton) {
			int returnVal = propertiesChooser.showOpenDialog(GUI.this);

		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = propertiesChooser.getSelectedFile();
		        String filename = file.getAbsolutePath();
		        propertiesTextArea.setText("");
		        propertiesTextArea.append(filename);
		      }
		}
		//this SAVES a file
		else if (e.getSource() == exportChooseButton) {
		      int returnVal = exportChooser.showSaveDialog(GUI.this);
		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = exportChooser.getSelectedFile();
		      }
		}
		else if (e.getSource() == manifestChooseButton) {
			int returnVal = manifestChooser.showOpenDialog(GUI.this);

		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = manifestChooser.getSelectedFile();
		        String filename = file.getAbsolutePath();
		        manifestTextArea.setText("");
		        manifestTextArea.append(filename);
		      }
		}
		else if (e.getSource() == salesChooseButton) {
			int returnVal = salesChooser.showOpenDialog(GUI.this);

		      if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = salesChooser.getSelectedFile();
		        String filename = file.getAbsolutePath();
		        salesTextArea.setText("");
		        salesTextArea.append(filename);
		      }
		}
		

		        //This is where a real application would save the file.
		        /*
		        log.append("Saving: " + file.getName() + "." + newline);
		      } else {
		        log.append("Save command cancelled by user." + newline);
		      }
		      log.setCaretPosition(log.getDocument().getLength());
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

