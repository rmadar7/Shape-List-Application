// Coded by: Ryan Madar
// Date: 12/09/2014
// Assignment #5
// Purpose: A GUI system attached to former assignment 4 which was a list of shapes that the user can add to and display
// 
// Class: The ShapeApp class is used as the driver class as well as the class to contain the gui system. Upon completion, I noticed a few changes I thought I could
// 			make but I am overall happy with how it came out. 

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeApp {
	ArrayList<Shape> shapeList = new ArrayList<> (); // I created all of my instance variables for the gui system here and it lets me manipulate them inside different sections of code
	JFrame frame;
	GridLayout grid;
	JPanel panel, nPanel,wPanel,ePanel,sPanel;
	JLabel label1;
	JButton choice1, choice2, choice3, choice4, choice5, choice6;
	JButton	circle,square,rectangle,triangle,parallelogram,sphere,cylinder,cone,cube,prism,pyramid,goBack;
	ImageIcon img;
	
	public ShapeApp(){ // I create the basis for the frame here as well as the Panels, I manipulate them later.
		img = new ImageIcon("src/shapes.png");
		frame = new JFrame("Shape Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(img.getImage());
		panel = new JPanel();
		nPanel = new JPanel();
		ePanel = new JPanel();
		wPanel = new JPanel();
		sPanel = new JPanel();
		frame.getContentPane().add(BorderLayout.NORTH, nPanel);
		frame.getContentPane().add(BorderLayout.WEST, wPanel);
		frame.getContentPane().add(BorderLayout.EAST, ePanel);
		frame.getContentPane().add(BorderLayout.SOUTH, sPanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
	}
	
	
	public void mainMenu(){ // I've adjusted this so many times. My main method will give depth to the gui here. We create the size and layout of the main panel and the frame.
							// I did that because I want the size to adjust inside the program, I found it easier to just initialize the sizes here so I can later adjust it with ease
		frame.setSize(350,400);
		grid = new GridLayout(7,1,25,25); // Grid Layout worked best for my buttons
		panel.setLayout(grid);
		frame.setLocationRelativeTo(null);
		
		
		MainMenuButtonHandler bhandler = new MainMenuButtonHandler(); // Gives buttons their actions. I also give meaning to my choice variables
		label1 = new JLabel("Please select an option");
		Font font = new Font("Arial",Font.BOLD,14);
		choice1 = new JButton("Add a shape");
		choice2 = new JButton("Display all shapes");
		choice3 = new JButton("Display all 2D shapes");
		choice4 = new JButton("Display all 3D shapes");
		choice5 = new JButton("Display all specific shape");
		choice6 = new JButton("Exit Program");

		
		
		label1.setFont(new Font("Arial",Font.BOLD,17)); // Font for the label and buttons
		choice1.setFont(font);
		choice2.setFont(font);
		choice3.setFont(font);
		choice4.setFont(font);
		choice5.setFont(font);
		choice6.setFont(font);
		
		choice1.addActionListener(bhandler); // For when buttons get pressed. I have many listeners
		choice2.addActionListener(bhandler);
		choice3.addActionListener(bhandler);
		choice4.addActionListener(bhandler);
		choice5.addActionListener(bhandler);
		choice6.addActionListener(bhandler);
		
		panel.add(label1); // Add them to the panel
		panel.add(choice1);
		panel.add(choice2);
		panel.add(choice3);
		panel.add(choice4);
		panel.add(choice5);
		panel.add(choice6);
	
		panel.validate(); // I had issues with the gui not appearing the buttons until I re-adjusted size. I don't know how this reacts on other systems, but it made it work
		panel.setVisible(true); // Validating worked sometimes, setVisible worked sometimes, but together worked perfectly here. 
								// I decided that when I switch to my other windows, I'll set visible to true after the panel and buttons are formed
		
		
	}
	
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to the Shape Application by Ryan Madar!\nWith this application, you can create a list of shapes.\n\nRight now, you have no shapes, so click 'Add a Shape' so we can add one!","Welcome to the Shape App!",JOptionPane.INFORMATION_MESSAGE);

		ShapeApp currentApp = new ShapeApp(); // Initializes the particular app
		currentApp.mainMenu(); // Start em up!
	
	
	}
	
	
	public class MainMenuCreateButtonHandler implements ActionListener{ // This is for the back button in the Add Shape and Specific Shape buttons
		@Override
		public void actionPerformed(ActionEvent e){
			panel.setVisible(false); // Shut off the panel, and main menu will start it back up
			panel.remove(label1);
			panel.remove(circle);
			panel.remove(square);
			panel.remove(rectangle);
			panel.remove(triangle);
			panel.remove(parallelogram);
			panel.remove(sphere);
			panel.remove(cylinder);
			panel.remove(cone);
			panel.remove(cube);
			panel.remove(prism);
			panel.remove(pyramid);
			panel.remove(goBack);
			mainMenu();
		}
	}
	
	
	public class MainMenuButtonHandler implements ActionListener{ // The main menu's buttons utilize this handler
		@Override
		public void actionPerformed(ActionEvent e){
			panel.remove(label1);
			panel.remove(choice1);
			panel.remove(choice2);
			panel.remove(choice3);
			panel.remove(choice4);
			panel.remove(choice5);
			panel.remove(choice6);
			
			
			
			String actionDecision = e.getActionCommand(); // Compare strings. Worked well, but I think there's an easier way to utilize this.
			switch(actionDecision){ // The reason why I didn't just do panel.setVisible before the switch statement is because I wanted it after the methods in displaying shapes
			case "Add a shape":
				panel.setVisible(false);
				selectShape(1);
				break;
			case "Display all shapes":
				displayAllShape();
				panel.setVisible(false);
				mainMenu();
				break;
			case "Display all 2D shapes":
				displayAll2D();
				panel.setVisible(false);
				mainMenu();
				break;
			case "Display all 3D shapes":
				displayAll3D();
				panel.setVisible(false);
				mainMenu();
				break;
			case "Display all specific shape":
				panel.setVisible(false);
				selectShape(0);
				break;
			case "Exit Program":
				System.exit(0);
				break;
			}
			
		}
	}
	
	
	public class DisplayShape implements ActionListener{ // This looks complicated but it really isn't. Just a switch statement that checks for all of a specific shape, then displays
														// A message dialog. I use found to tell us if we find nothing, as well as to give us which shape number we're at
		@Override
		public void actionPerformed(ActionEvent e){
			int found = 0;
			String shapeDecision = e.getActionCommand();
			switch(shapeDecision){
			case "Circle":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Circle.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
			
			case "Square":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Square.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Rectangle":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Rectangle.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
			
			case "Triangle":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Triangle.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
			
			case "Parallelogram":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Paralellogram.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Sphere":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Sphere.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Cylinder":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Cylinder.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Cone":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Cone.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Cube":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Cube.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Prism":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Prism.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
				
			case "Pyramid":
				for (int count = 0; count < shapeList.size(); count++){
					boolean isShape = Pyramid.class.isInstance(shapeList.get(count));
					if (isShape){
						found++;
						JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
					}
				}
				break;
			}
			if (found == 0){
				JOptionPane.showMessageDialog(null, "Sorry, your list contains no " + shapeDecision + " shapes", shapeDecision + " shapes", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
 	public class AddShapeButtonHandler implements ActionListener { // This is for when we add a shape, Same thing as my old code, just turned into input dialogs and message dialogs
 																	// I also found it very simple to implement. Easier than before, atleast.
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double side1, side2, side3, side4;
			String shapeDecision = e.getActionCommand();
			JOptionPane.showMessageDialog(null, "Okay, let's add a " + shapeDecision, shapeDecision, JOptionPane.PLAIN_MESSAGE);
			
			try{
				switch(shapeDecision){
				case "Circle":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a radius", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape circle = new Circle(side1, "Circle");
					shapeList.add(circle);
					JOptionPane.showMessageDialog(null, circle.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
			
				case "Square":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a side", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape square = new Square(side1, "Square");
					shapeList.add(square);
					JOptionPane.showMessageDialog(null, square.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Rectangle":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter side one", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter side two", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape rectangle = new Rectangle(side1, side2, "Rectangle");
					shapeList.add(rectangle);
					JOptionPane.showMessageDialog(null, rectangle.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
			
				case "Triangle":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the base", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter side one", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter side two", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side4 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape triangle = new Triangle(side1,side4,side2,side3, "Triangle");
					shapeList.add(triangle);
					JOptionPane.showMessageDialog(null, triangle.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
			
				case "Parallelogram":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the base", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the side", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape parallelogram = new Paralellogram(side3,side1,side2, "Paralellogram");
					shapeList.add(parallelogram);
					JOptionPane.showMessageDialog(null, parallelogram.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Sphere":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the radius", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape sphere = new Sphere(side1, "Sphere");
					shapeList.add(sphere);
					JOptionPane.showMessageDialog(null, sphere.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Cylinder":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the radius", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape cylinder = new Cylinder(side1,side2, "Cylinder");
					shapeList.add(cylinder);
					JOptionPane.showMessageDialog(null, cylinder.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Cone":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the radius", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape cone = new Cone(side1,side2, "Cone");
					shapeList.add(cone);
					JOptionPane.showMessageDialog(null, cone.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Cube":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the length of the sides", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape cube = new Cube(side1, "Cube");
					shapeList.add(cube);
					JOptionPane.showMessageDialog(null, cube.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Triangular Prism":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the area of the base", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the perimeter of the base", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape prism = new Prism(side1,side2,side3, "Prism");
					shapeList.add(prism);
					JOptionPane.showMessageDialog(null, prism.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				
				case "Pyramid":
					side1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the base", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					side2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the height", shapeDecision, JOptionPane.PLAIN_MESSAGE));
					Shape pyramid = new Pyramid(side1,side2, "Pyramid");
					shapeList.add(pyramid);
					JOptionPane.showMessageDialog(null, pyramid.getInformation(), shapeDecision, JOptionPane.PLAIN_MESSAGE);
					break;
				}
			}catch(NumberFormatException error){
				JOptionPane.showMessageDialog(null, "Whoops! That wasn't a number!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	public void selectShape(int choice){ // I initially only used this to add a shape, but decided I could make better use of my code to re-use it.
										// I decided to have an int given to the method to help it decide whether or not it will add a shape, or just select a shape to display

		frame.setSize(350,750); // Readjust the size of the frame and grid to allow for more buttons.
		grid = new GridLayout(13,1,25,25);
		panel.setLayout(grid);
		frame.setLocationRelativeTo(null); // Set the frame back to center
		
		AddShapeButtonHandler bhandler = new AddShapeButtonHandler();
		DisplayShape displayhandler = new DisplayShape();
		MainMenuCreateButtonHandler mmhandler = new MainMenuCreateButtonHandler();
		label1 = new JLabel("Which shape would you like to add?");
		label1.setFont(new Font("Arial",Font.BOLD,17));
		Font font = new Font("Arial",Font.BOLD,14);
		panel.add(label1);
		
		
		circle = new JButton("Circle");
		circle.setFont(font);
		panel.add(circle);
		
		square = new JButton("Square");
		square.setFont(font);
		panel.add(square);
		
		rectangle = new JButton("Rectangle");
		rectangle.setFont(font);
		panel.add(rectangle);
		
		triangle = new JButton("Triangle");
		triangle.setFont(font);
		panel.add(triangle);
		
		parallelogram = new JButton("Parallelogram");
		parallelogram.setFont(font);
		panel.add(parallelogram);
		
		sphere = new JButton("Sphere");
		sphere.setFont(font);
		panel.add(sphere);
		
		cylinder = new JButton("Cylinder");
		cylinder.setFont(font);
		panel.add(cylinder);
		
		cone = new JButton("Cone");
		cone.setFont(font);
		panel.add(cone);
		
		cube = new JButton("Cube");
		cube.setFont(font);
		panel.add(cube);
		
		prism = new JButton("Triangular Prism");
		prism.setFont(font);
		panel.add(prism);
		
		pyramid = new JButton("Square Pyramid");
		pyramid.setFont(font);
		panel.add(pyramid);
		
		goBack = new JButton("Return to Main Menu");
		goBack.setFont(font);
		panel.add(goBack);
		
		
		if (choice == 1){ // Choice 1 is when we add a shape to our list
			circle.addActionListener(bhandler);
			square.addActionListener(bhandler);
			rectangle.addActionListener(bhandler);
			triangle.addActionListener(bhandler);
			parallelogram.addActionListener(bhandler);
			sphere.addActionListener(bhandler);
			cylinder.addActionListener(bhandler);
			cone.addActionListener(bhandler);
			cube.addActionListener(bhandler);
			prism.addActionListener(bhandler);
			pyramid.addActionListener(bhandler);
		}else if (choice == 0){ // Choice 0 is for when we just want to display a shape type
			circle.addActionListener(displayhandler);
			square.addActionListener(displayhandler);
			rectangle.addActionListener(displayhandler);
			triangle.addActionListener(displayhandler);
			parallelogram.addActionListener(displayhandler);
			sphere.addActionListener(displayhandler);
			cylinder.addActionListener(displayhandler);
			cone.addActionListener(displayhandler);
			cube.addActionListener(displayhandler);
			prism.addActionListener(displayhandler);
			pyramid.addActionListener(displayhandler);
		}
		
		
		goBack.addActionListener(mmhandler);
		panel.setVisible(true);
		
	}
	
	
	public void displayAllShape(){ // Took me a while to decide on how I was going to output my shapes. I finally decided on MessageDialog to do it. I thought
									// This was kind of bulky and annoying. But after implementing I thought it worked best this way. I'm happy with how it came out.
			if (shapeList.isEmpty()){
				JOptionPane.showMessageDialog(null,"Sorry, there are no shapes in your list","DisplayAllShapes", JOptionPane.ERROR_MESSAGE);
			}else{
				for(int count = 0; count < shapeList.size(); count++){
					JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + (count+1), JOptionPane.PLAIN_MESSAGE);
					// I changed the name of the method we call to getInformation because I adjusted the way we find the information.
					// We now, instead of displaying information from the dimensionalshape classes, we just get information from it and display it from here.
				}
			}	
	}
	
	
	public void displayAll2D(){ // 2D and 3D are the same as displayAllShape, I just check isInstance for the class comparison like last time.
								// I also added a way to check for a lack of shapes, something I decided to ignore last time.
		int found = 0;
		for (int count = 0; count < shapeList.size(); count++){
			boolean is2D = TwoDimensionalShape.class.isInstance(shapeList.get(count));
			if (is2D){
				found++;
				JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
			}	
		}
		if (found == 0){
			JOptionPane.showMessageDialog(null, "Sorry, there are no 2D shapes in your list", "2D Shapes", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public void displayAll3D(){ // Read comments for displayAll2D. Nearly identical
		int found = 0;
		for (int count = 0; count < shapeList.size(); count++){
			boolean is3D = ThreeDimensionalShape.class.isInstance(shapeList.get(count));
			if (is3D){
				found++;
				JOptionPane.showMessageDialog(null, shapeList.get(count).getInformation(), "Shape #" + found, JOptionPane.PLAIN_MESSAGE);
			}
		}
		if (found == 0){
			JOptionPane.showMessageDialog(null, "Sorry, there are no 3D shapes in your list", "3D Shapes", JOptionPane.ERROR_MESSAGE);
		}
	}
}
