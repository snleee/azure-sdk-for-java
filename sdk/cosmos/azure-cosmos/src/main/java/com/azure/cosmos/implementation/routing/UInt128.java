// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.routing;

class UInt128 {
    long low;
    long high;

    UInt128(long x, long y) {
        this.low = x;
        this.high = y;
    }
}
