/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Delete activity.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = DeleteActivity.class)
@JsonTypeName("Delete")
@JsonFlatten
public class DeleteActivity extends ExecutionActivity {
    /**
     * If true, files or sub-folders under current folder path will be deleted
     * recursively. Default is false. Type: boolean (or Expression with
     * resultType boolean).
     */
    @JsonProperty(value = "typeProperties.recursive")
    private Object recursive;

    /**
     * The max concurrent connections to connect data source at the same time.
     */
    @JsonProperty(value = "typeProperties.maxConcurrentConnections")
    private Integer maxConcurrentConnections;

    /**
     * Whether to record detailed logs of delete-activity execution. Default
     * value is false. Type: boolean (or Expression with resultType boolean).
     */
    @JsonProperty(value = "typeProperties.enableLogging")
    private Object enableLogging;

    /**
     * Log storage settings customer need to provide when enableLogging is
     * true.
     */
    @JsonProperty(value = "typeProperties.logStorageSettings")
    private LogStorageSettings logStorageSettings;

    /**
     * Delete activity dataset reference.
     */
    @JsonProperty(value = "typeProperties.dataset", required = true)
    private DatasetReference dataset;

    /**
     * Get if true, files or sub-folders under current folder path will be deleted recursively. Default is false. Type: boolean (or Expression with resultType boolean).
     *
     * @return the recursive value
     */
    public Object recursive() {
        return this.recursive;
    }

    /**
     * Set if true, files or sub-folders under current folder path will be deleted recursively. Default is false. Type: boolean (or Expression with resultType boolean).
     *
     * @param recursive the recursive value to set
     * @return the DeleteActivity object itself.
     */
    public DeleteActivity withRecursive(Object recursive) {
        this.recursive = recursive;
        return this;
    }

    /**
     * Get the max concurrent connections to connect data source at the same time.
     *
     * @return the maxConcurrentConnections value
     */
    public Integer maxConcurrentConnections() {
        return this.maxConcurrentConnections;
    }

    /**
     * Set the max concurrent connections to connect data source at the same time.
     *
     * @param maxConcurrentConnections the maxConcurrentConnections value to set
     * @return the DeleteActivity object itself.
     */
    public DeleteActivity withMaxConcurrentConnections(Integer maxConcurrentConnections) {
        this.maxConcurrentConnections = maxConcurrentConnections;
        return this;
    }

    /**
     * Get whether to record detailed logs of delete-activity execution. Default value is false. Type: boolean (or Expression with resultType boolean).
     *
     * @return the enableLogging value
     */
    public Object enableLogging() {
        return this.enableLogging;
    }

    /**
     * Set whether to record detailed logs of delete-activity execution. Default value is false. Type: boolean (or Expression with resultType boolean).
     *
     * @param enableLogging the enableLogging value to set
     * @return the DeleteActivity object itself.
     */
    public DeleteActivity withEnableLogging(Object enableLogging) {
        this.enableLogging = enableLogging;
        return this;
    }

    /**
     * Get log storage settings customer need to provide when enableLogging is true.
     *
     * @return the logStorageSettings value
     */
    public LogStorageSettings logStorageSettings() {
        return this.logStorageSettings;
    }

    /**
     * Set log storage settings customer need to provide when enableLogging is true.
     *
     * @param logStorageSettings the logStorageSettings value to set
     * @return the DeleteActivity object itself.
     */
    public DeleteActivity withLogStorageSettings(LogStorageSettings logStorageSettings) {
        this.logStorageSettings = logStorageSettings;
        return this;
    }

    /**
     * Get delete activity dataset reference.
     *
     * @return the dataset value
     */
    public DatasetReference dataset() {
        return this.dataset;
    }

    /**
     * Set delete activity dataset reference.
     *
     * @param dataset the dataset value to set
     * @return the DeleteActivity object itself.
     */
    public DeleteActivity withDataset(DatasetReference dataset) {
        this.dataset = dataset;
        return this;
    }

}
