/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import com.microsoft.azure.management.sql.Sku;
import com.microsoft.azure.management.sql.ElasticPoolState;
import org.joda.time.DateTime;
import com.microsoft.azure.management.sql.ElasticPoolPerDatabaseSettings;
import com.microsoft.azure.management.sql.ElasticPoolLicenseType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * An elastic pool.
 */
@JsonFlatten
public class ElasticPoolInner extends Resource {
    /**
     * The elastic pool SKU.
     *
     * The list of SKUs may vary by region and support offer. To determine the
     * SKUs (including the SKU name, tier/edition, family, and capacity) that
     * are available to your subscription in an Azure region, use the
     * `Capabilities_ListByLocation` REST API or the following command:
     *
     * ```azurecli
     * az sql elastic-pool list-editions -l &lt;location&gt; -o table
     * ````.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * Kind of elastic pool. This is metadata used for the Azure portal
     * experience.
     */
    @JsonProperty(value = "kind", access = JsonProperty.Access.WRITE_ONLY)
    private String kind;

    /**
     * The state of the elastic pool. Possible values include: 'Creating',
     * 'Ready', 'Disabled'.
     */
    @JsonProperty(value = "properties.state", access = JsonProperty.Access.WRITE_ONLY)
    private ElasticPoolState state;

    /**
     * The creation date of the elastic pool (ISO8601 format).
     */
    @JsonProperty(value = "properties.creationDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationDate;

    /**
     * The storage limit for the database elastic pool in bytes.
     */
    @JsonProperty(value = "properties.maxSizeBytes")
    private Long maxSizeBytes;

    /**
     * The per database settings for the elastic pool.
     */
    @JsonProperty(value = "properties.perDatabaseSettings")
    private ElasticPoolPerDatabaseSettings perDatabaseSettings;

    /**
     * Whether or not this elastic pool is zone redundant, which means the
     * replicas of this elastic pool will be spread across multiple
     * availability zones.
     */
    @JsonProperty(value = "properties.zoneRedundant")
    private Boolean zoneRedundant;

    /**
     * The license type to apply for this elastic pool. Possible values
     * include: 'LicenseIncluded', 'BasePrice'.
     */
    @JsonProperty(value = "properties.licenseType")
    private ElasticPoolLicenseType licenseType;

    /**
     * Get the elastic pool SKU.
     The list of SKUs may vary by region and support offer. To determine the SKUs (including the SKU name, tier/edition, family, and capacity) that are available to your subscription in an Azure region, use the `Capabilities_ListByLocation` REST API or the following command:
     ```azurecli
     az sql elastic-pool list-editions -l &lt;location&gt; -o table
     ````.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the elastic pool SKU.
     The list of SKUs may vary by region and support offer. To determine the SKUs (including the SKU name, tier/edition, family, and capacity) that are available to your subscription in an Azure region, use the `Capabilities_ListByLocation` REST API or the following command:
     ```azurecli
     az sql elastic-pool list-editions -l &lt;location&gt; -o table
     ````.
     *
     * @param sku the sku value to set
     * @return the ElasticPoolInner object itself.
     */
    public ElasticPoolInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get kind of elastic pool. This is metadata used for the Azure portal experience.
     *
     * @return the kind value
     */
    public String kind() {
        return this.kind;
    }

    /**
     * Get the state of the elastic pool. Possible values include: 'Creating', 'Ready', 'Disabled'.
     *
     * @return the state value
     */
    public ElasticPoolState state() {
        return this.state;
    }

    /**
     * Get the creation date of the elastic pool (ISO8601 format).
     *
     * @return the creationDate value
     */
    public DateTime creationDate() {
        return this.creationDate;
    }

    /**
     * Get the storage limit for the database elastic pool in bytes.
     *
     * @return the maxSizeBytes value
     */
    public Long maxSizeBytes() {
        return this.maxSizeBytes;
    }

    /**
     * Set the storage limit for the database elastic pool in bytes.
     *
     * @param maxSizeBytes the maxSizeBytes value to set
     * @return the ElasticPoolInner object itself.
     */
    public ElasticPoolInner withMaxSizeBytes(Long maxSizeBytes) {
        this.maxSizeBytes = maxSizeBytes;
        return this;
    }

    /**
     * Get the per database settings for the elastic pool.
     *
     * @return the perDatabaseSettings value
     */
    public ElasticPoolPerDatabaseSettings perDatabaseSettings() {
        return this.perDatabaseSettings;
    }

    /**
     * Set the per database settings for the elastic pool.
     *
     * @param perDatabaseSettings the perDatabaseSettings value to set
     * @return the ElasticPoolInner object itself.
     */
    public ElasticPoolInner withPerDatabaseSettings(ElasticPoolPerDatabaseSettings perDatabaseSettings) {
        this.perDatabaseSettings = perDatabaseSettings;
        return this;
    }

    /**
     * Get whether or not this elastic pool is zone redundant, which means the replicas of this elastic pool will be spread across multiple availability zones.
     *
     * @return the zoneRedundant value
     */
    public Boolean zoneRedundant() {
        return this.zoneRedundant;
    }

    /**
     * Set whether or not this elastic pool is zone redundant, which means the replicas of this elastic pool will be spread across multiple availability zones.
     *
     * @param zoneRedundant the zoneRedundant value to set
     * @return the ElasticPoolInner object itself.
     */
    public ElasticPoolInner withZoneRedundant(Boolean zoneRedundant) {
        this.zoneRedundant = zoneRedundant;
        return this;
    }

    /**
     * Get the license type to apply for this elastic pool. Possible values include: 'LicenseIncluded', 'BasePrice'.
     *
     * @return the licenseType value
     */
    public ElasticPoolLicenseType licenseType() {
        return this.licenseType;
    }

    /**
     * Set the license type to apply for this elastic pool. Possible values include: 'LicenseIncluded', 'BasePrice'.
     *
     * @param licenseType the licenseType value to set
     * @return the ElasticPoolInner object itself.
     */
    public ElasticPoolInner withLicenseType(ElasticPoolLicenseType licenseType) {
        this.licenseType = licenseType;
        return this;
    }

}
