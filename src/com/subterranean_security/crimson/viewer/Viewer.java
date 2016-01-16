/******************************************************************************
 *                                                                            *
 *                    Copyright 2016 Subterranean Security                    *
 *                                                                            *
 *  Licensed under the Apache License, Version 2.0 (the "License");           *
 *  you may not use this file except in compliance with the License.          *
 *  You may obtain a copy of the License at                                   *
 *                                                                            *
 *      http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                            *
 *  Unless required by applicable law or agreed to in writing, software       *
 *  distributed under the License is distributed on an "AS IS" BASIS,         *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 *  See the License for the specific language governing permissions and       *
 *  limitations under the License.                                            *
 *                                                                            *
 *****************************************************************************/
package com.subterranean_security.crimson.viewer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.UIManager;

import com.subterranean_security.crimson.core.Common;
import com.subterranean_security.crimson.core.Logger;
import com.subterranean_security.crimson.core.utility.FileLocking;
import com.subterranean_security.crimson.viewer.ui.panel.MovingPanel;
import com.subterranean_security.crimson.viewer.ui.screen.eula.EULADialog;
import com.subterranean_security.crimson.viewer.ui.screen.login.LoginDialog;
import com.subterranean_security.crimson.viewer.ui.screen.main.MainFrame;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.tweenengine.Tween;

public class Viewer {

	/**
	 * The server executable
	 */
	public static final File bundledServer = new File("Crimson-Server.jar");

	/**
	 * True when a server instance is detected that was not started by the
	 * viewer
	 */
	public static boolean slsr = FileLocking.lockExists(Common.Instance.SERVER);
	private static Process serverProcess;

	public static void main(String[] argv) {

		// Establish the custom fallback exception handler
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

		// Establish the custom shutdown hook
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Show the EULA if needed
		EULADialog eula = new EULADialog(true);
		eula.setLocationRelativeTo(null);
		eula.setVisible(true);

		synchronized (eula) {
			try {
				eula.wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		eula = null;

		if (bundledServer.exists() && !slsr) {
			try {
				Logger.debug("Attempting to start local server");
				serverProcess = Runtime.getRuntime().exec("java -jar Crimson-Server.jar");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// initialize sliding layout
		Tween.registerAccessor(MovingPanel.class, new MovingPanel.Accessor());
		SLAnimator.start();

		// show login dialog
		LoginDialog login = new LoginDialog();
		login.setVisible(true);
		try {
			synchronized (login) {
				login.wait();
			}

		} catch (InterruptedException e) {
			return;
		}
		login = null;

		// Start the interface
		MainFrame.main = new MainFrame();
		MainFrame.main.setVisible(true);
		MainFrame.main.setLocationRelativeTo(null);

	}

	public boolean startLocalServer() {

		return false;
	}

	public void killLocalServer() {

	}

	public static void loadJar(String path) throws Exception {
		File target = new File(path);
		System.out.println("Loading: " + target.getAbsolutePath());
		if (!target.exists()) {
			throw new Exception();
		}

		Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
		method.setAccessible(true);
		method.invoke(ClassLoader.getSystemClassLoader(), new Object[] { target.toURI().toURL() });
	}

}
