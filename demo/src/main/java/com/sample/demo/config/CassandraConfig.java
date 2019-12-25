package com.sample.demo.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.sample.demo.repository")
@PropertySource(value = { "classpath:application.properties" })
public class CassandraConfig extends AbstractCassandraConfiguration {

	// @Value("$ {cassandra.keyspace}")
	private String keySpace = "irctc";

	// @Value("$ {cassandra.host}")
	// private String host;

	// @Value("$ {cassandra.port}")
	// private String port;

	@Value("$ {cassandra.username}")
	private String userName;

	@Value("$ {cassandra.password}")
	private String password;

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints("192.168.14.18");
		cluster.setPort(9042);
		cluster.setUsername(userName);
		cluster.setPassword(password);
		cluster.setJmxReportingEnabled(false);
		return cluster;
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new CassandraMappingContext();
	}

	@Override
	protected boolean getMetricsEnabled() {
		return false;
	}

	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(keySpace).ifNotExists()
				.withSimpleReplication(1).with(KeyspaceOption.DURABLE_WRITES, true));
	}

	@Override
	protected List<String> getStartupScripts() {
		List<String> tablesList = new ArrayList<>();
		tablesList.add("CREATE TABLE IF NOT EXISTS " + keySpace
				+ ".person (id text PRIMARY KEY,name text,age int) WITH default_time_to_live = 600;");
		tablesList.add("CREATE TABLE IF NOT EXISTS " + keySpace
				+ ".registration (uname text,id int,mobile_no text,password text,PRIMARY KEY (uname, id));");
		tablesList.add("CREATE TABLE IF NOT EXISTS " + keySpace
				+ ".tickets (ticket_id int,train_name text,train_no int,source text,destination text,jouney_date timestamp,seat_no int,rid int,uname text,PRIMARY KEY (ticket_id));");
		tablesList.add("CREATE TABLE IF NOT EXISTS " + keySpace
				+ ".trains (train_id int,train_name text,train_no int,current_seats int,destination text,source text,total_seats int,PRIMARY KEY (train_id, train_name, train_no));");
		return tablesList;
	}

}
