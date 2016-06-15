package com.changtu

import com.changtu.hbase.HBaseClient
import org.apache.hadoop.hbase.util.Bytes
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by lubinsu on 2016/6/15.
  */
class HBaseSpec extends FlatSpec with Matchers {

  "HBase" should "get user label 1251212,112312,325123" in {

    val hbaseClient = new HBaseClient(tablePath = "bi_user_label_string")

    val get = hbaseClient.getGet("1735909")
    val value = hbaseClient.get(get).getValue(Bytes.toBytes("labels"), Bytes.toBytes(""))
    println(Bytes.toString(value))
    Bytes.toString(value) should be("1251212,112312,325123")
  }

  /*it should "get all label details of 1735909" in {
    val hbaseClient = new HBaseClient(tablePath = "bi_user_label")
    val filter = HBaseFilters.getRowkeyPrefixFilter("1735909_")
    hbaseClient.scanPrefix("1735909_", )
    hbaseClient.get("1735909", filter).getValue()
  }*/
}
