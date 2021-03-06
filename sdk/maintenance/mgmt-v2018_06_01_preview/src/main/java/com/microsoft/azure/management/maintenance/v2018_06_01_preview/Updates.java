/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.maintenance.v2018_06_01_preview;

import rx.Observable;

/**
 * Type representing Updates.
 */
public interface Updates {
    /**
     * Get Updates to resource.
     * Get updates to resources.
     *
     * @param resourceGroupName Resource group name
     * @param providerName Resource provider name
     * @param resourceParentType Resource parent type
     * @param resourceParentName Resource parent identifier
     * @param resourceType Resource type
     * @param resourceName Resource identifier
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Update> listParentAsync(String resourceGroupName, String providerName, String resourceParentType, String resourceParentName, String resourceType, String resourceName);

    /**
     * Get Updates to resource.
     * Get updates to resources.
     *
     * @param resourceGroupName Resource group name
     * @param providerName Resource provider name
     * @param resourceType Resource type
     * @param resourceName Resource identifier
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Update> listAsync(String resourceGroupName, String providerName, String resourceType, String resourceName);

}
