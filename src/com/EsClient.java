package com;

import static org.apache.commons.lang.StringUtils.split;
import static org.apache.commons.lang.StringUtils.substringAfter;
import static org.apache.commons.lang.StringUtils.substringBefore;
import static org.elasticsearch.common.settings.ImmutableSettings.settingsBuilder;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class EsClient {
	private static volatile TransportClient client = null;

	private static final String EsIp = "172.21.229.85";
	private static final String EsName = "elasticsearch-czjj";
	
    public static org.elasticsearch.client.Client getClient() {
    	System.out.println("Es:"+EsIp+","+EsName);
        if (client == null) {
        	synchronized (EsClient.class) {
        		client = new TransportClient(settings(EsName));
                client.addTransportAddress(
      							new InetSocketTransportAddress(EsIp, 9300));
                client.connectedNodes();
			}
        }
        return client;
    }

    private static Settings settings(String name) {
        return settingsBuilder()
                .put("cluster.name", name)
                .put("client.transport.sniff", Boolean.TRUE)
                .put("client.transport.ignore_cluster_name", Boolean.FALSE)
                .put("client.transport.ping_timeout", "5s")
                .put("client.transport.nodes_sampler_interval", "5s").build();
    }
}
