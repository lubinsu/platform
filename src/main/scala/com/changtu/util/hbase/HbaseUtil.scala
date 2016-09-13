package com.changtu.util.hbase

import com.changtu.util.ClusterEnv
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory}

/**
  * Created by lubinsu on 7/28/2016.
  */
object HbaseUtil extends Serializable with ClusterEnv {

  private val conf = HBaseConfiguration.create()

  try {
    conf.addResource(new Path(confHome + "/hbase-site.xml"))
    conf.addResource(new Path(confHome + "/core-site.xml"))
  } catch {
    case e: IllegalArgumentException =>
      conf.addResource(new Path(confHome + "/hbase-site.xml"))
      conf.addResource(new Path(confHome + "/core-site.xml"))
  }
  private val connection = ConnectionFactory.createConnection(conf)

  def getHbaseConn: Connection = connection
}