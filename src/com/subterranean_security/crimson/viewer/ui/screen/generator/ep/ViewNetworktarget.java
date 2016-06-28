package com.subterranean_security.crimson.viewer.ui.screen.generator.ep;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.subterranean_security.crimson.core.util.CUtil;
import com.subterranean_security.crimson.viewer.ui.UIUtil;
import com.subterranean_security.crimson.viewer.ui.common.components.ProgressLabel;
import com.subterranean_security.crimson.viewer.ui.common.panels.epanel.EPanel;

public class ViewNetworktarget extends JPanel {

	private static final long serialVersionUID = 1L;

	private EPanel ep;

	private String server;
	private int port;

	private ProgressLabel lblVisibility;
	private ProgressLabel lblPing_1;

	private JLabel lblServerAddress;

	public ViewNetworktarget(EPanel ep, String server, int port) {

		this.ep = ep;
		this.server = server;
		this.port = port;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		init();
		loadIP();
	}

	public void init() {
		setLayout(new BorderLayout(0, 0));

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		add(jp, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 54, 64, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		jp.add(panel);

		JLabel lblPing = new JLabel("Ping:");
		lblPing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPing.setFont(new Font("Dialog", Font.BOLD, 10));
		lblPing.setBounds(12, 28, 57, 15);
		GridBagConstraints gbc_lblPing = new GridBagConstraints();
		gbc_lblPing.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPing.insets = new Insets(0, 0, 5, 5);
		gbc_lblPing.gridx = 0;
		gbc_lblPing.gridy = 0;
		panel.add(lblPing, gbc_lblPing);

		lblPing_1 = new ProgressLabel("loading...");
		lblPing_1.startLoading();

		lblPing_1.setPreferredSize(new Dimension(64, 15));
		GridBagConstraints gbc_lblPing_1 = new GridBagConstraints();
		gbc_lblPing_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPing_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPing_1.gridx = 1;
		gbc_lblPing_1.gridy = 0;
		panel.add(lblPing_1, gbc_lblPing_1);

		JLabel lblTargetVisibility = new JLabel("Status:");
		lblTargetVisibility.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTargetVisibility.setFont(new Font("Dialog", Font.BOLD, 10));
		lblTargetVisibility.setBounds(12, 45, 57, 15);
		GridBagConstraints gbc_lblTargetVisibility = new GridBagConstraints();
		gbc_lblTargetVisibility.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTargetVisibility.insets = new Insets(0, 0, 0, 5);
		gbc_lblTargetVisibility.gridx = 0;
		gbc_lblTargetVisibility.gridy = 1;
		panel.add(lblTargetVisibility, gbc_lblTargetVisibility);

		lblVisibility = new ProgressLabel("loading...");
		lblVisibility.startLoading();
		lblVisibility.setPreferredSize(new Dimension(64, 15));
		GridBagConstraints gbc_lblVisibility = new GridBagConstraints();
		gbc_lblVisibility.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVisibility.gridx = 1;
		gbc_lblVisibility.gridy = 1;
		panel.add(lblVisibility, gbc_lblVisibility);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblServer = new JLabel("Server: ");
		lblServer.setPreferredSize(new Dimension(52, 15));
		panel_2.add(lblServer, BorderLayout.WEST);
		lblServer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblServer.setFont(new Font("Dialog", Font.BOLD, 10));
		lblServer.setBounds(12, 11, 57, 15);

		lblServerAddress = new JLabel(server);
		panel_2.add(lblServerAddress, BorderLayout.CENTER);
		lblServerAddress.setFont(new Font("Dialog", Font.BOLD, 10));
		lblServerAddress.setBounds(81, 11, 330, 15);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(Box.createHorizontalStrut(5), BorderLayout.WEST);
		panel_1.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
		panel_1.add(Box.createVerticalStrut(5), BorderLayout.NORTH);
		add(panel_1, BorderLayout.WEST);

		JLabel label = new JLabel(UIUtil.getIcon("icons32/general/servers_network.png"));
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.add(label);

		JPanel flow = new JPanel();

		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ep.drop();
			}
		});
		btnNewButton.setMargin(new Insets(2, 4, 2, 4));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 10));
		flow.add(btnNewButton);
		panel_1.add(flow, BorderLayout.SOUTH);

	}

	private void loadIP() {

		// resolve address
		new SwingWorker<String, Void>() {
			@Override
			protected String doInBackground() throws Exception {
				Thread.sleep(100);
				return InetAddress.getByName(server).getHostAddress();
			}

			protected void done() {
				try {
					String ip = get();
					lblServerAddress.setText(lblServerAddress.getText() + " (" + ip + ")");
					loadPing();
				} catch (InterruptedException | ExecutionException e) {
					lblServerAddress.setText(lblServerAddress.getText() + " (failed to resolve)");
				}
			};
		}.execute();

	}

	private void loadPing() {

		// ping server
		new SwingWorker<String, Void>() {
			@Override
			protected String doInBackground() throws Exception {
				Thread.sleep(1000);
				double ping = CUtil.Network.ping(server);
				if (ping == 0) {
					return "failed";
				} else {
					return "" + ping + "ms";
				}
			}

			protected void done() {
				lblPing_1.stopLoading();
				try {
					String ping = get();
					lblPing_1.setText(ping);
					loadVisibility();
				} catch (InterruptedException | ExecutionException e) {
					lblPing_1.setText("no response");
				}
			};
		}.execute();

	}

	private void loadVisibility() {

		// ping server
		new SwingWorker<String, Void>() {
			@Override
			protected String doInBackground() throws Exception {
				Thread.sleep(2000);
				return null;
			}

			protected void done() {
				lblVisibility.stopLoading();
				try {
					String status = get();
					lblVisibility.setText(status);
				} catch (InterruptedException | ExecutionException e) {
					lblVisibility.setText("(failed to query visibility)");
				}
			};
		}.execute();

	}
}
