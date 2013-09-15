package com.iConcert;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class iPlatform extends javax.swing.JFrame implements WindowListener,ActionListener{
	private JMenuBar myMenuBar;
	private JPanel effectPanel;
	private JLabel filmLabel;
	private JLabel effectLabel;
	private JLabel setLabel;
	private JPanel setPanel;
	private JPanel filmPanel;
	private JMenuItem recodeStMenuItem;
	private JMenu aboutMenu;
	private JMenu setMenu;
	private iStream stream;
	private JMenuItem recodeCloseMenuItem;
	private JButton jButton2;
	private JButton jButton1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				iPlatform inst = new iPlatform();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public iPlatform() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			//thread 取用
			//this
			stream = new iStream();
			//stream.setDaemon(true);
			
			addWindowListener(this);
			//---------------介面--------------------------------------------
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			GridBagLayout myGridBagLayout = new GridBagLayout();
			this.setTitle("iConcert");
			myGridBagLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			myGridBagLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			myGridBagLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
			myGridBagLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			getContentPane().setLayout(myGridBagLayout);
			{
				filmPanel = new JPanel();
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7};
				jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
				jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7};
				getContentPane().add(filmPanel, new GridBagConstraints(0, 0, 45, 22, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				filmPanel.setLayout(jPanel1Layout);
				filmPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					//webcam 讀取
					//filmLabel = new JLabel();
					filmLabel = stream.getLabelObject();
					//filmLabel.setSize(640, 480);
					filmPanel.add(filmLabel, new GridBagConstraints(1, 1, 6, 6, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					filmLabel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

				}
			}
			{
				setPanel = new JPanel();
				FlowLayout jPanel1Layout = new FlowLayout();
				jPanel1Layout.setAlignment(FlowLayout.LEFT);
				getContentPane().add(setPanel, new GridBagConstraints(0, 23, 21, 8, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				setPanel.setLayout(jPanel1Layout);
				setPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					jButton1 = new JButton();
					setPanel.add(jButton1);
					jButton1.setText("jButton1");
					jButton1.addActionListener(new btaAction());
				}
				{
					jButton2 = new JButton();
					setPanel.add(jButton2);
					jButton2.setText("jButton2");
				}
			}
			{
				effectPanel = new JPanel();
				getContentPane().add(effectPanel, new GridBagConstraints(22, 23, 23, 8, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				effectPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				setLabel = new JLabel();
				getContentPane().add(setLabel, new GridBagConstraints(0, 22, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				setLabel.setText("基本設定");
				setLabel.setFont(new java.awt.Font("微軟正黑體",0,16));
			}
			{
				effectLabel = new JLabel();
				getContentPane().add(effectLabel, new GridBagConstraints(22, 22, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				effectLabel.setText("畫面特效");
				effectLabel.setFont(new java.awt.Font("微軟正黑體",0,16));
			}
			{
				myMenuBar = new JMenuBar();
				setJMenuBar(myMenuBar);
				{
					setMenu = new JMenu();
					myMenuBar.add(setMenu);
					setMenu.setText("設定");
					setMenu.setFont(new java.awt.Font("微軟正黑體",0,16));
					setMenu.setSize(40, 50);
					{
						recodeStMenuItem = new JMenuItem();
						setMenu.add(recodeStMenuItem);
						recodeStMenuItem.setText("開始錄製");
						recodeStMenuItem.addActionListener(new recodeStMenuListener());
						
					}
					{
						recodeCloseMenuItem = new JMenuItem();
						setMenu.add(recodeCloseMenuItem);
						recodeCloseMenuItem.setText("停止錄製");
						recodeCloseMenuItem.addActionListener(new recodeCloseMenuListener());
					}
				}
				{
					aboutMenu = new JMenu();
					myMenuBar.add(aboutMenu);
					aboutMenu.setText("關於");
					aboutMenu.setFont(new java.awt.Font("微軟正黑體",0,16));
					aboutMenu.setSize(49, 50);
				}
			}
			pack();
			this.setSize(1226, 921);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		stream.isRunning = false;
		
		//System.out.print("我停止了");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自動產生的方法 Stub
		
	}
	//-----------------------事件頃聽--------------------------------------
	class recodeStMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!stream.isRunning){
				stream = new iStream(filmLabel);
			}
			stream.start();
		}
	}
	class recodeCloseMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(stream!=null){
				stream.isRunning = false;
				stream.destroy();
			}else{
				
			}
			
		}
	}
	class btaAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			stream.setFilmSize(filmLabel.getWidth(),filmLabel.getHeight());
		}
	}
}//程式尾端
