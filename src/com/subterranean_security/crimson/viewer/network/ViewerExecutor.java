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
package com.subterranean_security.crimson.viewer.network;

import com.subterranean_security.crimson.core.Logger;
import com.subterranean_security.crimson.core.network.BasicExecutor;
import com.subterranean_security.crimson.core.proto.msg.MSG.Message;
import com.subterranean_security.crimson.viewer.ViewerStore;

import io.netty.util.ReferenceCountUtil;

public class ViewerExecutor extends BasicExecutor {

	private ViewerConnector connector;

	public ViewerExecutor(ViewerConnector vc) {
		connector = vc;

		ubt = new Thread(new Runnable() {
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					Message m;
					try {
						m = connector.uq.take();
					} catch (InterruptedException e) {
						return;
					}
					if (m.hasProfileDeltaEv()) {
						profileDelta_ev(m);
					}
					ReferenceCountUtil.release(m);
				}
			}
		});
		ubt.start();

		nbt = new Thread(new Runnable() {
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					Message m;
					try {
						m = connector.nq.take();
					} catch (InterruptedException e) {
						return;
					}

					connector.cq.put(m.getId(), m);

				}
			}
		});
		nbt.start();
	}

	private void profileDelta_ev(Message m) {
		Logger.debug("Recieved profile delta event");
		ViewerStore.Profiles.update(m.getProfileDeltaEv());
	}

}
