/**
 *    Copyright 2016-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.ibatis.reflection.wrapper;

import java.util.Map;

import org.mybatis.ibatis.reflection.MetaObject;
import org.mybatis.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin (initial work)
 * @author Jeff Butler (derivation)
 */
public class MapWrapper extends ObjectWrapper {

    private Map<String, Object> map;

    public MapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject);
        this.map = map;
    }

    @Override
    public Object get(PropertyTokenizer prop) {
        if (prop.getIndex() != null) {
            Object collection = resolveCollection(prop);
            return getCollectionValue(prop, collection);
        } else {
            return map.get(prop.getName());
        }
    }
}
