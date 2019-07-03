/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.siterecovery.v2018_01_10;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for PossibleOperationsDirections.
 */
public final class PossibleOperationsDirections extends ExpandableStringEnum<PossibleOperationsDirections> {
    /** Static value PrimaryToRecovery for PossibleOperationsDirections. */
    public static final PossibleOperationsDirections PRIMARY_TO_RECOVERY = fromString("PrimaryToRecovery");

    /** Static value RecoveryToPrimary for PossibleOperationsDirections. */
    public static final PossibleOperationsDirections RECOVERY_TO_PRIMARY = fromString("RecoveryToPrimary");

    /**
     * Creates or finds a PossibleOperationsDirections from its string representation.
     * @param name a name to look for
     * @return the corresponding PossibleOperationsDirections
     */
    @JsonCreator
    public static PossibleOperationsDirections fromString(String name) {
        return fromString(name, PossibleOperationsDirections.class);
    }

    /**
     * @return known PossibleOperationsDirections values
     */
    public static Collection<PossibleOperationsDirections> values() {
        return values(PossibleOperationsDirections.class);
    }
}