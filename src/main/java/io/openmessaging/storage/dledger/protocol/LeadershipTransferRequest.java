/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openmessaging.storage.dledger.protocol;

public class LeadershipTransferRequest extends RequestOrResponse {

    private String transferId;
    private String transfereeId;
    private long takeLeadershipLedgerIndex;

    public String getTransfereeId() {
        return transfereeId;
    }

    public void setTransfereeId(String transfereeId) {
        this.transfereeId = transfereeId;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public long getTakeLeadershipLedgerIndex() {
        return takeLeadershipLedgerIndex;
    }

    public void setTakeLeadershipLedgerIndex(long takeLeadershipLedgerIndex) {
        this.takeLeadershipLedgerIndex = takeLeadershipLedgerIndex;
    }
}
