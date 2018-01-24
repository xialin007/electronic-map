//package com.ghostcloud.electronic.electronicmap.hbase;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.hadoop.hbase.client.Delete;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.client.ResultScanner;
//import org.apache.hadoop.hbase.client.Scan;
//import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.FilterList;
//import org.apache.hadoop.hbase.filter.PageFilter;
//import org.apache.hadoop.hbase.filter.PrefixFilter;
//import org.apache.hadoop.hbase.filter.RegexStringComparator;
//import org.apache.hadoop.hbase.filter.RowFilter;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.hadoop.hbase.HbaseTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HbaseServiceImpl implements HbaseService {
//
//	@Autowired
//	private HbaseTemplate hbaseTemplate;
//
//	private final String encoding = "utf-8";
//
//	@Override
//	public List<Result> scaner(String tablename) {
//		return null;
//	}
//
//	@Override
//	public Result getRow(String tableName, String rowKey) {
//		return null;
//	}
//
//	@Override
//	public List<Result> getRegexRow(String tableName, String regxKey) {
//		return null;
//	}
//
//	@Override
//	public List<Result> getRegexRow(String tableName, String regxKey, int num) {
//		return null;
//	}
//
//	@Override
//	public List<Result> getStartRowAndEndRow(String tableName, String startKey, String stopKey) {
//		return null;
//	}
//
//	@Override
//	public List<Result> getRegexRow(String tableName, String startKey, String stopKey, String regxKey) {
//		return null;
//	}
//
//	@Override
//	public List<Result> getRegexRow(String tableName, String startKey, String stopKey, String regxKey, int num) {
//		return null;
//	}
//
//	@Override
//	public void addData(String rowKey, String tableName, String[] column, String[] value) {
//
//	}
//
//	@Override
//	public void delRecord(String tableName, String... rowKeys) {
//
//	}
//
//	@Override
//	public void updateTable(String tableName, String rowKey, String familyName, String[] column, String[] value)
//			throws IOException {
//
//	}
//
//	@Override
//	public Result getNewRow(String tableName) {
//		return null;
//	}
//
//	@Override
//	public List<String> queryKeys(String tableName, String regxKey) {
//		return null;
//	}
//
//	@Override
//	public long incrQualifier(String tableName, String cf, String rowKey, String column, long num) {
//		return 0;
//	}
//
//	@Override
//	public Result getNewRow(String tableName, String regxKey) {
//		return null;
//	}
//}
