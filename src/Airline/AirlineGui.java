package Airline;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Toolkit;
import java.awt.Font;

public class AirlineGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField = null;
	private JTextField textField_1=null;
	private JTextField textField_2=null;
	private JTextField textField_3=null;
	private JTextField textField_cost=null;
	String seatPos="";
	String bookField="";

	
	AirlineBookingController ac = new AirlineBookingController();
//	FoodList foodList = new FoodList();
	public static Map<String, JComponent> objs = new HashMap<String,JComponent>();
	private int mealPrice=0;
	
	public JComponent createLabel(String s1, int x, int y, int w, int h){
		
		JLabel lbl = new JLabel(s1);	
		lbl.setBounds(x, y, w, h);
	    return lbl;
	}
	
	
	 ArrayList<String> arrSeat;
	 ArrayList<String> arrFlight;
	 HashMap<FoodItem,CabinClass>arrFood;
	 private JTextField textField_profit;
	 
	public AirlineGui() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AirlineGui.class.getResource("/resourses/plane.png")));
		setLocation(0, -15);
				
		setTitle("Air Crash ");
		   
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton btnBooking = new JButton("Add booking");
		btnBooking.setBackground(new Color(50, 205, 50));
		//Add booking button
		btnBooking.setPreferredSize(new Dimension(50,50));
		getContentPane().add(btnBooking, BorderLayout.SOUTH);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Booking info textfield
		JTextPane bookingInfo = new JTextPane();
		bookingInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane scrollBook = new JScrollPane(bookingInfo);
		bookingInfo.setEditable(false);
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.LIGHT_GRAY);
		panelNorth.add(scrollBook);
		bookingInfo.setPreferredSize(new Dimension(600,50));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JComboBox<String> comboSeat = new JComboBox<>();
		JComboBox<String> comboFlight = new JComboBox<>();
	    JComboBox<CabinClass> comboCabin = new JComboBox<>();
	    JComboBox<String> comboFood = new JComboBox<>();
	    DefaultComboBoxModel<String> modelSeat = (DefaultComboBoxModel<String>) comboSeat.getModel();
	    DefaultComboBoxModel<String> modelFlight = (DefaultComboBoxModel<String>) comboFlight.getModel();
	    DefaultComboBoxModel<String> modelFood = (DefaultComboBoxModel<String>) comboFood.getModel();
	    DefaultComboBoxModel<String> modelCabin = (DefaultComboBoxModel) comboCabin.getModel();
				
		
		
		objs.put("lblName", createLabel("name:", 120, 80, 95, 20));
		objs.put("lblAge", createLabel("Age:", 120, 110, 95, 20));
		objs.put("lblPnumber", createLabel("Pnumber:", 120, 140, 95, 20));
		objs.put("lblSocialNumber", createLabel("Social number:", 120, 170, 95, 20));
		objs.put("lblFlight", createLabel("Flight:", 120, 200, 95, 20));
		objs.put("lblCabinclass", createLabel("cabinclass:", 120, 230, 95, 20));
		objs.put("lblSeat", createLabel("Seat:", 120, 260, 95, 20));
		objs.put("lblFood", createLabel("Food:", 120, 290, 95, 20));
		objs.put("lblCost", createLabel("Your total coast :", 120, 320, 140, 20));
		
		
		Iterator<Entry<String, JComponent>> iter = objs.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, JComponent> thisEntry = (Entry<String, JComponent>) iter.next();
			JLabel value = (JLabel)thisEntry.getValue();
			
			panel.add(value);
		}
			
		
		textField = new JTextField();
		textField.setBounds(233, 80, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 110, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 140, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_cost = new JTextField();
		textField_cost.setText("0");
		textField_cost.setEditable(false);
		textField_cost.setBackground(Color.LIGHT_GRAY);
		textField_cost.setBounds(233, 320, 96, 20);
		panel.add(textField_cost);
		textField_cost.setColumns(10);
		
		
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);     
        
        
        textField_3 = new JTextField();
        textField_3.setBounds(233, 170, 96, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        

        
        modelFlight.addElement(null);
        for(Aircraft ac:AirlineBookingController.aircraftsList){
        	modelFlight.addElement(ac.getName());
        }
        comboCabin.addItem(null);
        comboFlight.setBounds(233, 200, 96, 20);
        panel.add(comboFlight);
        
        
        comboCabin.setBounds(233, 230, 96, 20);
        
//        for (CabinClass c : CabinClass.values()){
//        	comboCabin.addItem(c);
//        	
//        }
        comboCabin.addItem(CabinClass.ECONOMY);
        comboCabin.addItem(CabinClass.FIRST);
          
        panel.add(comboCabin);      
        comboSeat.setBounds(233, 260, 96, 20);
       
//		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
//	        arrSeat = ac.getSeatFromAircraft(comboFlight.getSelectedItem().toString(), comboCabin.getSelectedItem().toString());
//	        System.out.println("Arr : "+arrSeat.size());
//        }
		
		
		
		
		
		
		/**
		 * ActionListener comboFlight
		 * 
		 */
        comboFlight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelSeat.removeAllElements();
        		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
					arrSeat = ac.getSeatFromAircraft(comboFlight.getSelectedItem().toString(), comboCabin.getSelectedItem().toString());
					for(String item:arrSeat){
						modelSeat.addElement(item);
					}
				}
				comboSeat.revalidate();			
			
			}
		});
        
        /**
         * Listener for comboCabin
         * 
         */
        comboCabin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		modelSeat.removeAllElements();

        		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
					arrSeat = ac.getSeatFromAircraft(comboFlight.getSelectedItem().toString(), comboCabin.getSelectedItem().toString());
					for(String item:arrSeat){
						modelSeat.addElement(item);						
					}					
        		}
        		
        		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
            		modelFood.removeAllElements();

        			arrFood = ac.getFoodItemsList(comboCabin.getSelectedItem().toString());      		
					Iterator<FoodItem> iter = arrFood.keySet().iterator();
					modelFood.addElement(null);
					while(iter.hasNext()){

						FoodItem fi = (FoodItem) iter.next();
						modelFood.addElement(fi.getFoodName()+" "+fi.getPrice()+"");
					}

					if(comboCabin.getSelectedItem()!=null){
		        		int flightPrice= ac.getCabinPrice(comboCabin.getSelectedItem().toString());
		        		textField_cost.setText(""+flightPrice);
		        		}
				}
        		
        	}
        });
        /**
         * ActionListener comboFood
         * 
         */
        comboFood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
					int price =1;			
					int flightPrice = ac.getCabinPrice(comboCabin.getSelectedItem().toString());
     			
					mealPrice = ac.getFoodPrice(""+comboFood.getSelectedItem(), comboCabin.getSelectedItem().toString());
					price = ac.getFoodPrice(""+comboFood.getSelectedItem(), comboCabin.getSelectedItem().toString());


					textField_cost.setText(""+(flightPrice+mealPrice));
					textField_cost.setText(""+(flightPrice+price));
				}
				
			}
		});
        

        /**
         * ActionListener comboSeat
         * 
         */
        comboSeat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        
        panel.add(comboSeat);
        
        comboFood.setBounds(233, 291, 341, 20);
        panel.add(comboFood);
        
        
        JPanel panelEast = new JPanel();
        panelEast.setBounds(615, 11, 159, 449);
        panel.add(panelEast);
        panelEast.setLayout(null);
        JLabel balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(5, 8, 47, 14);
        panelEast.add(balanceLabel);
        JTextField balanceInfo = new JTextField();
        balanceInfo.setBounds(62, 5, 87, 20);
        balanceInfo.setBackground(Color.LIGHT_GRAY);
        balanceInfo.setText("");
        panelEast.add(balanceInfo);
        panelEast.setBackground(Color.LIGHT_GRAY);
        balanceInfo.setPreferredSize(new Dimension(50,20));
        balanceInfo.setEditable(false);
        
        JLabel lblProfit = new JLabel("Profit");
        lblProfit.setBounds(5, 45, 46, 14);
        panelEast.add(lblProfit);
        
        textField_profit = new JTextField();
        textField_profit.setBackground(Color.LIGHT_GRAY);
        textField_profit.setBounds(62, 42, 87, 20);
        panelEast.add(textField_profit);
        textField_profit.setColumns(10);
        this.setSize(800, 600);

        
        
        
        
        
        
        btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//comboSeat.removeItem(seatPos);
				comboSeat.repaint();
				//Check all fields all filled in
				if(convertStringtoInt(textField_1.getText())!=0 && comboSeat.getSelectedItem()!=null && !textField.getText().isEmpty() && 
						!textField_1.getText().isEmpty() && !textField_2.getText().isEmpty() && !textField_3.getText().isEmpty()){
					
					int seatNr = convertStringtoInt(comboSeat.getSelectedItem().toString());
					String food = "";
					if(comboFood.getSelectedItem()==null)
						food = "No food selected";
					else
						food = comboFood.getSelectedItem().toString();
					ac.addBooking(
							textField.getText(),
							convertStringtoInt(textField_1.getText()),
							textField_2.getText(),
							textField_3.getText(),
							comboFlight.getSelectedItem().toString(),
							comboCabin.getSelectedItem().toString(),
							convertStringtoInt(comboSeat.getSelectedItem().toString()),
							food,mealPrice
	
							
							);
					
					 
					
					//Adding info to upper bar
	        		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
						bookField = (""+bookField+textField.getText()+ "\t " +
								convertStringtoInt(textField_1.getText())+ " " +
								textField_2.getText()+ " " +
								textField_3.getText()+ " " + 
								comboFlight.getSelectedItem().toString()+ " " + 
								comboCabin.getSelectedItem().toString()+ " " + 
								convertStringtoInt(comboSeat.getSelectedItem().toString())+
								"\n");
						
					bookingInfo.setText(bookField);	
					
	
					}
					
				
				
				}
				else
					errorMessage();
				modelSeat.removeAllElements();
        		if(comboFlight.getSelectedItem()!=null && comboCabin.getSelectedItem()!=null) {
				arrSeat = ac.getSeatFromAircraft(comboFlight.getSelectedItem().toString(), comboCabin.getSelectedItem().toString());
				for(String item:arrSeat){
					modelSeat.addElement(item);
				}
				}
				comboFlight.setSelectedIndex(0);
				comboCabin.setSelectedIndex(0);
				mealPrice=0;
				textField_cost.setText("");
				comboSeat.revalidate();	
				System.out.println("ac :"+ac.getBalance()+" : "+mealPrice);
				balanceInfo.setText(""+ac.getBalance());
				textField_profit.setText(""+(ac.getBalance()*0.3));
				

			}
		
		});
        //Display the window.
		
        this.update(this.getGraphics());
        this.setVisible(true);
		
		
	}
	
	public void errorMessage(){
		JOptionPane.showMessageDialog(null, "Not sufficient information");
	}
	
	
	
	public int convertStringtoInt(String str){
		
		try{
			return Integer.parseInt(str);
		}catch(NumberFormatException e){System.out.println("Illegal values in field :" + str+":");return 0;}
		
	}
}
