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

package io.openmessaging.storage.dledger.protocol;

import java.util.concurrent.CompletableFuture;

/**
 * Both the RaftLogServer(inbound) and RaftRpcService (outbound) should implement this protocol
 * DLedger客户端协议
 */
public interface DLedgerProtocol extends DLedgerClientProtocol {

    /**
     * 投票
     * @param request
     * @return
     * @throws Exception
     */
    CompletableFuture<VoteResponse> vote(VoteRequest request) throws Exception;

    /**
     * 发送心跳
     * @param request
     * @return
     * @throws Exception
     */
    CompletableFuture<HeartBeatResponse> heartBeat(HeartBeatRequest request) throws Exception;

    /**
     * 拉取日志
     * @param request
     * @return
     * @throws Exception
     */
    CompletableFuture<PullEntriesResponse> pull(PullEntriesRequest request) throws Exception;

    /**
     * 推送日志
     * @param request
     * @return
     * @throws Exception
     */
    CompletableFuture<PushEntryResponse> push(PushEntryRequest request) throws Exception;

}
