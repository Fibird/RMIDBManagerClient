/**
 * Author: Chaoyang Liu
 * E-main: chaoyanglius@outlook.com
 *
 * Software License Agreement (GPL License)
 * A example using RMI & JDBC to operate remote database: Client Side
 * Copyright (c) 2017, Chaoyang Liu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************/
package cc.chaoyangliu.rmiprac.service;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Launch the application.
 */
public class Client {
	static ReturnValues value = new ReturnValues();
	static String dbn;
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Login lg = new Login();
		try {
			lg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			lg.setModal(true);
			value = lg.showDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		dbn = JOptionPane.showInputDialog("Please Input the Name of your DataBase in MySql:");
		if (value.btnValue) {
			GradeManager frame = new GradeManager();
			frame.setVisible(true);					
			frame.setDs(value.usr, value.pwd, dbn);
		}
	}

}
