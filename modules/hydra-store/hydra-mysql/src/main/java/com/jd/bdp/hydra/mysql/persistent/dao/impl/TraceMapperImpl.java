/*
 * Copyright jd
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.jd.bdp.hydra.mysql.persistent.dao.impl;

import com.jd.bdp.hydra.mysql.persistent.dao.TraceMapper;
import com.jd.bdp.hydra.mysql.persistent.entity.Trace;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: biandi
 * Date: 13-5-8
 * Time: 下午3:29
 */
public class TraceMapperImpl implements TraceMapper{

    public List<Trace> findTrace(Long startTime, int num){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", startTime);
        map.put("num", num);
        return (List<Trace>) sqlSession.selectList("findTrace", map);
    }

    @Override
    public void addTrace(Trace t) {
        sqlSession.insert("addTrace",t);
    }

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
}
