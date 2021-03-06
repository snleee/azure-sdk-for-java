/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.faceapi.models;

import java.util.UUID;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Person object.
 */
public class Person extends NameAndUserDataContract {
    /**
     * PersonId of the target face list.
     */
    @JsonProperty(value = "personId", required = true)
    private UUID personId;

    /**
     * PersistedFaceIds of registered faces in the person. These
     * persistedFaceIds are returned from Person - Add a Person Face, and will
     * not expire.
     */
    @JsonProperty(value = "persistedFaceIds")
    private List<UUID> persistedFaceIds;

    /**
     * Get the personId value.
     *
     * @return the personId value
     */
    public UUID personId() {
        return this.personId;
    }

    /**
     * Set the personId value.
     *
     * @param personId the personId value to set
     * @return the Person object itself.
     */
    public Person withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    /**
     * Get the persistedFaceIds value.
     *
     * @return the persistedFaceIds value
     */
    public List<UUID> persistedFaceIds() {
        return this.persistedFaceIds;
    }

    /**
     * Set the persistedFaceIds value.
     *
     * @param persistedFaceIds the persistedFaceIds value to set
     * @return the Person object itself.
     */
    public Person withPersistedFaceIds(List<UUID> persistedFaceIds) {
        this.persistedFaceIds = persistedFaceIds;
        return this;
    }

}
