/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package com.ymy.xxb.migrat.job.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * Xxl Job Config
 *
 * @author: wangyi
 *
 */
@Slf4j
@Configuration
public class XxlJobConfig {
	@Value("${xxl.job.admin.addresses}")
    private String addresses;

    @Value("${xxl.job.executor.appname}")
    private String appname;

    @Value("${xxl.job.executor.ip}")
    private String ip;

    @Value("${xxl.job.executor.port}")
    private int port;

    @Value("${xxl.job.executor.logpath}")
    private String logpath;
    
    @Value("${xxl.job.executor.logretentiondays}")
    private int logretentiondays;
    
    @Value("${xxl.job.accessToken}")
    private String accessToken;
    
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
    	log.info(">>>>>>>>>>> xxl-job config init.");
    	XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
    	xxlJobSpringExecutor.setAddress(addresses);
    	xxlJobSpringExecutor.setAdminAddresses(addresses);
    	xxlJobSpringExecutor.setAppname(appname);
    	xxlJobSpringExecutor.setIp(ip);
    	xxlJobSpringExecutor.setPort(port);
    	xxlJobSpringExecutor.setAccessToken(accessToken);
    	xxlJobSpringExecutor.setLogPath(logpath);
    	xxlJobSpringExecutor.setLogRetentionDays(logretentiondays);
    	
    	return xxlJobSpringExecutor;
    }
}
