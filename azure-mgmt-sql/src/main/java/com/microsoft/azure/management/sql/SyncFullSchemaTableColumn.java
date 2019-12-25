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
 * Properties of the column in the table of database full schema.
 */
public class SyncFullSchemaTableColumn {
    /**
     * Data size of the column.
     */
    @JsonProperty(value = "dataSize", access = JsonProperty.Access.WRITE_ONLY)
    private String dataSize;

    /**
     * Data type of the column.
     */
    @JsonProperty(value = "dataType", access = JsonProperty.Access.WRITE_ONLY)
    private String dataType;

    /**
     * Error id of the column.
     */
    @JsonProperty(value = "errorId", access = JsonProperty.Access.WRITE_ONLY)
    private String errorId;

    /**
     * If there is error in the table.
     */
    @JsonProperty(value = "hasError", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean hasError;

    /**
     * If it is the primary key of the table.
     */
    @JsonProperty(value = "isPrimaryKey", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isPrimaryKey;

    /**
     * Name of the column.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * Quoted name of the column.
     */
    @JsonProperty(value = "quotedName", access = JsonProperty.Access.WRITE_ONLY)
    private String quotedName;

    /**
     * Get data size of the column.
     *
     * @return the dataSize value
     */
    public String dataSize() {
        return this.dataSize;
    }

    /**
     * Get data type of the column.
     *
     * @return the dataType value
     */
    public String dataType() {
        return this.dataType;
    }

    /**
     * Get error id of the column.
     *
     * @return the errorId value
     */
    public String errorId() {
        return this.errorId;
    }

    /**
     * Get if there is error in the table.
     *
     * @return the hasError value
     */
    public Boolean hasError() {
        return this.hasError;
    }

    /**
     * Get if it is the primary key of the table.
     *
     * @return the isPrimaryKey value
     */
    public Boolean isPrimaryKey() {
        return this.isPrimaryKey;
    }

    /**
     * Get name of the column.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get quoted name of the column.
     *
     * @return the quotedName value
     */
    public String quotedName() {
        return this.quotedName;
    }

}