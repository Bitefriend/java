package org.joozis.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.Context;






public class GreenDao {
	//필드
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = "";
	//싱글톤
	public GreenDao() {} // 기본 생성자 (외부에서 접근할 수 없게 private 처리)
	private static GreenDao dao = new GreenDao();
	public static GreenDao getInstance() {
		return dao;
	}
	// DBCP 설정
	private static DataSource ds;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// java:comp/env/ :톰캣 (지정되어 있음)
			// jdbc/oracle : Resource name(변경가능 ) 을 찾아서 DataSource 객체에 전달
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public List<GreenVO> getAllList() {
		List<GreenVO> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			sql = "select * from green order by idx";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				GreenVO dto = new GreenVO();
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setAddr(rs.getString(6));
				dto.setReg_date(rs.getDate(7));
				list.add(dto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) {rs.close();}
				if(ps !=null) {ps.close();}
				if(conn !=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list ;
	}
	//데이터 삽입 메소드
	public int getInsert(GreenVO dto) {
		int result = 0;
		
		try {
			conn = getConnection();
			

			String sql = "";
			sql = "insert into Green (idx, id, pw, name, age, addr, reg_date) "
					+ " values(green_seq.nextval, ? , ?, ?,?,?, sysdate)";
			
			ps = conn.prepareStatement(sql);
			
			/*
			 * conn.setAutoCommit(false); // 자동커밋 방지
			 */		
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			
			result = ps.executeUpdate();
		
			if(result>0) {
				conn.commit();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			try {
				if(conn !=null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			
			try {
				if(ps!= null) {ps.close();}
				if(conn !=null) {conn.close();}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	} 
		
		return result;
		
	}
	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getRemove(GreenVO dto) {
		int result2 = 0 ;
		
		try {
			conn = getConnection();
			
			String sql = "";
			sql = "delete from  green where id = ? and pw = ? and name = ? and age = ? and addr = ? ";
			
		
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			
			result2 = ps.executeUpdate();
		
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				if(conn !=null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			
			try {
				if(conn !=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result2;
	}
	
	public GreenVO getPerList(String id) {
			GreenVO dto = new GreenVO();
		try {
			conn = getConnection();
			sql =  "select * from green where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery(); // 실제 쿼리 작동
			if(rs.next()) {
				
     			dto.setIdx(rs.getInt(1));
     			dto.setId(rs.getString(2));
     			dto.setPw(rs.getString(3));
     			dto.setName(rs.getString(4));
     			dto.setAge(rs.getInt(5));
     			dto.setAddr(rs.getString(6));
     			dto.setReg_date(rs.getDate(7)); 
     			
			};
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) {ps.close();}
				if(rs !=null) {rs.close();}
				if(conn !=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto ;

	}
	public GreenVO getUpdate(GreenVO dto) {
		GreenVO returnDto = null;
		try {
			Statement st = null;
			conn = getConnection();
			String sql = "";
			sql = "select * from Green where id = ? ";			
		
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getPw());
			
			ps.executeUpdate();
			
			int result = ps.executeUpdate();
			
			returnDto.setIdx(rs.getInt(1));
			returnDto.setId(rs.getString(2));
			returnDto.setPw(rs.getString(3));
			returnDto.setName(rs.getString(4));
			returnDto.setAge(rs.getInt(5));
			returnDto.setAddr(rs.getString(6));
			returnDto.setReg_date(rs.getDate(7)); 
		
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			try {
				if(conn !=null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			
			try {
				/* if(st !=null) {st.close();} */
				if(conn !=null) {conn.close();}
		
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return returnDto ;
	}
	
	//유저정보 수정메소드
	public int getUpdate2(GreenVO dto) {
			int result = 0;
			
		try {
			conn = getConnection();
			
			String sql = "";
			sql = "update member set pw = ? , name = ? , age = ? , addr = ? where id = ?";
			
		
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,dto.getPw());
			ps.setString(2,dto.getName());
			ps.setInt(3,dto.getAge());
			ps.setString(4,dto.getAddr());
			ps.setString(5,dto.getId());
			ps.executeUpdate();
			
			 result = ps.executeUpdate();
		
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			try {
				if(conn !=null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			
			try {
			/*	if(st !=null) {st.close();}*/
				if(conn !=null) {conn.close();}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
    
	}
	
	
	}