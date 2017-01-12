package com.coreapp.db.cassnadra

import org.scalatest.{FunSpec, Matchers}
import com.coreapp.db.cassandra.CassandraConnectionUri

class CassandraConnectionUriSpec extends FunSpec with Matchers {

  describe("A Cassandra connection URI object") {
    it("should parse a URI with a single host") {
      val cut = CassandraConnectionUri("cassandra://localhost:9042/ruchibot")
      cut.host should be ("localhost")
      cut.hosts should be (Seq("localhost"))
      cut.port should be (9042)
      cut.keyspace should be ("ruchibot")
    }
    it("should parse a URI with additional hosts") {
      val cut = CassandraConnectionUri(
        "cassandra://localhost:9042/ruchibot" +
          "?host=otherhost.example.net" +
          "&host=yet.anotherhost.example.com")
      cut.hosts should contain allOf ("localhost", "otherhost.example.net", "yet.anotherhost.example.com")
      cut.port should be (9042)
      cut.keyspace should be ("ruchibot")
    }
  }

}
