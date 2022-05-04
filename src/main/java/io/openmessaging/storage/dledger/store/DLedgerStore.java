/*
 * Copyright 2017-2022 The DLedger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openmessaging.storage.dledger.store;

import io.openmessaging.storage.dledger.MemberState;
import io.openmessaging.storage.dledger.entry.DLedgerEntry;

/**
 * 存储抽象类
 */
public abstract class DLedgerStore {

    public MemberState getMemberState() {
        return null;
    }

    /**
     * 向主节点追加日志
     * @param entry
     * @return
     */
    public abstract DLedgerEntry appendAsLeader(DLedgerEntry entry);

    /**
     * 向从节点广播日志
     */
    public abstract DLedgerEntry appendAsFollower(DLedgerEntry entry, long leaderTerm, String leaderId);

    public abstract DLedgerEntry get(Long index);

    /**
     * 获取已提交的日志序号
     * @return
     */
    public abstract long getCommittedIndex();

    public void updateCommittedIndex(long term, long committedIndex) {

    }

    /**
     * 获取leader节点当前最大的投票轮次
     * @return
     */
    public abstract long getLedgerEndTerm();

    /**
     * 获取leader的节点下一条日志写入的日志序号
     * @return
     */
    public abstract long getLedgerEndIndex();

    public abstract long getLedgerBeginIndex();

    protected void updateLedgerEndIndexAndTerm() {
        if (getMemberState() != null) {
            getMemberState().updateLedgerIndexAndTerm(getLedgerEndIndex(), getLedgerEndTerm());
        }
    }

    public void flush() {

    }

    public long truncate(DLedgerEntry entry, long leaderTerm, String leaderId) {
        return -1;
    }

    public void startup() {

    }

    public void shutdown() {

    }
}
