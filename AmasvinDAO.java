package miniproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AmasvinDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private static AmasvinDAO instance; //인스턴스는 싱글톤 사용시 그냥 관행적으로 쓰는 변수 다른거해도 상관없음
	
		public static AmasvinDAO getInstance() {
			synchronized (AmasvinDAO.class) {//1사람만 통과하도록 lock 건다 웹에서 여러사람이 동시에 할 수있으니까
				if(instance == null) {
					instance = new AmasvinDAO(); //1번만 한다 null일때가 1번이니까
				}
			}
			return instance; //빠지고 인스턴스(멤버DAO)를 보내버린다.
		}
	
		public AmasvinDAO() {
			try {
				Class.forName(driver);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public void getConnection() {
			try {
				conn = DriverManager.getConnection(url, username, password);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public int insertMember(AmasvinDTO dto) { //회원가입
			String sql = "insert into amasvin values(?, ?, ?, ?, ?, ?, ?)";
			this.getConnection();
			int su=0;
			
			try {
				pstmt = conn.prepareStatement(sql); //생성
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getId());
				pstmt.setString(3, dto.getPwd());
				pstmt.setString(4, dto.getEmail());
				pstmt.setString(5, dto.getPhone());
				pstmt.setInt(6, 0);
				pstmt.setInt(7, 0);
				su = pstmt.executeUpdate();//실행 - 개수 리턴
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return su;
		}//insertMember
		
		public void addstamp(String id, String pwd) { //스탬프 추가
			String sql = "update amasvin set stamp = stamp + 1 where id=? and pwd=?";
			this.getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql); //생성
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//addstamp
		
		public void addcoupon(String id, String pwd) { //쿠폰 추가
			String sql = "update amasvin set coupon = coupon+1 where id=? and pwd=?";
			this.getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql); //생성
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//addcoupon
		
		public int couponnum(String id, String pwd) {
		      int coupon=0;
		      String sql = "select * from amasvin where id=? and pwd=?";
		      getConnection();
		      
		      try {
		         pstmt = conn.prepareStatement(sql);//생성
		         pstmt.setString(1, id);
		         pstmt.setString(2, pwd);
		         
		         rs = pstmt.executeQuery();//실행
		         
		         if(rs.next()) coupon = rs.getInt("coupon"); 
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         try {
		            if(rs != null) rs.close();
		            if(pstmt != null) pstmt.close();
		            if(conn != null) conn.close();
		         }catch(SQLException e) {
		            e.printStackTrace();
		         }
		      }
		      return coupon;
		}//couponnum
		
		public void resetstamp(String id, String pwd) {
			String sql = "update amasvin set stamp = 0 where id=? and pwd=?";
			this.getConnection();
	
			try {
				pstmt = conn.prepareStatement(sql); //생성
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.executeUpdate();	
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		} //resetstamp
		
		public void resetcoupon(String id, String pwd) {
			String sql = "update amasvin set coupon = 0 where id=? and pwd=?";
			this.getConnection();
	
			try {
				pstmt = conn.prepareStatement(sql); //생성
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}//resetcoupon
		
		public int stampnum(String id, String pwd) {
		      int stamp=0;
		      String sql = "select * from amasvin where id=? and pwd=?";
		      getConnection();
		      
		      try {
		         pstmt = conn.prepareStatement(sql);//생성
		         pstmt.setString(1, id);
		         pstmt.setString(2, pwd);
		         
		         rs = pstmt.executeQuery();//실행
		         
		         if(rs.next()) stamp = rs.getInt("stamp");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         try {
		            if(rs != null) rs.close();
		            if(pstmt != null) pstmt.close();
		            if(conn != null) conn.close();
		         }catch(SQLException e) {
		            e.printStackTrace();
		         }
		      }  
		      return stamp;
		 }//stampnum
	
	  public String loginMember(String id, String pwd) { //로그인 시 아이디 비번에 해당되는 이름 반환
	      String name = null;
	      String sql = "select * from amasvin where id=? and pwd=?";
	      getConnection();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);//생성
	         pstmt.setString(1, id);
	         pstmt.setString(2, pwd);
	         
	         rs = pstmt.executeQuery();//실행
	         
	         if(rs.next()) name = rs.getString("name");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return name;
	  }//loginMember
	 
	  public String UserEmail(String id, String pwd) { 
	      String email = null;
	      String sql = "select * from amasvin where id=? and pwd=?";
	      getConnection();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);//생성
	         pstmt.setString(1, id);
	         pstmt.setString(2, pwd);
	         
	         rs = pstmt.executeQuery();//실행
	         
	         if(rs.next()) email = rs.getString("email");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException e) {
	            e.printStackTrace();
	         }
	      } 
	      return email;
	   }//UserEmail
	 
	  public String UserPhone(String id, String pwd) {
	      String phone = null;
	      String sql = "select * from amasvin where id=? and pwd=?";
	      getConnection();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);//생성
	         pstmt.setString(1, id);
	         pstmt.setString(2, pwd);
	         
	         rs = pstmt.executeQuery();//실행
	         
	         if(rs.next()) phone = rs.getString("phone");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         }catch(SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return phone;
	   }//UserPhone


	  public String idcheck(String id) { //아이디 중복 체크
		  String idc = null ;
			
		  String sql = "select * from amasvin where id=?";
		  getConnection();
			
		  try {
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, id);
				
			  rs = pstmt.executeQuery();
				
			  if(rs.next()) idc = rs.getString("id");
		  }catch (SQLException e) {
			  e.printStackTrace();
		  }finally {
			  try {
				  if(rs != null) rs.close();
				  if(pstmt != null) pstmt.close();
				  if(conn != null) conn.close();
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
		  }
		  return idc;
		} //idcheck


	  public String idSearchMember(String name, String email) { 
		  String idc = null;
			
		  String sql = "select * from amasvin where name=? and email=?";
		  getConnection();
		  
		  try {
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, name);
			  pstmt.setString(2, email);
				
			  rs = pstmt.executeQuery();
			  
			  if(rs.next()) idc = rs.getString("id");
		  }catch (SQLException e) {
			  e.printStackTrace();
		  }finally {
			  try {
				  if(rs != null) rs.close();
				  if(pstmt != null) pstmt.close();
				  if(conn != null) conn.close();
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
		  }
			return idc;
		}//idSearchMember
	
	
		public String pwdSearchMember(String name, String id, String email) {
			String pwdc = null;
			
			String sql = "select * from amasvin where name=? and id=? and email=?";
			getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				pstmt.setString(3, email);
				
				rs = pstmt.executeQuery();
				if(rs.next()) pwdc = rs.getString("pwd");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return pwdc;
		}//pwdSearchMember
		
		public String pwdCheck(String pwd) {
			String pwdc = null;
			
			String sql = "select * from amasvin where pwd=?";
			getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pwd);
				
				rs = pstmt.executeQuery();
				if(rs.next()) pwdc = rs.getString("pwd");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return pwdc;
		}//pwdCheck

		public void UpdateMember(String name,String pwd, String email, String phone, String id) {
			String sql = "update amasvin set name=?, pwd=?, email=?, phone=? where id=?";
		
			getConnection();
			try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, pwd);
					pstmt.setString(3, email);
					pstmt.setString(4, phone);
					pstmt.setString(5, id);
					pstmt.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		} //UpdateMember
	
		
		public void DeleteMember(String id) {
			
			String sql = "delete amasvin where id=?";
			getConnection();
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		} //DeleteMember
	}