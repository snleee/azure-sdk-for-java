/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnitsCreateOrUpdateHeaders;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseWithHeaders;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ServiceUnits.
 */
public class ServiceUnitsInner {
    /** The Retrofit service to perform REST calls. */
    private ServiceUnitsService service;
    /** The service client containing this operation class. */
    private AzureDeploymentManagerImpl client;

    /**
     * Initializes an instance of ServiceUnitsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ServiceUnitsInner(Retrofit retrofit, AzureDeploymentManagerImpl client) {
        this.service = retrofit.create(ServiceUnitsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ServiceUnits to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ServiceUnitsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnits createOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager/serviceTopologies/{serviceTopologyName}/services/{serviceName}/serviceUnits/{serviceUnitName}")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serviceTopologyName") String serviceTopologyName, @Path("serviceName") String serviceName, @Path("serviceUnitName") String serviceUnitName, @Query("api-version") String apiVersion, @Body ServiceUnitResourceInner serviceUnitInfo, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnits beginCreateOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager/serviceTopologies/{serviceTopologyName}/services/{serviceName}/serviceUnits/{serviceUnitName}")
        Observable<Response<ResponseBody>> beginCreateOrUpdate(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serviceTopologyName") String serviceTopologyName, @Path("serviceName") String serviceName, @Path("serviceUnitName") String serviceUnitName, @Query("api-version") String apiVersion, @Body ServiceUnitResourceInner serviceUnitInfo, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnits get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager/serviceTopologies/{serviceTopologyName}/services/{serviceName}/serviceUnits/{serviceUnitName}")
        Observable<Response<ResponseBody>> get(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serviceTopologyName") String serviceTopologyName, @Path("serviceName") String serviceName, @Path("serviceUnitName") String serviceUnitName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnits delete" })
        @HTTP(path = "subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager/serviceTopologies/{serviceTopologyName}/services/{serviceName}/serviceUnits/{serviceUnitName}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serviceTopologyName") String serviceTopologyName, @Path("serviceName") String serviceName, @Path("serviceUnitName") String serviceUnitName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.deploymentmanager.v2019_11_01_preview.ServiceUnits list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DeploymentManager/serviceTopologies/{serviceTopologyName}/services/{serviceName}/serviceUnits")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serviceTopologyName") String serviceTopologyName, @Path("serviceName") String serviceName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ServiceUnitResourceInner object if successful.
     */
    public ServiceUnitResourceInner createOrUpdate(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo).toBlocking().last().body();
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ServiceUnitResourceInner> createOrUpdateAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo, final ServiceCallback<ServiceUnitResourceInner> serviceCallback) {
        return ServiceFuture.fromHeaderResponse(createOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo), serviceCallback);
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    public Observable<ServiceUnitResourceInner> createOrUpdateAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo).map(new Func1<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>, ServiceUnitResourceInner>() {
            @Override
            public ServiceUnitResourceInner call(ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders> response) {
                return response.body();
            }
        });
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    public Observable<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>> createOrUpdateWithServiceResponseAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serviceTopologyName == null) {
            throw new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null.");
        }
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (serviceUnitName == null) {
            throw new IllegalArgumentException("Parameter serviceUnitName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (serviceUnitInfo == null) {
            throw new IllegalArgumentException("Parameter serviceUnitInfo is required and cannot be null.");
        }
        Validator.validate(serviceUnitInfo);
        Observable<Response<ResponseBody>> observable = service.createOrUpdate(this.client.subscriptionId(), resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, this.client.apiVersion(), serviceUnitInfo, this.client.acceptLanguage(), this.client.userAgent());
        return client.getAzureClient().getPutOrPatchResultWithHeadersAsync(observable, new TypeToken<ServiceUnitResourceInner>() { }.getType(), ServiceUnitsCreateOrUpdateHeaders.class);
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ServiceUnitResourceInner object if successful.
     */
    public ServiceUnitResourceInner beginCreateOrUpdate(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        return beginCreateOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo).toBlocking().single().body();
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ServiceUnitResourceInner> beginCreateOrUpdateAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo, final ServiceCallback<ServiceUnitResourceInner> serviceCallback) {
        return ServiceFuture.fromHeaderResponse(beginCreateOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo), serviceCallback);
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceUnitResourceInner object
     */
    public Observable<ServiceUnitResourceInner> beginCreateOrUpdateAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        return beginCreateOrUpdateWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, serviceUnitInfo).map(new Func1<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>, ServiceUnitResourceInner>() {
            @Override
            public ServiceUnitResourceInner call(ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders> response) {
                return response.body();
            }
        });
    }

    /**
     * Creates or updates a service unit under the service in the service topology.
     * This is an asynchronous operation and can be polled to completion using the operation resource returned by this operation.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceUnitInfo The service unit resource object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceUnitResourceInner object
     */
    public Observable<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>> beginCreateOrUpdateWithServiceResponseAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, ServiceUnitResourceInner serviceUnitInfo) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serviceTopologyName == null) {
            throw new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null.");
        }
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (serviceUnitName == null) {
            throw new IllegalArgumentException("Parameter serviceUnitName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (serviceUnitInfo == null) {
            throw new IllegalArgumentException("Parameter serviceUnitInfo is required and cannot be null.");
        }
        Validator.validate(serviceUnitInfo);
        return service.beginCreateOrUpdate(this.client.subscriptionId(), resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, this.client.apiVersion(), serviceUnitInfo, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders> clientResponse = beginCreateOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<ServiceUnitResourceInner, ServiceUnitsCreateOrUpdateHeaders> beginCreateOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ServiceUnitResourceInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(201, new TypeToken<ServiceUnitResourceInner>() { }.getType())
                .registerError(CloudException.class)
                .buildWithHeaders(response, ServiceUnitsCreateOrUpdateHeaders.class);
    }

    /**
     * Gets the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ServiceUnitResourceInner object if successful.
     */
    public ServiceUnitResourceInner get(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        return getWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName).toBlocking().single().body();
    }

    /**
     * Gets the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ServiceUnitResourceInner> getAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, final ServiceCallback<ServiceUnitResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName), serviceCallback);
    }

    /**
     * Gets the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceUnitResourceInner object
     */
    public Observable<ServiceUnitResourceInner> getAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        return getWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName).map(new Func1<ServiceResponse<ServiceUnitResourceInner>, ServiceUnitResourceInner>() {
            @Override
            public ServiceUnitResourceInner call(ServiceResponse<ServiceUnitResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceUnitResourceInner object
     */
    public Observable<ServiceResponse<ServiceUnitResourceInner>> getWithServiceResponseAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serviceTopologyName == null) {
            throw new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null.");
        }
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (serviceUnitName == null) {
            throw new IllegalArgumentException("Parameter serviceUnitName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(this.client.subscriptionId(), resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ServiceUnitResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<ServiceUnitResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ServiceUnitResourceInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ServiceUnitResourceInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ServiceUnitResourceInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ServiceUnitResourceInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Deletes the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void delete(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        deleteWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName).toBlocking().single().body();
    }

    /**
     * Deletes the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> deleteAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(deleteWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName), serviceCallback);
    }

    /**
     * Deletes the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> deleteAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        return deleteWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName, serviceUnitName).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     * Deletes the service unit.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceUnitName The name of the service unit resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteWithServiceResponseAsync(String resourceGroupName, String serviceTopologyName, String serviceName, String serviceUnitName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serviceTopologyName == null) {
            throw new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null.");
        }
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (serviceUnitName == null) {
            throw new IllegalArgumentException("Parameter serviceUnitName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.delete(this.client.subscriptionId(), resourceGroupName, serviceTopologyName, serviceName, serviceUnitName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists the service units under a service in the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;ServiceUnitResourceInner&gt; object if successful.
     */
    public List<ServiceUnitResourceInner> list(String resourceGroupName, String serviceTopologyName, String serviceName) {
        return listWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName).toBlocking().single().body();
    }

    /**
     * Lists the service units under a service in the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ServiceUnitResourceInner>> listAsync(String resourceGroupName, String serviceTopologyName, String serviceName, final ServiceCallback<List<ServiceUnitResourceInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName), serviceCallback);
    }

    /**
     * Lists the service units under a service in the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ServiceUnitResourceInner&gt; object
     */
    public Observable<List<ServiceUnitResourceInner>> listAsync(String resourceGroupName, String serviceTopologyName, String serviceName) {
        return listWithServiceResponseAsync(resourceGroupName, serviceTopologyName, serviceName).map(new Func1<ServiceResponse<List<ServiceUnitResourceInner>>, List<ServiceUnitResourceInner>>() {
            @Override
            public List<ServiceUnitResourceInner> call(ServiceResponse<List<ServiceUnitResourceInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Lists the service units under a service in the service topology.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceTopologyName The name of the service topology .
     * @param serviceName The name of the service resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ServiceUnitResourceInner&gt; object
     */
    public Observable<ServiceResponse<List<ServiceUnitResourceInner>>> listWithServiceResponseAsync(String resourceGroupName, String serviceTopologyName, String serviceName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serviceTopologyName == null) {
            throw new IllegalArgumentException("Parameter serviceTopologyName is required and cannot be null.");
        }
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, serviceTopologyName, serviceName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<ServiceUnitResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<ServiceUnitResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<List<ServiceUnitResourceInner>> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<List<ServiceUnitResourceInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<List<ServiceUnitResourceInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<List<ServiceUnitResourceInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
