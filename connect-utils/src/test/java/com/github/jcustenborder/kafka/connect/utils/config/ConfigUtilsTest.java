/**
 * Copyright © 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.connect.utils.config;

import com.github.jcustenborder.kafka.connect.utils.config.ConfigUtilsTestConfig.EnumTest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.net.HostAndPort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigUtilsTest {


  @Test
  public void getEnums() {
    ConfigUtilsTestConfig config = new ConfigUtilsTestConfig(
        ImmutableMap.of()
    );
    List<EnumTest> actual = ConfigUtils.getEnums(EnumTest.class, config, ConfigUtilsTestConfig.ENUMS_VALUE_CONF);
    assertEquals(ImmutableList.of(EnumTest.ONE), actual);
  }

  @Test
  public void testDefaultPortHostConfig() {
    HostAndPort hostAndPort = ConfigUtils.hostAndPort("123.4.2.3", 6432);
    HostAndPort intended = HostAndPort.fromString("123.4.2.3:6432");
    assertEquals(hostAndPort, intended);
  }

}
