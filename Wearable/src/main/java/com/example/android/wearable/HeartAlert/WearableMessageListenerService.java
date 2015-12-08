/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.wearable.HeartAlert;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Listens for a message telling it to start the Wearable MainActivity.
 */
public class WearableMessageListenerService extends WearableListenerService {

    private static final String START_ACTIVITY_PATH = "/start-activity";
    private static final String START_DEMO_PATH = "/start-demo";



    @Override
    public void onMessageReceived(MessageEvent event) {
        if (event.getPath().equals(START_ACTIVITY_PATH)) {
            MainActivity.mDemo = false;
            Intent startIntent = new Intent(this, MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);

        }
        if (event.getPath().equals(START_DEMO_PATH)) {
            MainActivity.mDemo = true;
            Intent startIntent = new Intent(this, MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
            MainActivity.mDemo = false;
        }
    }
}
