package com.subterranean_security.crimson.viewer.ui.screen.netman;

import java.awt.Dimension;
import java.awt.Font;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EtchedBorder;

import com.subterranean_security.crimson.core.util.CUtil;
import com.subterranean_security.crimson.viewer.ViewerStore;
import com.subterranean_security.crimson.viewer.ui.UIUtil;

public class StatsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel label_5;
	private JLabel label_3;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblVal;
	private JLabel lblLocalExternal;

	public StatsPanel() {
		init();
		refresh();
	}

	public void init() {

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 64));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel);
		panel.setLayout(null);

		JLabel lblLocalInternalIp = new JLabel("Local Internal IP:");
		lblLocalInternalIp.setBounds(6, 6, 125, 16);
		lblLocalInternalIp.setIcon(UIUtil.getIcon("icons16/general/ip.png"));
		lblLocalInternalIp.setFont(new Font("Dialog", Font.BOLD, 10));
		panel.add(lblLocalInternalIp);

		label_3 = new JLabel("loading...");
		label_3.setBounds(143, 6, 98, 16);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel.add(label_3);

		JLabel lblServerExternalIp = new JLabel("Server External IP:");
		lblServerExternalIp.setBounds(6, 42, 139, 16);
		lblServerExternalIp.setIcon(UIUtil.getIcon("icons16/general/ip.png"));
		lblServerExternalIp.setFont(new Font("Dialog", Font.BOLD, 10));
		panel.add(lblServerExternalIp);

		label_5 = new JLabel("loading...");
		label_5.setBounds(143, 42, 98, 16);
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 10));
		panel.add(label_5);

		JLabel lblLocalExternalIp = new JLabel("Local External IP:");
		lblLocalExternalIp.setIcon(UIUtil.getIcon("icons16/general/ip.png"));
		lblLocalExternalIp.setFont(new Font("Dialog", Font.BOLD, 10));
		lblLocalExternalIp.setBounds(6, 24, 125, 16);
		panel.add(lblLocalExternalIp);

		lblLocalExternal = new JLabel("loading...");
		lblLocalExternal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalExternal.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblLocalExternal.setBounds(143, 24, 98, 16);
		panel.add(lblLocalExternal);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setPreferredSize(new Dimension(250, 64));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblClients = new JLabel("Clients:");
		lblClients.setIcon(UIUtil.getIcon("icons16/general/user.png"));
		lblClients.setBounds(6, 24, 75, 16);
		panel_1.add(lblClients);
		lblClients.setFont(new Font("Dialog", Font.BOLD, 10));

		lblNewLabel = new JLabel("loading...");
		lblNewLabel.setBounds(143, 24, 98, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel lblViewers = new JLabel("Viewers:");
		lblViewers.setBounds(6, 42, 75, 16);
		panel_1.add(lblViewers);
		lblViewers.setIcon(UIUtil.getIcon("icons16/general/viewer.png"));
		lblViewers.setFont(new Font("Dialog", Font.BOLD, 10));

		lblVal = new JLabel("loading...");
		lblVal.setBounds(143, 42, 98, 16);
		panel_1.add(lblVal);
		lblVal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVal.setFont(new Font("Dialog", Font.PLAIN, 10));

		label_1 = new JLabel("loading...");
		label_1.setBounds(143, 6, 98, 16);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 10));

		JLabel label = new JLabel("Listeners:");
		label.setBounds(6, 6, 125, 16);
		panel_1.add(label);
		label.setIcon(UIUtil.getIcon("icons16/general/network_ethernet.png"));
		label.setFont(new Font("Dialog", Font.BOLD, 10));

	}

	public void refresh() {
		label_5.setText(ViewerStore.Connections.getVC(0).getRemoteAddress());
		label_3.setText(CUtil.Network.getIIP());
		label_1.setText("" + ViewerStore.Profiles.getServer().listeners.size());
		lblNewLabel.setText("" + ViewerStore.Profiles.getServer().getConnectedClients());
		lblVal.setText("" + ViewerStore.Profiles.getServer().getConnectedUsers());
		new SwingWorker<String, String>() {

			@Override
			protected String doInBackground() throws Exception {
				return CUtil.Network.getEIP();
			}

			protected void done() {
				try {
					String eip = get();
					lblLocalExternal.setText(eip);
				} catch (ExecutionException | InterruptedException e) {
					lblLocalExternal.setText("failed to resolve");
				}

			};
		}.execute();

	}
}
