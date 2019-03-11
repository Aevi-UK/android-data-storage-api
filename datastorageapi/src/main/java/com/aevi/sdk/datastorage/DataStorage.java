/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aevi.sdk.datastorage;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * The interface to a storage application.
 *
 * All data will be stored against the application (package name) that stored it. Data can be set as public, private or shared with specific
 * applications through the use of {@link DataStorageOptions} object. The storing application can also allow the data to be stored online as well as
 * locally. The implemented storage application will decide how and when to upload the data to any such online storage.
 */
public interface DataStorage {

    /**
     * Store some String'ified data to the store
     *
     * @param storageKey The key name under which to store the data for retrieval later
     * @param options    An options object defining how and where the data can be stored
     * @param data       The data to be stored
     * @return A completable that will complete when the data has been sent to the storage application successfully
     */
    Completable store(String storageKey, DataStorageOptions options, String data);

    /**
     * Store some file data to the store
     *
     * @param storageKey     The key name under which to store the data for retrieval later
     * @param options        An options object defining how and where the data can be stored
     * @param publicFilePath A public path of the file to be stored
     * @return A completable that will complete when the data has been sent to the storage application successfully
     */
    Completable storeFile(String storageKey, DataStorageOptions options, String publicFilePath);

    /**
     * Returns some data for the the storageKey given if found
     *
     * @param storageKey The key to look for in the store
     * @return A Maybe that will return a {@link DataStore} object if one is found in the store or nothing if not found
     */
    Maybe<DataStore> get(String storageKey);

    /**
     * Returns some String'ified data for the the storageKey given if found. If a local version of the data requested is not found. This call will
     * search online storage for the data synchronise it to this device (if found) and return it via this method.
     *
     * NOTE: Calls to this method should not be performed on the UI thread as it may take some time to complete.
     *
     * @param storageKey The key to look for in the store
     * @param syncOnline If set to true and
     * @return A Maybe that will return a {@link DataStore} object if one is found in the store or nothing if not found
     */
    Maybe<DataStore> getOrSync(String storageKey, boolean syncOnline);

    /**
     * This method is only callable by the device owner (AEVI Agent)
     *
     * @return A stream of {@link DataStore} objects
     */
    Observable<DataStore> getAll();

    /**
     * Returns information about the storage application
     *
     * @return A {@link DataStorageInfo} object containing information about the store itself
     */
    Single<DataStorageInfo> getDataStorageInfo();

    /**
     * Returns true if there is an AEVI data store application on this device
     *
     * @return True if a store is available
     */
    boolean isDataStoreAvailable();

    /**
     * A stream of {@link DataStorageStatus} objects indicating the current status of the store e.g. last online storage time etc.
     *
     * @return A stream of {@link DataStorageStatus} objects
     */
    Observable<DataStorageStatus> getStorageStatus();
}
