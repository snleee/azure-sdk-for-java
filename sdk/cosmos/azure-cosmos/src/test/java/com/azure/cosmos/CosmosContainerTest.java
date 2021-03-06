/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 *
 */

package com.azure.cosmos;

import com.azure.cosmos.rx.TestSuiteBase;
import com.azure.cosmos.implementation.HttpConstants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CosmosContainerTest extends TestSuiteBase {

    private String preExistingDatabaseId = CosmosDatabaseForTest.generateId();
    private CosmosClient client;
    private CosmosDatabase createdDatabase;

    @Factory(dataProvider = "clientBuilders")
    public CosmosContainerTest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @BeforeClass(groups = {"emulator"}, timeOut = SETUP_TIMEOUT)
    public void before_CosmosContainerTest() {
        client = clientBuilder().buildClient();
        createdDatabase = createSyncDatabase(client, preExistingDatabaseId);
    }

    @AfterClass(groups = {"emulator"}, timeOut = 3 * SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        logger.info("starting ....");
        safeDeleteSyncDatabase(createdDatabase);
        safeCloseSyncClient(client);
    }

    private CosmosContainerProperties getCollectionDefinition(String collectionName) {
        PartitionKeyDefinition partitionKeyDef = new PartitionKeyDefinition();
        ArrayList<String> paths = new ArrayList<String>();
        paths.add("/mypk");
        partitionKeyDef.setPaths(paths);

        CosmosContainerProperties collectionDefinition = new CosmosContainerProperties(
            collectionName,
            partitionKeyDef);

        return collectionDefinition;
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withProperties() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);
        assertThat(containerResponse.getRequestCharge()).isGreaterThan(0);
        validateContainerResponse(containerProperties, containerResponse);
    }

    @Test(groups = {"emulator"}, timeOut = TIMEOUT)
    public void createContainer_alreadyExists() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);
        validateContainerResponse(containerProperties, containerResponse);

        try {
            createdDatabase.createContainer(containerProperties);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(CosmosClientException.class);
            assertThat(((CosmosClientException) e).getStatusCode()).isEqualTo(HttpConstants.StatusCodes.CONFLICT);
        }
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withThroughput() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        int throughput = 1000;

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties,
            throughput);
        validateContainerResponse(containerProperties, containerResponse);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withOptions() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties, options);
        validateContainerResponse(containerProperties, containerResponse);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withThroughputAndOptions() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        int throughput = 1000;

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties,
            throughput, options);
        validateContainerResponse(containerProperties, containerResponse);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withNameAndPartitoinKeyPath() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        String partitionKeyPath = "/mypk";

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(collectionName, partitionKeyPath);
        validateContainerResponse(new CosmosContainerProperties(collectionName, partitionKeyPath), containerResponse);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void createContainer_withNamePartitionPathAndThroughput() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        String partitionKeyPath = "/mypk";
        int throughput = 1000;

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(collectionName,
            partitionKeyPath, throughput);
        validateContainerResponse(new CosmosContainerProperties(collectionName, partitionKeyPath), containerResponse);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void readContainer() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);

        CosmosContainer syncContainer = createdDatabase.getContainer(collectionName);

        CosmosContainerResponse read = syncContainer.read();
        validateContainerResponse(containerProperties, read);

        CosmosContainerResponse read1 = syncContainer.read(options);
        validateContainerResponse(containerProperties, read1);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void deleteContainer() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);

        CosmosContainer syncContainer = createdDatabase.getContainer(collectionName);
        CosmosContainerResponse deleteResponse = syncContainer.delete();

    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void deleteContainer_withOptions() throws Exception {
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();
        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);

        CosmosContainer syncContainer = createdDatabase.getContainer(collectionName);
        CosmosContainerResponse deleteResponse = syncContainer.delete(options);

    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void replace() throws Exception {

        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);
        validateContainerResponse(containerProperties, containerResponse);

        assertThat(containerResponse.getProperties().getIndexingPolicy().getIndexingMode()).isEqualTo(IndexingMode.CONSISTENT);

        CosmosContainerResponse replaceResponse = containerResponse.getContainer()
                                                          .replace(containerResponse.getProperties().setIndexingPolicy(
                                                              new IndexingPolicy().setIndexingMode(IndexingMode.LAZY)));
        assertThat(replaceResponse.getProperties().getIndexingPolicy().getIndexingMode())
            .isEqualTo(IndexingMode.LAZY);

        CosmosContainerResponse replaceResponse1 = containerResponse.getContainer()
                                                          .replace(containerResponse.getProperties().setIndexingPolicy(
                                                              new IndexingPolicy().setIndexingMode(IndexingMode.CONSISTENT)),
                                                              options);
        assertThat(replaceResponse1.getProperties().getIndexingPolicy().getIndexingMode())
            .isEqualTo(IndexingMode.CONSISTENT);

    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void readAllContainers() throws Exception{
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);
        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator = createdDatabase.readAllContainers();
        // Very basic validation
        assertThat(feedResponseIterator.iterator().hasNext()).isTrue();

        FeedOptions feedOptions = new FeedOptions();
        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator1 = createdDatabase.readAllContainers(feedOptions);
        assertThat(feedResponseIterator1.iterator().hasNext()).isTrue();
    }


    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void queryContainer() throws Exception{
        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);
        CosmosContainerRequestOptions options = new CosmosContainerRequestOptions();

        CosmosContainerResponse containerResponse = createdDatabase.createContainer(containerProperties);
        String query = String.format("SELECT * from c where c.id = '%s'", collectionName);
        FeedOptions feedOptions = new FeedOptions();

        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator = createdDatabase.queryContainers(query);
        // Very basic validation
        assertThat(feedResponseIterator.iterator().hasNext()).isTrue();

        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator1 =
            createdDatabase.queryContainers(query, feedOptions);
        // Very basic validation
        assertThat(feedResponseIterator1.iterator().hasNext()).isTrue();

        SqlQuerySpec querySpec = new SqlQuerySpec(query);
        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator2 =
            createdDatabase.queryContainers(querySpec);
        assertThat(feedResponseIterator2.iterator().hasNext()).isTrue();

        CosmosPagedIterable<CosmosContainerProperties> feedResponseIterator3 =
            createdDatabase.queryContainers(querySpec, feedOptions);
        assertThat(feedResponseIterator3.iterator().hasNext()).isTrue();
    }

    private void validateContainerResponse(CosmosContainerProperties containerProperties,
                                           CosmosContainerResponse createResponse) {
        // Basic validation
        assertThat(createResponse.getProperties().getId()).isNotNull();
        assertThat(createResponse.getProperties().getId())
            .as("check Resource Id")
            .isEqualTo(containerProperties.getId());

    }
}
