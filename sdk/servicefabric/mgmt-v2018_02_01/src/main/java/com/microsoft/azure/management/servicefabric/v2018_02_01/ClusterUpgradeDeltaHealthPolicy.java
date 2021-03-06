/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicefabric.v2018_02_01;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the delta health policies for the cluster upgrade.
 */
public class ClusterUpgradeDeltaHealthPolicy {
    /**
     * The maximum allowed percentage of nodes health degradation allowed
     * during cluster upgrades.
     * The delta is measured between the state of the nodes at the beginning of
     * upgrade and the state of the nodes at the time of the health evaluation.
     * The check is performed after every upgrade domain upgrade completion to
     * make sure the global state of the cluster is within tolerated limits.
     */
    @JsonProperty(value = "maxPercentDeltaUnhealthyNodes", required = true)
    private int maxPercentDeltaUnhealthyNodes;

    /**
     * The maximum allowed percentage of upgrade domain nodes health
     * degradation allowed during cluster upgrades.
     * The delta is measured between the state of the upgrade domain nodes at
     * the beginning of upgrade and the state of the upgrade domain nodes at
     * the time of the health evaluation.
     * The check is performed after every upgrade domain upgrade completion for
     * all completed upgrade domains to make sure the state of the upgrade
     * domains is within tolerated limits.
     */
    @JsonProperty(value = "maxPercentUpgradeDomainDeltaUnhealthyNodes", required = true)
    private int maxPercentUpgradeDomainDeltaUnhealthyNodes;

    /**
     * The maximum allowed percentage of applications health degradation
     * allowed during cluster upgrades.
     * The delta is measured between the state of the applications at the
     * beginning of upgrade and the state of the applications at the time of
     * the health evaluation.
     * The check is performed after every upgrade domain upgrade completion to
     * make sure the global state of the cluster is within tolerated limits.
     * System services are not included in this.
     */
    @JsonProperty(value = "maxPercentDeltaUnhealthyApplications", required = true)
    private int maxPercentDeltaUnhealthyApplications;

    /**
     * Defines the application delta health policy map used to evaluate the
     * health of an application or one of its child entities when upgrading the
     * cluster.
     */
    @JsonProperty(value = "applicationDeltaHealthPolicies")
    private Map<String, ApplicationDeltaHealthPolicy> applicationDeltaHealthPolicies;

    /**
     * Get the maximum allowed percentage of nodes health degradation allowed during cluster upgrades.
     The delta is measured between the state of the nodes at the beginning of upgrade and the state of the nodes at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion to make sure the global state of the cluster is within tolerated limits.
     *
     * @return the maxPercentDeltaUnhealthyNodes value
     */
    public int maxPercentDeltaUnhealthyNodes() {
        return this.maxPercentDeltaUnhealthyNodes;
    }

    /**
     * Set the maximum allowed percentage of nodes health degradation allowed during cluster upgrades.
     The delta is measured between the state of the nodes at the beginning of upgrade and the state of the nodes at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion to make sure the global state of the cluster is within tolerated limits.
     *
     * @param maxPercentDeltaUnhealthyNodes the maxPercentDeltaUnhealthyNodes value to set
     * @return the ClusterUpgradeDeltaHealthPolicy object itself.
     */
    public ClusterUpgradeDeltaHealthPolicy withMaxPercentDeltaUnhealthyNodes(int maxPercentDeltaUnhealthyNodes) {
        this.maxPercentDeltaUnhealthyNodes = maxPercentDeltaUnhealthyNodes;
        return this;
    }

    /**
     * Get the maximum allowed percentage of upgrade domain nodes health degradation allowed during cluster upgrades.
     The delta is measured between the state of the upgrade domain nodes at the beginning of upgrade and the state of the upgrade domain nodes at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion for all completed upgrade domains to make sure the state of the upgrade domains is within tolerated limits.
     *
     * @return the maxPercentUpgradeDomainDeltaUnhealthyNodes value
     */
    public int maxPercentUpgradeDomainDeltaUnhealthyNodes() {
        return this.maxPercentUpgradeDomainDeltaUnhealthyNodes;
    }

    /**
     * Set the maximum allowed percentage of upgrade domain nodes health degradation allowed during cluster upgrades.
     The delta is measured between the state of the upgrade domain nodes at the beginning of upgrade and the state of the upgrade domain nodes at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion for all completed upgrade domains to make sure the state of the upgrade domains is within tolerated limits.
     *
     * @param maxPercentUpgradeDomainDeltaUnhealthyNodes the maxPercentUpgradeDomainDeltaUnhealthyNodes value to set
     * @return the ClusterUpgradeDeltaHealthPolicy object itself.
     */
    public ClusterUpgradeDeltaHealthPolicy withMaxPercentUpgradeDomainDeltaUnhealthyNodes(int maxPercentUpgradeDomainDeltaUnhealthyNodes) {
        this.maxPercentUpgradeDomainDeltaUnhealthyNodes = maxPercentUpgradeDomainDeltaUnhealthyNodes;
        return this;
    }

    /**
     * Get the maximum allowed percentage of applications health degradation allowed during cluster upgrades.
     The delta is measured between the state of the applications at the beginning of upgrade and the state of the applications at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion to make sure the global state of the cluster is within tolerated limits. System services are not included in this.
     *
     * @return the maxPercentDeltaUnhealthyApplications value
     */
    public int maxPercentDeltaUnhealthyApplications() {
        return this.maxPercentDeltaUnhealthyApplications;
    }

    /**
     * Set the maximum allowed percentage of applications health degradation allowed during cluster upgrades.
     The delta is measured between the state of the applications at the beginning of upgrade and the state of the applications at the time of the health evaluation.
     The check is performed after every upgrade domain upgrade completion to make sure the global state of the cluster is within tolerated limits. System services are not included in this.
     *
     * @param maxPercentDeltaUnhealthyApplications the maxPercentDeltaUnhealthyApplications value to set
     * @return the ClusterUpgradeDeltaHealthPolicy object itself.
     */
    public ClusterUpgradeDeltaHealthPolicy withMaxPercentDeltaUnhealthyApplications(int maxPercentDeltaUnhealthyApplications) {
        this.maxPercentDeltaUnhealthyApplications = maxPercentDeltaUnhealthyApplications;
        return this;
    }

    /**
     * Get defines the application delta health policy map used to evaluate the health of an application or one of its child entities when upgrading the cluster.
     *
     * @return the applicationDeltaHealthPolicies value
     */
    public Map<String, ApplicationDeltaHealthPolicy> applicationDeltaHealthPolicies() {
        return this.applicationDeltaHealthPolicies;
    }

    /**
     * Set defines the application delta health policy map used to evaluate the health of an application or one of its child entities when upgrading the cluster.
     *
     * @param applicationDeltaHealthPolicies the applicationDeltaHealthPolicies value to set
     * @return the ClusterUpgradeDeltaHealthPolicy object itself.
     */
    public ClusterUpgradeDeltaHealthPolicy withApplicationDeltaHealthPolicies(Map<String, ApplicationDeltaHealthPolicy> applicationDeltaHealthPolicies) {
        this.applicationDeltaHealthPolicies = applicationDeltaHealthPolicies;
        return this;
    }

}
