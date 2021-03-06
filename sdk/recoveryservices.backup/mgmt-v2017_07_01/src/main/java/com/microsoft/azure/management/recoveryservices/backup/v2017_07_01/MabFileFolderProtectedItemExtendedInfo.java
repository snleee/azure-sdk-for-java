/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2017_07_01;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional information on the backed up item.
 */
public class MabFileFolderProtectedItemExtendedInfo {
    /**
     * Last time when the agent data synced to service.
     */
    @JsonProperty(value = "lastRefreshedAt")
    private DateTime lastRefreshedAt;

    /**
     * The oldest backup copy available.
     */
    @JsonProperty(value = "oldestRecoveryPoint")
    private DateTime oldestRecoveryPoint;

    /**
     * Number of backup copies associated with the backup item.
     */
    @JsonProperty(value = "recoveryPointCount")
    private Integer recoveryPointCount;

    /**
     * Get last time when the agent data synced to service.
     *
     * @return the lastRefreshedAt value
     */
    public DateTime lastRefreshedAt() {
        return this.lastRefreshedAt;
    }

    /**
     * Set last time when the agent data synced to service.
     *
     * @param lastRefreshedAt the lastRefreshedAt value to set
     * @return the MabFileFolderProtectedItemExtendedInfo object itself.
     */
    public MabFileFolderProtectedItemExtendedInfo withLastRefreshedAt(DateTime lastRefreshedAt) {
        this.lastRefreshedAt = lastRefreshedAt;
        return this;
    }

    /**
     * Get the oldest backup copy available.
     *
     * @return the oldestRecoveryPoint value
     */
    public DateTime oldestRecoveryPoint() {
        return this.oldestRecoveryPoint;
    }

    /**
     * Set the oldest backup copy available.
     *
     * @param oldestRecoveryPoint the oldestRecoveryPoint value to set
     * @return the MabFileFolderProtectedItemExtendedInfo object itself.
     */
    public MabFileFolderProtectedItemExtendedInfo withOldestRecoveryPoint(DateTime oldestRecoveryPoint) {
        this.oldestRecoveryPoint = oldestRecoveryPoint;
        return this;
    }

    /**
     * Get number of backup copies associated with the backup item.
     *
     * @return the recoveryPointCount value
     */
    public Integer recoveryPointCount() {
        return this.recoveryPointCount;
    }

    /**
     * Set number of backup copies associated with the backup item.
     *
     * @param recoveryPointCount the recoveryPointCount value to set
     * @return the MabFileFolderProtectedItemExtendedInfo object itself.
     */
    public MabFileFolderProtectedItemExtendedInfo withRecoveryPointCount(Integer recoveryPointCount) {
        this.recoveryPointCount = recoveryPointCount;
        return this;
    }

}
