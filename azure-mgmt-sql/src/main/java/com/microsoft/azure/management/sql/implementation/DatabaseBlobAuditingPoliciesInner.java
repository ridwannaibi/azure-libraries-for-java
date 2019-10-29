/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in DatabaseBlobAuditingPolicies.
 */
public class DatabaseBlobAuditingPoliciesInner {
    /** The Retrofit service to perform REST calls. */
    private DatabaseBlobAuditingPoliciesService service;
    /** The service client containing this operation class. */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of DatabaseBlobAuditingPoliciesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public DatabaseBlobAuditingPoliciesInner(Retrofit retrofit, SqlManagementClientImpl client) {
        this.service = retrofit.create(DatabaseBlobAuditingPoliciesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for DatabaseBlobAuditingPolicies to be
     * used by Retrofit to perform actually REST calls.
     */
    interface DatabaseBlobAuditingPoliciesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.DatabaseBlobAuditingPolicies get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/auditingSettings/{blobAuditingPolicyName}")
        Observable<Response<ResponseBody>> get(@Path("resourceGroupName") String resourceGroupName, @Path("serverName") String serverName, @Path("databaseName") String databaseName, @Path("blobAuditingPolicyName") String blobAuditingPolicyName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.DatabaseBlobAuditingPolicies createOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/auditingSettings/{blobAuditingPolicyName}")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("resourceGroupName") String resourceGroupName, @Path("serverName") String serverName, @Path("databaseName") String databaseName, @Path("blobAuditingPolicyName") String blobAuditingPolicyName, @Path("subscriptionId") String subscriptionId, @Body DatabaseBlobAuditingPolicyInner parameters, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.DatabaseBlobAuditingPolicies listByDatabase" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/auditingSettings")
        Observable<Response<ResponseBody>> listByDatabase(@Path("resourceGroupName") String resourceGroupName, @Path("serverName") String serverName, @Path("databaseName") String databaseName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.DatabaseBlobAuditingPolicies listByDatabaseNext" })
        @GET
        Observable<Response<ResponseBody>> listByDatabaseNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the DatabaseBlobAuditingPolicyInner object if successful.
     */
    public DatabaseBlobAuditingPolicyInner get(String resourceGroupName, String serverName, String databaseName) {
        return getWithServiceResponseAsync(resourceGroupName, serverName, databaseName).toBlocking().single().body();
    }

    /**
     * Gets a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<DatabaseBlobAuditingPolicyInner> getAsync(String resourceGroupName, String serverName, String databaseName, final ServiceCallback<DatabaseBlobAuditingPolicyInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, serverName, databaseName), serviceCallback);
    }

    /**
     * Gets a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DatabaseBlobAuditingPolicyInner object
     */
    public Observable<DatabaseBlobAuditingPolicyInner> getAsync(String resourceGroupName, String serverName, String databaseName) {
        return getWithServiceResponseAsync(resourceGroupName, serverName, databaseName).map(new Func1<ServiceResponse<DatabaseBlobAuditingPolicyInner>, DatabaseBlobAuditingPolicyInner>() {
            @Override
            public DatabaseBlobAuditingPolicyInner call(ServiceResponse<DatabaseBlobAuditingPolicyInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DatabaseBlobAuditingPolicyInner object
     */
    public Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>> getWithServiceResponseAsync(String resourceGroupName, String serverName, String databaseName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serverName == null) {
            throw new IllegalArgumentException("Parameter serverName is required and cannot be null.");
        }
        if (databaseName == null) {
            throw new IllegalArgumentException("Parameter databaseName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String blobAuditingPolicyName = "default";
        final String apiVersion = "2017-03-01-preview";
        return service.get(resourceGroupName, serverName, databaseName, blobAuditingPolicyName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>>>() {
                @Override
                public Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<DatabaseBlobAuditingPolicyInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<DatabaseBlobAuditingPolicyInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<DatabaseBlobAuditingPolicyInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<DatabaseBlobAuditingPolicyInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Creates or updates a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param parameters The database blob auditing policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the DatabaseBlobAuditingPolicyInner object if successful.
     */
    public DatabaseBlobAuditingPolicyInner createOrUpdate(String resourceGroupName, String serverName, String databaseName, DatabaseBlobAuditingPolicyInner parameters) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, serverName, databaseName, parameters).toBlocking().single().body();
    }

    /**
     * Creates or updates a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param parameters The database blob auditing policy.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<DatabaseBlobAuditingPolicyInner> createOrUpdateAsync(String resourceGroupName, String serverName, String databaseName, DatabaseBlobAuditingPolicyInner parameters, final ServiceCallback<DatabaseBlobAuditingPolicyInner> serviceCallback) {
        return ServiceFuture.fromResponse(createOrUpdateWithServiceResponseAsync(resourceGroupName, serverName, databaseName, parameters), serviceCallback);
    }

    /**
     * Creates or updates a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param parameters The database blob auditing policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DatabaseBlobAuditingPolicyInner object
     */
    public Observable<DatabaseBlobAuditingPolicyInner> createOrUpdateAsync(String resourceGroupName, String serverName, String databaseName, DatabaseBlobAuditingPolicyInner parameters) {
        return createOrUpdateWithServiceResponseAsync(resourceGroupName, serverName, databaseName, parameters).map(new Func1<ServiceResponse<DatabaseBlobAuditingPolicyInner>, DatabaseBlobAuditingPolicyInner>() {
            @Override
            public DatabaseBlobAuditingPolicyInner call(ServiceResponse<DatabaseBlobAuditingPolicyInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Creates or updates a database's blob auditing policy.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param parameters The database blob auditing policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the DatabaseBlobAuditingPolicyInner object
     */
    public Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>> createOrUpdateWithServiceResponseAsync(String resourceGroupName, String serverName, String databaseName, DatabaseBlobAuditingPolicyInner parameters) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serverName == null) {
            throw new IllegalArgumentException("Parameter serverName is required and cannot be null.");
        }
        if (databaseName == null) {
            throw new IllegalArgumentException("Parameter databaseName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        Validator.validate(parameters);
        final String blobAuditingPolicyName = "default";
        final String apiVersion = "2017-03-01-preview";
        return service.createOrUpdate(resourceGroupName, serverName, databaseName, blobAuditingPolicyName, this.client.subscriptionId(), parameters, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>>>() {
                @Override
                public Observable<ServiceResponse<DatabaseBlobAuditingPolicyInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<DatabaseBlobAuditingPolicyInner> clientResponse = createOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<DatabaseBlobAuditingPolicyInner> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<DatabaseBlobAuditingPolicyInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<DatabaseBlobAuditingPolicyInner>() { }.getType())
                .register(201, new TypeToken<DatabaseBlobAuditingPolicyInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object if successful.
     */
    public PagedList<DatabaseBlobAuditingPolicyInner> listByDatabase(final String resourceGroupName, final String serverName, final String databaseName) {
        ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> response = listByDatabaseSinglePageAsync(resourceGroupName, serverName, databaseName).toBlocking().single();
        return new PagedList<DatabaseBlobAuditingPolicyInner>(response.body()) {
            @Override
            public Page<DatabaseBlobAuditingPolicyInner> nextPage(String nextPageLink) {
                return listByDatabaseNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<DatabaseBlobAuditingPolicyInner>> listByDatabaseAsync(final String resourceGroupName, final String serverName, final String databaseName, final ListOperationCallback<DatabaseBlobAuditingPolicyInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByDatabaseSinglePageAsync(resourceGroupName, serverName, databaseName),
            new Func1<String, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(String nextPageLink) {
                    return listByDatabaseNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object
     */
    public Observable<Page<DatabaseBlobAuditingPolicyInner>> listByDatabaseAsync(final String resourceGroupName, final String serverName, final String databaseName) {
        return listByDatabaseWithServiceResponseAsync(resourceGroupName, serverName, databaseName)
            .map(new Func1<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>, Page<DatabaseBlobAuditingPolicyInner>>() {
                @Override
                public Page<DatabaseBlobAuditingPolicyInner> call(ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object
     */
    public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> listByDatabaseWithServiceResponseAsync(final String resourceGroupName, final String serverName, final String databaseName) {
        return listByDatabaseSinglePageAsync(resourceGroupName, serverName, databaseName)
            .concatMap(new Func1<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByDatabaseNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists auditing settings of a database.
     *
    ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
    ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> * @param serverName The name of the server.
    ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> listByDatabaseSinglePageAsync(final String resourceGroupName, final String serverName, final String databaseName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serverName == null) {
            throw new IllegalArgumentException("Parameter serverName is required and cannot be null.");
        }
        if (databaseName == null) {
            throw new IllegalArgumentException("Parameter databaseName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2017-03-01-preview";
        return service.listByDatabase(resourceGroupName, serverName, databaseName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> result = listByDatabaseDelegate(response);
                        return Observable.just(new ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> listByDatabaseDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl1<DatabaseBlobAuditingPolicyInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl1<DatabaseBlobAuditingPolicyInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object if successful.
     */
    public PagedList<DatabaseBlobAuditingPolicyInner> listByDatabaseNext(final String nextPageLink) {
        ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> response = listByDatabaseNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<DatabaseBlobAuditingPolicyInner>(response.body()) {
            @Override
            public Page<DatabaseBlobAuditingPolicyInner> nextPage(String nextPageLink) {
                return listByDatabaseNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<DatabaseBlobAuditingPolicyInner>> listByDatabaseNextAsync(final String nextPageLink, final ServiceFuture<List<DatabaseBlobAuditingPolicyInner>> serviceFuture, final ListOperationCallback<DatabaseBlobAuditingPolicyInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByDatabaseNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(String nextPageLink) {
                    return listByDatabaseNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object
     */
    public Observable<Page<DatabaseBlobAuditingPolicyInner>> listByDatabaseNextAsync(final String nextPageLink) {
        return listByDatabaseNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>, Page<DatabaseBlobAuditingPolicyInner>>() {
                @Override
                public Page<DatabaseBlobAuditingPolicyInner> call(ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Lists auditing settings of a database.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object
     */
    public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> listByDatabaseNextWithServiceResponseAsync(final String nextPageLink) {
        return listByDatabaseNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByDatabaseNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Lists auditing settings of a database.
     *
    ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;DatabaseBlobAuditingPolicyInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> listByDatabaseNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listByDatabaseNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> result = listByDatabaseNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<DatabaseBlobAuditingPolicyInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl1<DatabaseBlobAuditingPolicyInner>> listByDatabaseNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl1<DatabaseBlobAuditingPolicyInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl1<DatabaseBlobAuditingPolicyInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
