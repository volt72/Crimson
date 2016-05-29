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
package com.subterranean_security.crimson.core.stream.info;

import java.util.Random;

import com.subterranean_security.crimson.core.Common;
import com.subterranean_security.crimson.core.proto.MSG.Message;
import com.subterranean_security.crimson.core.proto.Stream.InfoParam;
import com.subterranean_security.crimson.core.proto.Stream.MI_StreamStart;
import com.subterranean_security.crimson.core.proto.Stream.MI_StreamStop;
import com.subterranean_security.crimson.core.proto.Stream.Param;
import com.subterranean_security.crimson.core.stream.Stream;
import com.subterranean_security.crimson.viewer.net.ViewerRouter;

public class InfoMaster extends Stream {

	public InfoMaster(InfoParam ip, int CID, int period) {

		param = Param.newBuilder().setPeriod(period).setInfoParam(ip).setStreamID(new Random().nextInt()).setCID(CID)
				.setVID(Common.cvid).build();
		start();
	}

	public InfoMaster(InfoParam ip, int period) {
		this(ip, 0, period);
	}

	@Override
	public void received(Message m) {
		// receiving is handled by executor

	}

	@Override
	public void send() {
		// do nothing

	}

	@Override
	public void start() {
		ViewerRouter.route(Message.newBuilder().setSid(param.getVID()).setRid(param.getCID())
				.setMiStreamStart(MI_StreamStart.newBuilder().setParam(param)));

	}

	@Override
	public void stop() {
		ViewerRouter.route(
				Message.newBuilder().setMiStreamStop(MI_StreamStop.newBuilder().setStreamID(param.getStreamID())));

	}

}
