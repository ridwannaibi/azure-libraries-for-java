/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.fluentcore.arm.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.microsoft.azure.management.resources.fluentcore.utils.AuxiliaryCredentialsInterceptor;
import com.microsoft.azure.management.resources.fluentcore.utils.ProviderRegistrationInterceptor;
import com.microsoft.azure.management.resources.fluentcore.utils.ResourceManagerThrottlingInterceptor;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.LogLevel;
import com.microsoft.rest.RestClient;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.Protocol;

import java.net.Proxy;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * The implementation for {@link AzureConfigurable<T>} and the base class for
 * configurable implementations.
 *
 * @param <T> the type of the configurable interface
 */
public class AzureConfigurableImpl<T extends AzureConfigurable<T>>
        implements AzureConfigurable<T> {
    protected RestClient.Builder restClientBuilder;

    protected AzureConfigurableImpl() {
        this.restClientBuilder = new RestClient.Builder()
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory());
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withLogLevel(LogLevel level) {
        this.restClientBuilder = this.restClientBuilder.withLogLevel(level);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withInterceptor(Interceptor interceptor) {
        this.restClientBuilder = this.restClientBuilder.withInterceptor(interceptor);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withAuxiliaryCredentials(AzureTokenCredentials... tokens) {
        if (tokens != null) {
            if (tokens.length > 3) {
                throw new IllegalArgumentException("Only can hold up to three auxiliary tokens.");
            }
            AuxiliaryCredentialsInterceptor interceptor = new AuxiliaryCredentialsInterceptor(tokens);
            this.restClientBuilder = this.restClientBuilder.withInterceptor(interceptor);
        }
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withUserAgent(String userAgent) {
        this.restClientBuilder = this.restClientBuilder.withUserAgent(userAgent);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withReadTimeout(long timeout, TimeUnit unit) {
        this.restClientBuilder = restClientBuilder.withReadTimeout(timeout, unit);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withConnectionTimeout(long timeout, TimeUnit unit) {
        this.restClientBuilder = restClientBuilder.withConnectionTimeout(timeout, unit);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withMaxIdleConnections(int maxIdleConnections) {
        this.restClientBuilder = restClientBuilder.withMaxIdleConnections(maxIdleConnections);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withConnectionPool(ConnectionPool connectionPool) {
        this.restClientBuilder = restClientBuilder.withConnectionPool(connectionPool);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T useHttpClientThreadPool(boolean useHttpClientThreadPool) {
        this.restClientBuilder = restClientBuilder.useHttpClientThreadPool(useHttpClientThreadPool);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withDispatcher(Dispatcher dispatcher) {
        this.restClientBuilder = restClientBuilder.withDispatcher(dispatcher);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withCallbackExecutor(Executor executor) {
        this.restClientBuilder = restClientBuilder.withCallbackExecutor(executor);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withProxy(Proxy proxy) {
        this.restClientBuilder = restClientBuilder.withProxy(proxy);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withProxyAuthenticator(Authenticator proxyAuthenticator) {
        this.restClientBuilder = restClientBuilder.withProxyAuthenticator(proxyAuthenticator);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T withProtocols(List<Protocol> protocols) {
        this.restClientBuilder.withProtocols(protocols);
        return (T) this;
    }

    protected RestClient buildRestClient(AzureTokenCredentials credentials, AzureEnvironment.Endpoint endpoint) {
        RestClient client =  restClientBuilder
                .withBaseUrl(credentials.environment(), endpoint)
                .withCredentials(credentials)
                .withInterceptor(new ProviderRegistrationInterceptor(credentials))
                .withInterceptor(new ResourceManagerThrottlingInterceptor())
                .build();
        if (client.httpClient().proxy() != null) {
            credentials.withProxy(client.httpClient().proxy());
        }
        return client;
    }

    protected RestClient buildRestClient(AzureTokenCredentials credentials) {
        return buildRestClient(credentials, AzureEnvironment.Endpoint.RESOURCE_MANAGER);
    }
}
