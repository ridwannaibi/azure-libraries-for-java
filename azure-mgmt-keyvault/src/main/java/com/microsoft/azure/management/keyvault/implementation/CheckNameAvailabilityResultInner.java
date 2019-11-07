/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.keyvault.implementation;

import com.microsoft.azure.management.keyvault.Reason;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The CheckNameAvailability operation response.
 */
public class CheckNameAvailabilityResultInner {
    /**
     * A boolean value that indicates whether the name is available for you to
     * use. If true, the name is available. If false, the name has already been
     * taken or is invalid and cannot be used.
     */
    @JsonProperty(value = "nameAvailable", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean nameAvailable;

    /**
     * The reason that a vault name could not be used. The Reason element is
     * only returned if NameAvailable is false. Possible values include:
     * 'AccountNameInvalid', 'AlreadyExists'.
     */
    @JsonProperty(value = "reason", access = JsonProperty.Access.WRITE_ONLY)
    private Reason reason;

    /**
     * An error message explaining the Reason value in more detail.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * Get the nameAvailable value.
     *
     * @return the nameAvailable value
     */
    public Boolean nameAvailable() {
        return this.nameAvailable;
    }

    /**
     * Get the reason value.
     *
     * @return the reason value
     */
    public Reason reason() {
        return this.reason;
    }

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

}