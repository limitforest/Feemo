/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciotc.feemo.setting;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ciotc.feemo.util.I18N;

/**
 *
 * @author Linxiaozhi
 */
public class LanguagePanel extends JPanel {

//	static String fileName = "config\\language.properties";

	//int selection  = 0;
	public void save(String language, String country) {
		
	}

	

	private static int originSelection =0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form NewJFrame
	 */
	public LanguagePanel() {
		//constructHashMap();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		jComboBox1 = new javax.swing.JComboBox();
		jLabel1 = new javax.swing.JLabel();

		jLabel1.setText(I18N.getString("SelectLanguageFrame.tips"));

		setLayout(null);

		add(jLabel1);
		jLabel1.setBounds(10, 0, 320, 60);
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "中文", "English", "русский","Український","Deutsch",
											"español","français","italiano","日本語"}));
		add(jComboBox1);
		jComboBox1.setBounds(10, 70, 300, 21);

		load();

	}

	public void load() {
		jComboBox1.setSelectedIndex(0);
	}

	public void apply() {
		int selection = jComboBox1.getSelectedIndex();
		if(originSelection==selection) return;
		switch (selection) {
		case 0: //中文
			save("zh", "CN");
			break;
		case 1: //英文
			save("en", "US");
			break;
		case 2: //饿文
			save("ru", "RU");
			break;
		case 3://乌克兰语
			save("uk","UA");
			break;
		case 4://德语
			save("de","DE");
			break;
		case 5://西班牙语
			save("es","ES");
			break;
		case 6://法语
			save("fr","FR");
			break;
		case 7://意大利语
			save("it","IT");
			break;
		case 8://日语
			save("ja","JP");
			break;
		default:
			break;
		}
		int result = JOptionPane.showConfirmDialog(this, I18N.getString("SelectLanguageFrame.restart"),  I18N.getString("Teemo"), JOptionPane.YES_NO_OPTION);
		
	}

	public void setDefault() {
		jComboBox1.setSelectedIndex(originSelection);
	}

	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration
}