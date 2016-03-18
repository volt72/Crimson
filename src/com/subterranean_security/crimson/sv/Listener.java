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
package com.subterranean_security.crimson.sv;

import java.io.Serializable;

import com.subterranean_security.crimson.core.util.CUtil;
import com.subterranean_security.crimson.server.net.ServerInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Listener implements AutoCloseable, Serializable {

	private static final long serialVersionUID = 1L;
	private transient ChannelFuture future;
	private transient EventLoopGroup bossGroup;
	private transient EventLoopGroup workerGroup;

	public String name;
	public int port;
	public boolean local;
	public boolean upnp;
	public boolean clientAcceptor;
	public boolean viewerAcceptor;
	public final String id = CUtil.Misc.randString(8);// ensure this wont
														// change

	public Listener(String name, int port, boolean local, boolean acceptClients, boolean acceptViewers, boolean upnp) {
		this.port = port;
		this.name = name;
		this.local = local;
		this.upnp = upnp;
		this.clientAcceptor = acceptClients;
		this.viewerAcceptor = acceptViewers;
		start();
	}

	public void start() {
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();

		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)//
				.childHandler(new ServerInitializer(null))//
				.option(ChannelOption.SO_BACKLOG, 128)//
				.childOption(ChannelOption.SO_KEEPALIVE, true);

		future = b.bind(port);

	}

	public void close() throws InterruptedException {
		try {
			future.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

}