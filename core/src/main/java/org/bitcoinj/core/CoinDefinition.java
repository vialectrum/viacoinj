package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: CannabisCoin
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "ViaCoin";
    public static final String coinTicker = "VIA";
    public static final String coinURIScheme = "viacoin";
    public static final String cryptsyMarketId = "261";
    public static final String cryptsyMarketCurrency = "VIA";
    public static final String PATTERN_PRIVATE_KEY_START = "6";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.viacoin.org/";    //VIA
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //VIA
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //VIA
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //VIA
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "VhiS4PgVMAipwaVGx8Ek9fshqrM6XXZDqu";  //ViaCoin donation address

    enum CoinHash {
        SHA256,
        scrypt,
    };
    public static final CoinHash coinPOWHash = CoinHash.scrypt;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(14 * 24 * 60 * 60);  // 6 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(1 * 24);  // 10 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 3600; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(92000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(100000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70002;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 1;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 5223;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 25223;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 71;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 33;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long PacketMagic = 0x0f68c6cb;      //0xfb, 0xc0, 0xb6, 0xdb

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e01ffffL);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1405164774L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (4016033);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "4e9b54001f9976049830128ec0331515eaabe35a70970d79971da1539a400ba1"; //main.cpp: hashGenesisBlock
    static public int genesisBlockValue = 420;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisXInBytes = "04ffff001d01044c4e426c6f636b20233331303337393a30303030303030303030303030303030323431323532613762623237626539376265666539323138633132393064666633366331666631323965633732313161";
    static public String genessiXOutBytes = "0459934a6a228ce9716fa0b13aa1cdc01593fca5f8599473c803a5109ff834dfdaf4c9ee35f2218c9ee3e7cf7db734e1179524b9d6ae8ebbeba883d4cb89b6c7bf";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "82.196.11.201",
			"66.175.212.66",
			"63.165.243.164",
			"104.131.142.198",
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - CannabisCoin - not tested
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xfcc1b7dc;      //0xfc, 0xc1, 0xb7, 0xdc
    public static final String testnetGenesisHash = "5e039e1ca1dbf128973bf6cff98169e40a1b194c3b91463ab74956f413b2f9c8";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1397088621L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (97207);                         //main.cpp: LoadBlockIndex




    public static int subsidyDecreaseBlockCount = 100000;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e01ffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
          "not supported"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "047885d9f6c0cf9e918d04634d4dd696cf172763f1975aad099daddca3f3c712c98754eae293b36484055e0d414800e519f5a342e56e09217faf07abff5bd96507";
    public static final String TESTNET_SATOSHI_KEY = "045c480dac3b2c8ef95a8577faa2420eabfe376fbfa31b2bb1896b3e5a30675403f4b3d084724d65afcbbb61473a302a6ed3286e39041176d9af6ff601543bd113";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.cannabiscoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.cannabiscoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.cannabiscoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put( 0,   new Sha256Hash("4e9b54001f9976049830128ec0331515eaabe35a70970d79971da1539a400ba1"));

    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
