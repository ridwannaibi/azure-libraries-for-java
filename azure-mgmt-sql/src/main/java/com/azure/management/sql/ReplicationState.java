// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.sql;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/**
 * Defines values for ReplicationState.
 */
public final class ReplicationState extends ExpandableStringEnum<ReplicationState> {
    /**
     * Static value PENDING for ReplicationState.
     */
    public static final ReplicationState PENDING = fromString("PENDING");

    /**
     * Static value SEEDING for ReplicationState.
     */
    public static final ReplicationState SEEDING = fromString("SEEDING");

    /**
     * Static value CATCH_UP for ReplicationState.
     */
    public static final ReplicationState CATCH_UP = fromString("CATCH_UP");

    /**
     * Static value SUSPENDED for ReplicationState.
     */
    public static final ReplicationState SUSPENDED = fromString("SUSPENDED");

    /**
     * Creates or finds a ReplicationState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ReplicationState.
     */
    @JsonCreator
    public static ReplicationState fromString(String name) {
        return fromString(name, ReplicationState.class);
    }

    /**
     * @return known ReplicationState values.
     */
    public static Collection<ReplicationState> values() {
        return values(ReplicationState.class);
    }
}