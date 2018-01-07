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

package io.druid.segment;

import org.joda.time.DateTime;

/**
 * 迭代遍历相关
 */

public interface Cursor
{
  ColumnSelectorFactory getColumnSelectorFactory();
  DateTime getTime();//当前行的时间
  void advance();//类似next方法,指向下一行
  void advanceUninterruptibly();
  void advanceTo(int offset);//跳到指定偏移行
  boolean isDone();//判断游标是否结束
  boolean isDoneOrInterrupted();
  void reset();//重置游标到初始偏移处
}
