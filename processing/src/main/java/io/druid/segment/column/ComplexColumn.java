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

import io.druid.query.monomorphicprocessing.RuntimeShapeInspector;
import io.druid.segment.ColumnValueSelector;
import io.druid.segment.ObjectColumnSelector;
import io.druid.segment.data.ReadableOffset;

import javax.annotation.Nullable;

/**
 * 复杂对象 常用于扩展的数据类型
 */
public interface ComplexColumn extends BaseColumn
{
  Class<?> getClazz();
  String getTypeName();
  Object getRowValue(int rowNum);

  @Override
  void close();

  @Override
  default ColumnValueSelector makeColumnValueSelector(ReadableOffset offset)
  {
    return new ObjectColumnSelector()
    {
      @Nullable
      @Override
      public Object getObject()
      {
        return getRowValue(offset.getOffset());
      }

      @Override
      public Class classOfObject()
      {
        return getClazz();
      }

      @Override
      public void inspectRuntimeShape(RuntimeShapeInspector inspector)
      {
        inspector.visit("column", ComplexColumn.this);
      }
    };
  }
}
