/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.bitcoinj.core.CoinDefinition;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
<<<<<<< HEAD
        maxTarget = Utils.decodeCompactBits(0x1e01ffffL);
        dumpedPrivateKeyHeader = 128 + CoinDefinition.AddressHeader;
        addressHeader = CoinDefinition.AddressHeader;
        p2shHeader = CoinDefinition.p2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader};
        port = 5223;
        packetMagic = CoinDefinition.PacketMagic;
        genesisBlock.setDifficultyTarget(0x1e01ffffL);
        genesisBlock.setTime(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.genesisBlockNonce);
=======
        maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = 128;
        addressHeader = 0;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 8333;
        packetMagic = 0xf9beb4d9L;
        bip32HeaderPub = 0x0488B21E; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x0488ADE4; //The 4 byte header that serializes in base58 to "xprv"

        genesisBlock.setDifficultyTarget(0x1d00ffffL);
        genesisBlock.setTime(1231006505L);
        genesisBlock.setNonce(2083236893);
>>>>>>> upstream/master
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 2102400;
        spendableCoinbaseDepth = 3600;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("4e9b54001f9976049830128ec0331515eaabe35a70970d79971da1539a400ba1"),
                genesisHash);

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(3901, new Sha256Hash("39c94020b653871bbcb29c9489bb12f84c5e89adef75f2e5c5f59e88869129d9"));
        checkpoints.put(40821, new Sha256Hash("e0471675f9c98aa5ed321ed951d140d4603d96254a4ca9fbca07b8da5ee11954"));
        checkpoints.put(41433, new Sha256Hash("627e18cc08a276282781705bac09508992dc8b665391edd7bde8a601f011954c"));
        checkpoints.put(44606, new Sha256Hash("5ceeec38564a36ee3e1e5404970f5715efe0420e92c8e92bedfdfef782c49320"));		

        dnsSeeds = new String[] {
			"via.cryptoservices.net",

        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
