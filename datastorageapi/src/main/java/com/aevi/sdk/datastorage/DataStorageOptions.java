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

import com.aevi.util.json.JsonConverter;
import com.aevi.util.json.Jsonable;


public class DataStorageOptions implements Jsonable {

    public static final String ACCESS_PUBLIC = "public";
    public static final String ACCESS_PRIVATE = "private";
    public static final String ACCESS_PROTECTECD = "protected";

    public final String packageName;
    public String category;
    public String access;
    public String[] protectedPackages;
    public boolean storeOnline;

    private DataStorageOptions(Context context) {
        packageName = context.getPackageName();
    }

    public String getPackageName() {
        return packageName;
    }

    public String getCategory() {
        return category;
    }

    public String getAccess() {
        return access;
    }

    public String[] getProtectedPackages() {
        return protectedPackages;
    }

    public boolean isStoreOnline() {
        return storeOnline;
    }

    @Override
    public String toJson() {
        return JsonConverter.serialize(this);
    }

    public static DataStorageOptions fromJson(String json) {
        return JsonConverter.deserialize(json, DataStorageOptions.class);
    }
}
