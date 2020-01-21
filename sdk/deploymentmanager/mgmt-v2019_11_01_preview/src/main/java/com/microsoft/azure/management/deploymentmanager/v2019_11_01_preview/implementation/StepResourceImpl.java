/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.StepResource;
import rx.Observable;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.StepProperties;

class StepResourceImpl extends GroupableResourceCoreImpl<StepResource, StepResourceInner, StepResourceImpl, DeploymentManagerManager> implements StepResource, StepResource.Definition, StepResource.Update {
    StepResourceImpl(String name, StepResourceInner inner, DeploymentManagerManager manager) {
        super(name, inner, manager);
    }

    @Override
    public Observable<StepResource> createResourceAsync() {
        StepsInner client = this.manager().inner().steps();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<StepResource> updateResourceAsync() {
        StepsInner client = this.manager().inner().steps();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<StepResourceInner> getInnerAsync() {
        StepsInner client = this.manager().inner().steps();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public StepProperties properties() {
        return this.inner().properties();
    }

    @Override
    public StepResourceImpl withProperties(StepProperties properties) {
        this.inner().withProperties(properties);
        return this;
    }

}
