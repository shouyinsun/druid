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

import io.druid.query.extraction.ExtractionFn;
import io.druid.segment.ColumnValueSelector;
import io.druid.segment.DimensionSelector;
import io.druid.segment.data.IndexedInts;
import io.druid.segment.data.ReadableOffset;

import javax.annotation.Nullable;

/**
 * 字典编码索引,druid中的字符创的列实际上使用的都是这种结构
 * getCardinality()方法获取基数
 */
public interface DictionaryEncodedColumn<ActualType extends Comparable> extends BaseColumn
{
  int length();
  boolean hasMultipleValues();
  int getSingleValueRow(int rowNum);
  IndexedInts getMultiValueRow(int rowNum);
  ActualType lookupName(int id);
  int lookupId(ActualType name);
  int getCardinality();

  DimensionSelector makeDimensionSelector(ReadableOffset offset, @Nullable ExtractionFn extractionFn);

  @Override
  default ColumnValueSelector makeColumnValueSelector(ReadableOffset offset)
  {
    return makeDimensionSelector(offset, null);
  }
}