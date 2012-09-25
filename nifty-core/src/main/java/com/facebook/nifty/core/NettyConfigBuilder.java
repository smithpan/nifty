/**
 * Copyright 2012 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.nifty.core;

import com.google.inject.Inject;
import org.jboss.netty.channel.socket.ServerSocketChannelConfig;
import org.jboss.netty.channel.socket.nio.NioSocketChannelConfig;

import java.lang.reflect.Proxy;

/*
 * Hooks for configuring various parts of Netty.
 */
public class NettyConfigBuilder extends NettyConfigBuilderBase
{

    private final NioSocketChannelConfig socketChannelConfig = (NioSocketChannelConfig) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class<?>[]{NioSocketChannelConfig.class},
            new Magic("child.")
    );
    private final ServerSocketChannelConfig serverSocketChannelConfig = (ServerSocketChannelConfig) Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class<?>[]{ServerSocketChannelConfig.class},
            new Magic(""));

    @Inject
    public NettyConfigBuilder()
    {
    }

    public NioSocketChannelConfig getSocketChannelConfig()
    {
        return socketChannelConfig;
    }

    public ServerSocketChannelConfig getServerSocketChannelConfig()
    {
        return serverSocketChannelConfig;
    }
}