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

package io.druid.query;

import org.joda.time.Interval;

/**
 * 针对传入的多个interval 或者 多个segment 构建 QueryRunner
 *
 * 每种类型的节点的 QuerySegmentWalker 实现不同
 *
 * 历史节点的实现是 ServerManager
 * 查询节点的实现是 ClientQuerySegmentWalker
 * 统治节点的实现是 ThreadPoolTaskRunner
 * 实时节点的实现是 RealtimeManager
 *
 *
 */
public interface QuerySegmentWalker
{
  /**
   * Gets the Queryable for a given interval, the Queryable returned can be any version(s) or partitionNumber(s)
   * such that it represents the interval.
   *
   * @param <T> query result type
   * @param query the query to find a Queryable for
   * @param intervals the intervals to find a Queryable for
   * @return a Queryable object that represents the interval
   */
  <T> QueryRunner<T> getQueryRunnerForIntervals(Query<T> query, Iterable<Interval> intervals);

  /**
   * Gets the Queryable for a given list of SegmentSpecs.
   *
   * @param <T> the query result type
   * @param query the query to return a Queryable for
   * @param specs the list of SegmentSpecs to find a Queryable for
   * @return the Queryable object with the given SegmentSpecs
   */
  <T> QueryRunner<T> getQueryRunnerForSegments(Query<T> query, Iterable<SegmentDescriptor> specs);
}
