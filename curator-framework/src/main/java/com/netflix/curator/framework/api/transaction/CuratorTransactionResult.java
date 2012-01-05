/*
 *
 *  Copyright 2011 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.netflix.curator.framework.api.transaction;

import com.google.common.base.Predicate;
import org.apache.zookeeper.data.Stat;

public class CuratorTransactionResult
{
    private final OperationType type;
    private final String        forPath;
    private final String        resultPath;
    private final Stat          resultStat;
    
    public static Predicate<CuratorTransactionResult>       ofTypeAndPath(final OperationType type, final String forPath)
    {
        return new Predicate<CuratorTransactionResult>()
        {
            @Override
            public boolean apply(CuratorTransactionResult result)
            {
                return (result.getType() == type) && result.getForPath().equals(forPath);
            }
        };
    }

    public CuratorTransactionResult(OperationType type, String forPath, String resultPath, Stat resultStat)
    {
        this.forPath = forPath;
        this.resultPath = resultPath;
        this.resultStat = resultStat;
        this.type = type;
    }

    public OperationType getType()
    {
        return type;
    }

    public String getForPath()
    {
        return forPath;
    }

    public String getResultPath()
    {
        return resultPath;
    }

    public Stat getResultStat()
    {
        return resultStat;
    }
}