/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for ManagedDatabaseStatus.
 */
public final class ManagedDatabaseStatus extends ExpandableStringEnum<ManagedDatabaseStatus> {
    /** Static value Online for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus ONLINE = fromString("Online");

    /** Static value Offline for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus OFFLINE = fromString("Offline");

    /** Static value Shutdown for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus SHUTDOWN = fromString("Shutdown");

    /** Static value Creating for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus CREATING = fromString("Creating");

    /** Static value Inaccessible for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus INACCESSIBLE = fromString("Inaccessible");

    /** Static value Restoring for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus RESTORING = fromString("Restoring");

    /** Static value Updating for ManagedDatabaseStatus. */
    public static final ManagedDatabaseStatus UPDATING = fromString("Updating");

    /**
     * Creates or finds a ManagedDatabaseStatus from its string representation.
     * @param name a name to look for
     * @return the corresponding ManagedDatabaseStatus
     */
    @JsonCreator
    public static ManagedDatabaseStatus fromString(String name) {
        return fromString(name, ManagedDatabaseStatus.class);
    }

    /**
     * @return known ManagedDatabaseStatus values
     */
    public static Collection<ManagedDatabaseStatus> values() {
        return values(ManagedDatabaseStatus.class);
    }
}
