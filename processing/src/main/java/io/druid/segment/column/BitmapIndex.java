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

package io.druid.segment.column;

import io.druid.collections.bitmap.BitmapFactory;
import io.druid.collections.bitmap.ImmutableBitmap;

/**
 * BitmapIndex druid的核心结构,用户构造字符串类型列的索引
 * 每个列值都创建一个ImmutableBitmap,每个列值都有一个索引号 idx
 * 内部通常使用idx获取Bitmap,Bitmap的对象由BitmapFactory生成
 *
 *
 */
public interface BitmapIndex
{
  int getCardinality();

  String getValue(int index);

  boolean hasNulls();

  BitmapFactory getBitmapFactory();

  /**
   * Returns the index of "value" in this BitmapIndex, or (-(insertion point) - 1) if the value is not
   * present, in the manner of Arrays.binarySearch.
   *
   * @param value value to search for
   * @return index of value, or negative number equal to (-(insertion point) - 1).
   */
  int getIndex(String value);

  ImmutableBitmap getBitmap(int idx);
}
