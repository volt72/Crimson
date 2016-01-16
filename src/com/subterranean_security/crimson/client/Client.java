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
package com.subterranean_security.crimson.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLException;

import com.subterranean_security.crimson.client.network.ClientConnector;
import com.subterranean_security.crimson.core.Common;
import com.subterranean_security.crimson.core.Logger;
import com.subterranean_security.crimson.core.proto.msg.Gen.NetworkTarget;
import com.subterranean_security.crimson.core.storage.LocalClientDB;

public class Client {

	public static ClientConnector connector;
	public static LocalClientDB clientDB;
	public static int connectionIterations = 0;

	public static void main(String[] args) {

		System.out.println("Valid installation detected: starting up");

		// Establish the custom fallback exception handler
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

		// Establish the custom shutdown hook
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());

		List<NetworkTarget> nts = null;
		try {
			clientDB = new LocalClientDB(new File(Common.base + "/var/client.db"));
			nts = getExternalNts();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Database error");
		}

		connectionRoutine(nts);

	}

	private static List<NetworkTarget> getExternalNts() throws Exception {

		return (List<NetworkTarget>) clientDB.getObject("nts");
	}

	public static void connectionRoutine(List<NetworkTarget> nt) {
		connectionIterations++;
		for (NetworkTarget n : nt) {
			try {
				Logger.debug("Attempting connection to: " + n.getServer() + ":" + n.getPort());
				connector = new ClientConnector(n.getServer(), n.getPort());
			} catch (SSLException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
