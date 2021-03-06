/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.Services;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceResource;

class ServicesImpl extends WrapperImpl<ServicesInner> implements Services {
    private final DeploymentManagerManager manager;

    ServicesImpl(DeploymentManagerManager manager) {
        super(manager.inner().services());
        this.manager = manager;
    }

    public DeploymentManagerManager manager() {
        return this.manager;
    }

    @Override
    public ServiceResourceImpl define(String name) {
        return wrapModel(name);
    }

    private ServiceResourceImpl wrapModel(ServiceResourceInner inner) {
        return  new ServiceResourceImpl(inner, manager());
    }

    private ServiceResourceImpl wrapModel(String name) {
        return new ServiceResourceImpl(name, this.manager());
    }

    @Override
    public Observable<ServiceResource> listAsync(String resourceGroupName, String serviceTopologyName) {
        ServicesInner client = this.inner();
        return client.listAsync(resourceGroupName, serviceTopologyName)
        .flatMap(new Func1<List<ServiceResourceInner>, Observable<ServiceResourceInner>>() {
            @Override
            public Observable<ServiceResourceInner> call(List<ServiceResourceInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<ServiceResourceInner, ServiceResource>() {
            @Override
            public ServiceResource call(ServiceResourceInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<ServiceResource> getAsync(String resourceGroupName, String serviceTopologyName, String serviceName) {
        ServicesInner client = this.inner();
        return client.getAsync(resourceGroupName, serviceTopologyName, serviceName)
        .flatMap(new Func1<ServiceResourceInner, Observable<ServiceResource>>() {
            @Override
            public Observable<ServiceResource> call(ServiceResourceInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((ServiceResource)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serviceTopologyName, String serviceName) {
        ServicesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serviceTopologyName, serviceName).toCompletable();
    }

}
