/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The PrivateEndpointProperty model.
 */
public class PrivateEndpointProperty {
    /**
     * Resource id of the private endpoint.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get resource id of the private endpoint.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set resource id of the private endpoint.
     *
     * @param id the id value to set
     * @return the PrivateEndpointProperty object itself.
     */
    public PrivateEndpointProperty withId(String id) {
        this.id = id;
        return this;
    }

}
