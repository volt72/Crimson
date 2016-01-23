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
package com.subterranean_security.crimson.server;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.subterranean_security.crimson.core.Common;
import com.subterranean_security.crimson.core.proto.msg.Gen.ClientConfig;
import com.subterranean_security.crimson.core.proto.msg.Gen.Group;
import com.subterranean_security.crimson.core.storage.ServerDB;
import com.subterranean_security.crimson.core.utility.CUtil;
import com.subterranean_security.crimson.core.utility.FileLocking;
import com.subterranean_security.crimson.server.network.Listener;

public final class Server {
	private static final Logger log = LoggerFactory.getLogger("com.subterranean_security.crimson.server.Server");

	private static boolean running;
	private static Listener localListener;

	public static void main(String[] argv) {

		// Establish the custom fallback exception handler
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

		// Establish the custom shutdown hook
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());

		// Check for file lock
		if (FileLocking.lockExists(Common.instance)) {
			log.error("Crimson detected that it's already running");
			return;
		} else {
			FileLocking.lock(Common.instance);
		}

		// Clear /tmp/
		CUtil.Files.Temp.clearL();

		// initialize system database
		try {
			ServerStore.Databases.system = new ServerDB(new File(Common.base.getAbsolutePath() + "/var/system.db"));
		} catch (Exception e) {
			log.error("Could not initialize system database");

		}

		// start a localhost listener (dont add it to the store)
		localListener = new Listener(2031, true, true, false);

		start();
		log.debug("Done");

		// testing();
	}

	public static boolean isRunning() {
		return running;
	}

	public static void stop() {
		if (running) {

		}

	}

	public static void start() {
		if (!running) {

		}
	}

	private static void testing() {
		log.info("Starting server test!");

		Group group = Group.newBuilder().setName("BESTGROUP").setKey("RANDOMKEY").build();
		ClientConfig cc = ClientConfig.newBuilder().setOutputType("Java (.jar)").setGroup(group).setReconnectPeriod(10)
				.build();
		try {
			Generator g = new Generator(cc);
			byte[] res = g.getResult();
			log.info("Installer size: " + res.length + " bytes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setState(boolean change) {
		// TODO Auto-generated method stub

	}

}
