/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.rules;

import com.facebook.buck.util.ProjectFilesystem;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

import java.nio.file.Path;

public class DefaultBuildRuleBuilderParams implements AbstractBuildRuleBuilderParams {

  private final ProjectFilesystem projectFilesystem;
  private final RuleKeyBuilderFactory ruleKeyBuilderFactory;

  public DefaultBuildRuleBuilderParams(ProjectFilesystem projectFilesystem,
      RuleKeyBuilderFactory ruleKeyBuilderFactory) {
    this.projectFilesystem = Preconditions.checkNotNull(projectFilesystem);
    this.ruleKeyBuilderFactory = Preconditions.checkNotNull(ruleKeyBuilderFactory);
  }

  @Override
  public ProjectFilesystem getProjectFilesystem() {
    return projectFilesystem;
  }

  @Override
  public Function<Path, Path> getPathAbsolutifier() {
    return projectFilesystem.getAbsolutifier();
  }

  @Override
  public RuleKeyBuilderFactory getRuleKeyBuilderFactory() {
    return ruleKeyBuilderFactory;
  }

}
