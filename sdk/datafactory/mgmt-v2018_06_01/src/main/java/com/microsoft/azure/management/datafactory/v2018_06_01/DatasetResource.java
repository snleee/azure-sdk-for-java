/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.datafactory.v2018_06_01.implementation.DatasetResourceInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.datafactory.v2018_06_01.implementation.DataFactoryManager;
import com.microsoft.azure.management.datafactory.v2018_06_01.implementation.DatasetInner;
import java.util.Map;
import java.util.List;

/**
 * Type representing DatasetResource.
 */
public interface DatasetResource extends HasInner<DatasetResourceInner>, Indexable, Refreshable<DatasetResource>, Updatable<DatasetResource.Update>, HasManager<DataFactoryManager> {
    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    DatasetInner properties();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the DatasetResource definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithFactory, DefinitionStages.WithIfMatch, DefinitionStages.WithProperties, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of DatasetResource definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a DatasetResource definition.
         */
        interface Blank extends WithFactory {
        }

        /**
         * The stage of the datasetresource definition allowing to specify Factory.
         */
        interface WithFactory {
           /**
            * Specifies resourceGroupName, factoryName.
            * @param resourceGroupName The resource group name
            * @param factoryName The factory name
            * @return the next definition stage
            */
            WithIfMatch withExistingFactory(String resourceGroupName, String factoryName);
        }

        /**
         * The stage of the datasetresource definition allowing to specify IfMatch.
         */
        interface WithIfMatch {
           /**
            * Specifies ifMatch.
            * @param ifMatch ETag of the dataset entity.  Should only be specified for update, for which it should match existing entity or can be * for unconditional update
            * @return the next definition stage
            */
            WithProperties withIfMatch(String ifMatch);
        }

        /**
         * The stage of the datasetresource definition allowing to specify Properties.
         */
        interface WithProperties {
           /**
            * Specifies properties.
            * @param properties Dataset properties
            * @return the next definition stage
            */
            WithCreate withProperties(DatasetInner properties);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<DatasetResource> {
        }
    }
    /**
     * The template for a DatasetResource update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<DatasetResource>, UpdateStages.WithIfMatch, UpdateStages.WithProperties {
    }

    /**
     * Grouping of DatasetResource update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the datasetresource update allowing to specify IfMatch.
         */
        interface WithIfMatch {
            /**
             * Specifies ifMatch.
             * @param ifMatch ETag of the dataset entity.  Should only be specified for update, for which it should match existing entity or can be * for unconditional update
             * @return the next update stage
             */
            Update withIfMatch(String ifMatch);
        }

        /**
         * The stage of the datasetresource update allowing to specify Properties.
         */
        interface WithProperties {
            /**
             * Specifies properties.
             * @param properties Dataset properties
             * @return the next update stage
             */
            Update withProperties(DatasetInner properties);
        }

    }
}
