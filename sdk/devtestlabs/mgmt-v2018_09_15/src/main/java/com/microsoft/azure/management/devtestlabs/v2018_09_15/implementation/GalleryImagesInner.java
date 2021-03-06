/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in GalleryImages.
 */
public class GalleryImagesInner {
    /** The Retrofit service to perform REST calls. */
    private GalleryImagesService service;
    /** The service client containing this operation class. */
    private DevTestLabsClientImpl client;

    /**
     * Initializes an instance of GalleryImagesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public GalleryImagesInner(Retrofit retrofit, DevTestLabsClientImpl client) {
        this.service = retrofit.create(GalleryImagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for GalleryImages to be
     * used by Retrofit to perform actually REST calls.
     */
    interface GalleryImagesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.devtestlabs.v2018_09_15.GalleryImages list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DevTestLab/labs/{labName}/galleryimages")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("labName") String labName, @Query("$expand") String expand, @Query("$filter") String filter, @Query("$top") Integer top, @Query("$orderby") String orderby, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.devtestlabs.v2018_09_15.GalleryImages listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;GalleryImageInner&gt; object if successful.
     */
    public PagedList<GalleryImageInner> list(final String resourceGroupName, final String labName) {
        ServiceResponse<Page<GalleryImageInner>> response = listSinglePageAsync(resourceGroupName, labName).toBlocking().single();
        return new PagedList<GalleryImageInner>(response.body()) {
            @Override
            public Page<GalleryImageInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<GalleryImageInner>> listAsync(final String resourceGroupName, final String labName, final ListOperationCallback<GalleryImageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(resourceGroupName, labName),
            new Func1<String, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<Page<GalleryImageInner>> listAsync(final String resourceGroupName, final String labName) {
        return listWithServiceResponseAsync(resourceGroupName, labName)
            .map(new Func1<ServiceResponse<Page<GalleryImageInner>>, Page<GalleryImageInner>>() {
                @Override
                public Page<GalleryImageInner> call(ServiceResponse<Page<GalleryImageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listWithServiceResponseAsync(final String resourceGroupName, final String labName) {
        return listSinglePageAsync(resourceGroupName, labName)
            .concatMap(new Func1<ServiceResponse<Page<GalleryImageInner>>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(ServiceResponse<Page<GalleryImageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;GalleryImageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listSinglePageAsync(final String resourceGroupName, final String labName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (labName == null) {
            throw new IllegalArgumentException("Parameter labName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final String expand = null;
        final String filter = null;
        final Integer top = null;
        final String orderby = null;
        return service.list(this.client.subscriptionId(), resourceGroupName, labName, expand, filter, top, orderby, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<GalleryImageInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<GalleryImageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param expand Specify the $expand query. Example: 'properties($select=author)'
     * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName')
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'
     * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;GalleryImageInner&gt; object if successful.
     */
    public PagedList<GalleryImageInner> list(final String resourceGroupName, final String labName, final String expand, final String filter, final Integer top, final String orderby) {
        ServiceResponse<Page<GalleryImageInner>> response = listSinglePageAsync(resourceGroupName, labName, expand, filter, top, orderby).toBlocking().single();
        return new PagedList<GalleryImageInner>(response.body()) {
            @Override
            public Page<GalleryImageInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param expand Specify the $expand query. Example: 'properties($select=author)'
     * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName')
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'
     * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<GalleryImageInner>> listAsync(final String resourceGroupName, final String labName, final String expand, final String filter, final Integer top, final String orderby, final ListOperationCallback<GalleryImageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(resourceGroupName, labName, expand, filter, top, orderby),
            new Func1<String, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param expand Specify the $expand query. Example: 'properties($select=author)'
     * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName')
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'
     * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<Page<GalleryImageInner>> listAsync(final String resourceGroupName, final String labName, final String expand, final String filter, final Integer top, final String orderby) {
        return listWithServiceResponseAsync(resourceGroupName, labName, expand, filter, top, orderby)
            .map(new Func1<ServiceResponse<Page<GalleryImageInner>>, Page<GalleryImageInner>>() {
                @Override
                public Page<GalleryImageInner> call(ServiceResponse<Page<GalleryImageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
     * @param resourceGroupName The name of the resource group.
     * @param labName The name of the lab.
     * @param expand Specify the $expand query. Example: 'properties($select=author)'
     * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName')
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'
     * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listWithServiceResponseAsync(final String resourceGroupName, final String labName, final String expand, final String filter, final Integer top, final String orderby) {
        return listSinglePageAsync(resourceGroupName, labName, expand, filter, top, orderby)
            .concatMap(new Func1<ServiceResponse<Page<GalleryImageInner>>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(ServiceResponse<Page<GalleryImageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
    ServiceResponse<PageImpl<GalleryImageInner>> * @param resourceGroupName The name of the resource group.
    ServiceResponse<PageImpl<GalleryImageInner>> * @param labName The name of the lab.
    ServiceResponse<PageImpl<GalleryImageInner>> * @param expand Specify the $expand query. Example: 'properties($select=author)'
    ServiceResponse<PageImpl<GalleryImageInner>> * @param filter The filter to apply to the operation. Example: '$filter=contains(name,'myName')
    ServiceResponse<PageImpl<GalleryImageInner>> * @param top The maximum number of resources to return from the operation. Example: '$top=10'
    ServiceResponse<PageImpl<GalleryImageInner>> * @param orderby The ordering expression for the results, using OData notation. Example: '$orderby=name desc'
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;GalleryImageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listSinglePageAsync(final String resourceGroupName, final String labName, final String expand, final String filter, final Integer top, final String orderby) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (labName == null) {
            throw new IllegalArgumentException("Parameter labName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, labName, expand, filter, top, orderby, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<GalleryImageInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<GalleryImageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<GalleryImageInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<GalleryImageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<GalleryImageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * List gallery images in a given lab.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;GalleryImageInner&gt; object if successful.
     */
    public PagedList<GalleryImageInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<GalleryImageInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<GalleryImageInner>(response.body()) {
            @Override
            public Page<GalleryImageInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * List gallery images in a given lab.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<GalleryImageInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<GalleryImageInner>> serviceFuture, final ListOperationCallback<GalleryImageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * List gallery images in a given lab.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<Page<GalleryImageInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<GalleryImageInner>>, Page<GalleryImageInner>>() {
                @Override
                public Page<GalleryImageInner> call(ServiceResponse<Page<GalleryImageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;GalleryImageInner&gt; object
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<GalleryImageInner>>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(ServiceResponse<Page<GalleryImageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * List gallery images in a given lab.
     *
    ServiceResponse<PageImpl<GalleryImageInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;GalleryImageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<GalleryImageInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<GalleryImageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<GalleryImageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<GalleryImageInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<GalleryImageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<GalleryImageInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<GalleryImageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<GalleryImageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
