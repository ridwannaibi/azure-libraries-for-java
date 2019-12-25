/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Application logs to file system configuration.
 */
public class FileSystemApplicationLogsConfig {
    /**
     * Log level. Possible values include: 'Off', 'Verbose', 'Information',
     * 'Warning', 'Error'.
     */
    @JsonProperty(value = "level")
    private LogLevel level;

    /**
     * Get log level. Possible values include: 'Off', 'Verbose', 'Information', 'Warning', 'Error'.
     *
     * @return the level value
     */
    public LogLevel level() {
        return this.level;
    }

    /**
     * Set log level. Possible values include: 'Off', 'Verbose', 'Information', 'Warning', 'Error'.
     *
     * @param level the level value to set
     * @return the FileSystemApplicationLogsConfig object itself.
     */
    public FileSystemApplicationLogsConfig withLevel(LogLevel level) {
        this.level = level;
        return this;
    }

}