/*
 * Copyright 2018 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onap.vfc.nfvo.resmanagement.service.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSONObject;

public class NsEntityTest {

    private NsEntity nsEntity;

    @Before
    public void setUp() {
        nsEntity = new NsEntity();
    }

    @Test
    public void testPortEntiry() {
        nsEntity.setId("id");
        nsEntity.setName("name");
        nsEntity.setNsdId("nsdId");
        nsEntity.setDescription("description");
        nsEntity.setStatus("status");
        nsEntity.setCreateTime("createTime");
        nsEntity.setLastUpdate("lastUpdate");
        nsEntity.setResourceVersion("resourceVersion");
        assertTrue(nsEntity.toString() != null);
        assertNotNull(nsEntity.toEntity(new JSONObject()));
        assertNotNull(nsEntity.toStringForAai());
    }

    @Test
    public void testToStringForAai() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("service-instance-id", "service-instance-id");
        jsonObject.put("service-instance-name", "service-instance-name");
        jsonObject.put("description", "description");
        jsonObject.put("orchestration-status", "orchestration-status");
        jsonObject.put("created-at", "created-at");
        jsonObject.put("updated-at", "updated-at");
        jsonObject.put("resource-version", "resource-version");
        assertNotNull(nsEntity.toEntityFromAai(jsonObject));
    }
}
