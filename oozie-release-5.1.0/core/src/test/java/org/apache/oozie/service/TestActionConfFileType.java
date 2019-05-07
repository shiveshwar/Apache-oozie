/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.oozie.service;

import org.apache.oozie.test.XTestCase;

public class TestActionConfFileType extends XTestCase {

    private static final String XML_FILE = "a.xml";
    private static final String PROPERTIES_FILE = "b.properties";
    private static final String JSON_FILE = "c.json";

    public void testIsSupportedFileType() {
        assertTrue(ActionConfFileType.isSupportedFileType(XML_FILE));
        assertTrue(ActionConfFileType.isSupportedFileType(PROPERTIES_FILE));
        assertFalse(ActionConfFileType.isSupportedFileType(JSON_FILE));
    }

    public void testGetFileType() {
        assertEquals(ActionConfFileType.XML, ActionConfFileType.getFileType(XML_FILE));
        assertEquals(ActionConfFileType.PROPERTIES, ActionConfFileType.getFileType(PROPERTIES_FILE));

        try {
            ActionConfFileType.getFileType(JSON_FILE);
            fail("Should throw exception");
        }
        catch (Throwable e) {
            assertTrue(e.getMessage().contains("Unsupported action conf file extension for file"));
        }
    }

    public void testGetExtension() {
        assertEquals(".xml", ActionConfFileType.XML.getExtension());
        assertEquals(".properties", ActionConfFileType.PROPERTIES.getExtension());
    }
}
