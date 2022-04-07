package com.autozone.pic.config;

import com.autozone.pic.model.PIES;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import java.util.Collections;


@Configuration
@EnableCouchbaseRepositories(basePackages={"com.autozone.pic.repository"})
public class Config extends AbstractCouchbaseConfiguration {

    @Autowired
    private ApplicationContext context;

    @Value("${app.couchbase.connection-string}")
    private String connectionString;

    @Value("${app.couchbase.user-name}")
    private String userName;

    @Value("${app.couchbase.password}")
    private String password;

    @Value("${app.couchbase.bucket-pies}")
    private String piesBucket;

    @Value("${app.couchbase.bucket-aces}")
    private String acesBucket;

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return piesBucket;
    }

    @SneakyThrows
    @Override
    protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
        mapping.mapEntity(PIES.class,getCouchbaseTemplate(piesBucket ));
    }

    @SneakyThrows
    private CouchbaseTemplate getCouchbaseTemplate(String bucketName) throws Exception {
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
                        new CouchbaseCustomConversions(Collections.emptyList())));
        template.setApplicationContext(context);
        return template;
    }

    private CouchbaseClientFactory couchbaseClientFactory(String bucketName){
        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()), bucketName, this.getScopeName());
    }
}