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

import android.content.Context;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public class DataStorageImpl implements DataStorage {
    private final Context context;

    DataStorageImpl(Context context) {
        this.context = context;
    }

    @Override
    public Completable store(String storageKey, DataStorageOptions options, String data) {
        return null;
    }

    @Override
    public Completable storeFile(String storageKey, DataStorageOptions options, String publicFilePath) {
        return null;
    }

    @Override
    public Maybe<DataStore> get(String storageKey) {
        return null;
    }

    @Override
    public Maybe<DataStore> getOrSync(String storageKey, boolean syncOnline) {
        return null;
    }

    @Override
    public Observable<DataStore> getAll() {
        return null;
    }

    @Override
    public Single<DataStorageInfo> getDataStorageInfo() {
        return null;
    }

    @Override
    public boolean isDataStoreAvailable() {
        return false;
    }

    @Override
    public Observable<DataStorageStatus> getStorageStatus() {
        return null;
    }
}
