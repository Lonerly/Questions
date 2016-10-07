import java.awt.EventQueue;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Main extends JFrame {

	private int max = 1000;
	private String filename, directory;
	private int rdm;
	Random rand = new Random();

	private int randomNum = 0;

	private JPanel contentPane;
	private JTextField txtDirectory;

	private String arraytext[] = new String[max];
	private int length = 0;
	private String[] strA = new String[max];
	private String[] strB = new String[max];
	private String[] strC = new String[max];
	private String[] strD = new String[max];
	private int[] intGood = new int[max];
	private final JLabel label_1 = new JLabel("  ");
	private int score = 0;

	public Main() {

		strA[0] = "A";
		strB[0] = "B";
		strC[0] = "C";
		strD[0] = "D";
		intGood[0] = 0;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(153, 204, 51));
		menuBar.setForeground(new Color(0, 153, 51));
		setJMenuBar(menuBar);

		JMenu mnOptions = new JMenu("Options");
		mnOptions.setForeground(new Color(0, 0, 0));
		mnOptions.setBackground(new Color(51, 204, 0));
		menuBar.add(mnOptions);

		txtDirectory = new JTextField();
		txtDirectory.setToolTipText("Directory");
		menuBar.add(txtDirectory);
		txtDirectory.setColumns(10);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 358, 0, 61, 0 };
		gbl_contentPane.rowHeights = new int[] { 60, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblQuestion.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridx = 0;
		gbc_lblQuestion.gridy = 0;
		contentPane.add(lblQuestion, gbc_lblQuestion);

		JLabel lblGoodOrBad = new JLabel("?");
		lblGoodOrBad.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblGoodOrBad.setForeground(new Color(153, 204, 51));
		GridBagConstraints gbc_lblGoodOrBad = new GridBagConstraints();
		gbc_lblGoodOrBad.insets = new Insets(0, 0, 0, 5);
		gbc_lblGoodOrBad.gridx = 0;
		gbc_lblGoodOrBad.gridy = 5;
		contentPane.add(lblGoodOrBad, gbc_lblGoodOrBad);

		JLabel lblScore_1 = new JLabel("Score:");
		lblScore_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblScore_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblScore_1 = new GridBagConstraints();
		gbc_lblScore_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblScore_1.gridx = 1;
		gbc_lblScore_1.gridy = 0;
		contentPane.add(lblScore_1, gbc_lblScore_1);

		JLabel labelScr = new JLabel("0");
		labelScr.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		labelScr.setForeground(new Color(153, 204, 51));
		GridBagConstraints gbc_labelScr = new GridBagConstraints();
		gbc_labelScr.insets = new Insets(0, 0, 5, 0);
		gbc_labelScr.gridx = 2;
		gbc_labelScr.gridy = 0;
		contentPane.add(labelScr, gbc_labelScr);

		JLabel lblAnswera = new JLabel("AnswerA");
		lblAnswera.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblAnswera.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAnswera = new GridBagConstraints();
		gbc_lblAnswera.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswera.gridx = 0;
		gbc_lblAnswera.gridy = 1;
		contentPane.add(lblAnswera, gbc_lblAnswera);

		JLabel lblAnswerb = new JLabel("AnswerB");
		lblAnswerb.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblAnswerb.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAnswerb = new GridBagConstraints();
		gbc_lblAnswerb.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswerb.gridx = 0;
		gbc_lblAnswerb.gridy = 2;
		contentPane.add(lblAnswerb, gbc_lblAnswerb);

		JLabel lblAnswerc = new JLabel("AnswerC");
		lblAnswerc.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblAnswerc.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAnswerc = new GridBagConstraints();
		gbc_lblAnswerc.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswerc.gridx = 0;
		gbc_lblAnswerc.gridy = 3;
		contentPane.add(lblAnswerc, gbc_lblAnswerc);
		
		JLabel lblAnswerd = new JLabel("AnswerD");
		lblAnswerd.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblAnswerd.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblAnswerd = new GridBagConstraints();
		gbc_lblAnswerd.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswerd.gridx = 0;
		gbc_lblAnswerd.gridy = 4;
		contentPane.add(lblAnswerd, gbc_lblAnswerd);

		JLabel lblAmountOfQuestions = new JLabel(" Amount Of Questions: ");
		lblAmountOfQuestions.setForeground(new Color(0, 0, 0));
		menuBar.add(lblAmountOfQuestions);

		JLabel labelAmount = new JLabel("0");
		labelAmount.setForeground(new Color(102, 51, 255));
		menuBar.add(labelAmount);
		
		JButton btnA = new JButton("A");
		btnA.setBackground(new Color(153, 204, 51));
		GridBagConstraints gbc_btnA = new GridBagConstraints();
		gbc_btnA.insets = new Insets(0, 0, 5, 5);
		gbc_btnA.gridx = 1;
		gbc_btnA.gridy = 1;
		contentPane.add(btnA, gbc_btnA);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = randomNum;
				if (intGood[a] == 1) {
					lblGoodOrBad.setText("Good!");
					lblGoodOrBad.setForeground(new Color(0, 255, 0));
					score++;
				} else {
					lblGoodOrBad.setText("Bad!");
					lblGoodOrBad.setForeground(new Color(255, 0, 0));
					score--;
				}
				labelScr.setText(String.valueOf(score));
				randomNum = rand.nextInt(length + 1);
				System.out.println(randomNum);
				lblQuestion.setText(arraytext[randomNum]);
				lblAnswera.setText(strA[randomNum]);
				lblAnswerb.setText(strB[randomNum]);
				lblAnswerc.setText(strC[randomNum]);
				lblAnswerd.setText(strD[randomNum]); 
			}
		});
		
		JButton btnB = new JButton("B");
		btnB.setBackground(new Color(153, 204, 51));
		GridBagConstraints gbc_btnB = new GridBagConstraints();
		gbc_btnB.insets = new Insets(0, 0, 5, 5);
		gbc_btnB.gridx = 1;
		gbc_btnB.gridy = 2;
		contentPane.add(btnB, gbc_btnB);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = randomNum;
				if (intGood[a] == 2) {
					lblGoodOrBad.setText("Good!");
					lblGoodOrBad.setForeground(new Color(0, 255, 0));
					score++;
				} else {
					lblGoodOrBad.setText("Bad!");
					lblGoodOrBad.setForeground(new Color(255, 0, 0));
					score--;
				}
				labelScr.setText(String.valueOf(score));
				randomNum = rand.nextInt(length + 1);
				System.out.println(randomNum);
				lblQuestion.setText(arraytext[randomNum]);
				lblAnswera.setText(strA[randomNum]);
				lblAnswerb.setText(strB[randomNum]);
				lblAnswerc.setText(strC[randomNum]);
				lblAnswerd.setText(strD[randomNum]); 
			}
		});
		
		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(153, 204, 51));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.insets = new Insets(0, 0, 5, 5);
		gbc_btnC.gridx = 1;
		gbc_btnC.gridy = 3;
		contentPane.add(btnC, gbc_btnC);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = randomNum;
				if (intGood[a] == 3) {
					lblGoodOrBad.setText("Good!");
					lblGoodOrBad.setForeground(new Color(0, 255, 0));
					score++;
				} else {
					lblGoodOrBad.setText("Bad!");
					lblGoodOrBad.setForeground(new Color(255, 0, 0));
					score--;
				}
				labelScr.setText(String.valueOf(score));
				randomNum = rand.nextInt(length + 1);
				System.out.println(randomNum);
				lblQuestion.setText(arraytext[randomNum]);
				lblAnswera.setText(strA[randomNum]);
				lblAnswerb.setText(strB[randomNum]);
				lblAnswerc.setText(strC[randomNum]);
				lblAnswerd.setText(strD[randomNum]); 
			}
		});

		JButton btnD = new JButton("D");
		btnD.setBackground(new Color(153, 204, 51));
		GridBagConstraints gbc_btnD = new GridBagConstraints();
		gbc_btnD.insets = new Insets(0, 0, 5, 5);
		gbc_btnD.gridx = 1;
		gbc_btnD.gridy = 4;
		contentPane.add(btnD, gbc_btnD);
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = randomNum;
				if (intGood[a] == 4) {
					lblGoodOrBad.setText("Good!");
					lblGoodOrBad.setForeground(new Color(0, 255, 0));
					score++;
				} else {
					lblGoodOrBad.setText("Bad!");
					lblGoodOrBad.setForeground(new Color(255, 0, 0));
					score--;
				}
				labelScr.setText(String.valueOf(score));
				randomNum = rand.nextInt(length + 1);
				System.out.println(randomNum);
				lblQuestion.setText(arraytext[randomNum]);
				lblAnswera.setText(strA[randomNum]);
				lblAnswerb.setText(strB[randomNum]);
				lblAnswerc.setText(strC[randomNum]);
				lblAnswerd.setText(strD[randomNum]); 
			}
		});

		
		JMenuItem mntmImport = new JMenuItem("Import Questions");
		mntmImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int templength;
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(Main.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename = c.getSelectedFile().getName();
					directory = c.getCurrentDirectory().toString();
					System.out.println(filename + "|" + directory);
					txtDirectory.setText(directory + "\\" + filename);
				}
				//
				try {
					File inputFile = new File(directory + "\\" + filename);
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(inputFile);
					doc.getDocumentElement().normalize();
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("question");
					for (int temp = 0; temp < nList.getLength(); temp++) {
						String text, A, B, C, D, Good;
						Node nNode = nList.item(temp);
						templength = nList.getLength();
						length = nList.getLength() - 1;
						System.out.println("\nCurrent Element :" + nNode.getNodeName());
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							System.out.println("Roll no : " + eElement.getAttribute("rollno"));
							System.out.println(
									"Text : " + eElement.getElementsByTagName("text").item(0).getTextContent());
							text = eElement.getElementsByTagName("text").item(0).getTextContent();
							arraytext[temp] = text;
							System.out.println(text);
							System.out.println(arraytext[temp]);
							System.out.println("A : " + eElement.getElementsByTagName("A").item(0).getTextContent());
							A = eElement.getElementsByTagName("A").item(0).getTextContent();
							strA[temp] = A;
							System.out.println(A);
							System.out.println(strA[temp]);
							System.out.println("B : " + eElement.getElementsByTagName("B").item(0).getTextContent());
							B = eElement.getElementsByTagName("B").item(0).getTextContent();
							strB[temp] = B;
							System.out.println("C : " + eElement.getElementsByTagName("C").item(0).getTextContent());
							C = eElement.getElementsByTagName("C").item(0).getTextContent();
							strC[temp] = C;
							System.out.println("D : " + eElement.getElementsByTagName("D").item(0).getTextContent());
							D = eElement.getElementsByTagName("D").item(0).getTextContent();
							strD[temp] = D;
							System.out.println(
									"Good : " + eElement.getElementsByTagName("Good").item(0).getTextContent());
							Good = eElement.getElementsByTagName("Good").item(0).getTextContent();
							intGood[temp] = Integer.parseInt(Good);
							System.out.println(Good);
							System.out.println(intGood[temp]);

						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				randomNum = 0 + (int) (Math.random() * length);
				System.out.println(randomNum);
				labelAmount.setText(String.valueOf(length + 1));
				lblQuestion.setText(arraytext[randomNum]);
				lblAnswera.setText(strA[randomNum]);
				lblAnswerb.setText(strB[randomNum]);
				lblAnswerc.setText(strC[randomNum]);
				lblAnswerd.setText(strD[randomNum]); 

			}
		});
		mnOptions.add(mntmImport);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(length);
			}
		});
		mnOptions.add(mntmExit);
		
		JLabel label = new JLabel("/1000");
		label.setForeground(new Color(102, 0, 204));
		menuBar.add(label);
		menuBar.add(label_1);

	}

	// public void actionPerformed(ActionEvent evnt) {
	// int templength;
	// JFileChooser c = new JFileChooser();
	// int rVal = c.showOpenDialog(Main.this);
	// if (rVal == JFileChooser.APPROVE_OPTION) {
	// filename = c.getSelectedFile().getName();
	// directory = c.getCurrentDirectory().toString();
	// System.out.println(filename + "|" + directory);
	// txtDirectory.setText(directory + "\\" + filename);
	// }
	// //
	// try {
	// File inputFile = new File(directory + "\\" + filename);
	// DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	// DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	// Document doc = dBuilder.parse(inputFile);
	// doc.getDocumentElement().normalize();
	// System.out.println("Root element :" +
	// doc.getDocumentElement().getNodeName());
	// NodeList nList = doc.getElementsByTagName("question");
	// for (int temp = 0; temp < nList.getLength(); temp++) {
	// String text, A, B, C, D, Good;
	// Node nNode = nList.item(temp);
	// templength = nList.getLength();
	// length = nList.getLength();
	// System.out.println("\nCurrent Element :" + nNode.getNodeName());
	// if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	// Element eElement = (Element) nNode;
	// System.out.println("Roll no : " + eElement.getAttribute("rollno"));
	// System.out.println("Text : " +
	// eElement.getElementsByTagName("text").item(0).getTextContent());
	// text = eElement.getElementsByTagName("text").item(0).getTextContent();
	// arraytext[temp] = text;
	// System.out.println(text);
	// System.out.println(arraytext[temp]);
	// System.out.println("A : " +
	// eElement.getElementsByTagName("A").item(0).getTextContent());
	// A = eElement.getElementsByTagName("A").item(0).getTextContent();
	// strA[temp] = A;
	// System.out.println(A);
	// System.out.println(strA[temp]);
	// System.out.println("B : " +
	// eElement.getElementsByTagName("B").item(0).getTextContent());
	// B = eElement.getElementsByTagName("B").item(0).getTextContent();
	// strB[temp] = B;
	// System.out.println("C : " +
	// eElement.getElementsByTagName("C").item(0).getTextContent());
	// C = eElement.getElementsByTagName("C").item(0).getTextContent();
	// strC[temp] = C;
	// System.out.println("D : " +
	// eElement.getElementsByTagName("D").item(0).getTextContent());
	// D = eElement.getElementsByTagName("D").item(0).getTextContent();
	// strD[temp] = D;
	// System.out.println("Good : " +
	// eElement.getElementsByTagName("Good").item(0).getTextContent());
	// Good = eElement.getElementsByTagName("Good").item(0).getTextContent();
	// intGood[temp] = Integer.parseInt(Good);
	// System.out.println(Good);
	// System.out.println(intGood[temp]);
	//
	// }
	// }
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// }
	// int randomNum = rand.nextInt(length+1);
	// System.out.println(randomNum);
	//
	// }

}
