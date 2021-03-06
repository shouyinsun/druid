/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.timeline;

import io.druid.timeline.partition.PartitionHolder;
import org.joda.time.Interval;

/**
 * 一个 TimelineObjectHolder 对应一个segment
*/
public class TimelineObjectHolder<VersionType, ObjectType> implements LogicalSegment
{
  private final Interval interval;//interval
  private final VersionType version;//版本
  private final PartitionHolder<ObjectType> object;//存放Segment的所有分区

  public TimelineObjectHolder(
      Interval interval,
      VersionType version,
      PartitionHolder<ObjectType> object
  )
  {
    this.interval = interval;
    this.version = version;
    this.object = object;
  }

  @Override
  public Interval getInterval()
  {
    return interval;
  }

  public VersionType getVersion()
  {
    return version;
  }

  public PartitionHolder<ObjectType> getObject()
  {
    return object;
  }

  @Override
  public String toString()
  {
    return "TimelineObjectHolder{" +
           "interval=" + interval +
           ", version=" + version +
           ", object=" + object +
           '}';
  }
}
