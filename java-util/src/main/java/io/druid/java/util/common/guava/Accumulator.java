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

package io.druid.java.util.common.guava;

/**
 */
public interface Accumulator<AccumulatedType, InType>
{
  /**
   * 参数类型通过泛型定义
   * 第一个参数 accumulated保存聚合运算的结果,在调用时作为参数传入,计算完成以后将该参数作为结果返回
   * 并在下一次迭代时作为参数传入
   *
   * 第二个参数 in 是迭代器的下一个元素的值
     */
  AccumulatedType accumulate(AccumulatedType accumulated, InType in);
}
