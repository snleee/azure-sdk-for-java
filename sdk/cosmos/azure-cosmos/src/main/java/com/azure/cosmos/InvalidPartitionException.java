// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos;

import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.RMResources;
import com.azure.cosmos.implementation.directconnectivity.HttpUtils;
import com.azure.cosmos.implementation.directconnectivity.WFConstants;
import com.azure.cosmos.implementation.http.HttpHeaders;

import java.util.Map;

/**
 * While this class is public, but it is not part of our published public APIs.
 * This is meant to be internally used only by our sdk.
 */
public class InvalidPartitionException extends CosmosClientException {

    private static final long serialVersionUID = 1L;

    public InvalidPartitionException() {
        this(RMResources.Gone);
    }

    public InvalidPartitionException(CosmosError cosmosError,
                                     long lsn,
                                     String partitionKeyRangeId,
                                     Map<String, String> responseHeaders) {
        super(HttpConstants.StatusCodes.GONE, cosmosError, responseHeaders);
        BridgeInternal.setLSN(this, lsn);
        BridgeInternal.setPartitionKeyRangeId(this, partitionKeyRangeId);
    }

    public InvalidPartitionException(String msg) {
        super(HttpConstants.StatusCodes.GONE, msg);
        setSubStatus();
    }

    public InvalidPartitionException(String msg, String resourceAddress) {
        super(msg, null, null, HttpConstants.StatusCodes.GONE, resourceAddress);
        setSubStatus();
    }

    public InvalidPartitionException(String message, HttpHeaders headers, String requestUri) {
        this(message, null, headers, requestUri);
    }

    InvalidPartitionException(Exception innerException) {
        this(RMResources.Gone, innerException, null, null);
    }

    InvalidPartitionException(String message,
                              Exception innerException,
                              HttpHeaders headers,
                              String requestUri) {
        super(String.format("%s: %s", RMResources.Gone, message),
            innerException,
            HttpUtils.asMap(headers),
            HttpConstants.StatusCodes.GONE,
            requestUri);

        setSubStatus();
    }

    private void setSubStatus() {
        this.getResponseHeaders().put(
            WFConstants.BackendHeaders.SUB_STATUS,
            Integer.toString(HttpConstants.SubStatusCodes.NAME_CACHE_IS_STALE));
    }
}
