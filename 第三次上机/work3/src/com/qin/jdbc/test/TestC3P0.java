package com.qin.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import com.qin.jdbc.utils.C3P0Utils;
import com.qin.jdbc.utils.JDBCUtils_V3;

public class TestC3P0 {
	@Test
	public void testAddUser1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 2.从池子中获取连接
			conn = C3P0Utils.getConnection();
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布3");
			pstmt.setString(2, "貂蝉3");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}

	@Test
	public void testAddUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1.创建自定义连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();// 加载默认的配置
		// ComboPooledDataSource dataSource = new
		// ComboPooledDataSource("itheima");//加载有名称的配置
		try {
			// 2.从池子中获取连接
			conn = dataSource.getConnection();
//			insert into students values(Null,'ddd','1234','xuesheng',4,'xiaozhun');
			String sql = "insert into students values(Null,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "吕布3");
			pstmt.setString(2, "貂蝉3");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils_V3.release(conn, pstmt, null);
		}
	}
}
