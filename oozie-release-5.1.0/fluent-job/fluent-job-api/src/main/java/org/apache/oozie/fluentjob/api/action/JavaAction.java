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

package org.apache.oozie.fluentjob.api.action;

import com.google.common.collect.ImmutableList;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;

import java.util.List;
import java.util.Map;

/**
 * A class representing the Oozie Java action.
 * Instances of this class should be built using the builder {@link JavaActionBuilder}.
 *
 * The properties of the builder can only be set once, an attempt to set them a second time will trigger
 * an {@link IllegalStateException}.
 *
 * Builder instances can be used to build several elements, although properties already set cannot be changed after
 * a call to {@link JavaActionBuilder#build} either.
 */
@InterfaceAudience.Private
@InterfaceStability.Unstable
public class JavaAction extends Node {
    private final ActionAttributes attributes;
    private final String mainClass;
    private final String javaOptsString;
    private final ImmutableList<String> javaOpts;


    JavaAction(final ConstructionData constructionData,
               final ActionAttributes attributes,
               final String mainClass,
               final String javaOptsString,
               final ImmutableList<String> javaOpts) {
        super(constructionData);

        this.attributes = attributes;
        this.mainClass = mainClass;
        this.javaOptsString = javaOptsString;
        this.javaOpts = javaOpts;
    }

    public String getResourceManager() {
        return attributes.getResourceManager();
    }

    public String getNameNode() {
        return attributes.getNameNode();
    }

    public Prepare getPrepare() {
        return attributes.getPrepare();
    }

    public Launcher getLauncher() {
        return attributes.getLauncher();
    }

    public List<String> getJobXmls() {
        return attributes.getJobXmls();
    }

    public String getConfigProperty(final String property) {
        return attributes.getConfiguration().get(property);
    }

    public Map<String, String> getConfiguration() {
        return attributes.getConfiguration();
    }

    public String getMainClass() {
        return mainClass;
    }

    public String getJavaOptsString() {
        return javaOptsString;
    }

    public List<String> getJavaOpts() {
        return javaOpts;
    }

    public List<String> getArgs() {
        return attributes.getArgs();
    }

    public List<String> getFiles() {
        return attributes.getFiles();
    }

    public List<String> getArchives() {
        return attributes.getArchives();
    }

    public boolean isCaptureOutput() {
        return attributes.isCaptureOutput();
    }

    ActionAttributes getAttributes() {
        return attributes;
    }
}