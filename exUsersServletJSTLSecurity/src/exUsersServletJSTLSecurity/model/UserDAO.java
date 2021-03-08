package exUsersServletJSTLSecurity.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exUsersServletJSTLSecurity.util.DBManager;
public class UserDAO {
	private UserDAO() {
		
	}
	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
			return instance;
		}

		// 회원가입
		public int userInsert(UserVO vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "insert into tbl_users(name,userid,passwd,tel,email) values(?,?,?,?,?)";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getUserid());
				pstmt.setString(3, vo.getPasswd());
				pstmt.setString(4, vo.getTel());
				pstmt.setString(5, vo.getEmail());
				row = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 중복체크
		public int userCheck(String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;
			String query = "select count(*) from tbl_users where userid=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					row = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

		// 리스트
		public List<UserVO> userList() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserVO vo = null;
			List<UserVO> list = new ArrayList<UserVO>();

			String query = "select * from tbl_users";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					vo = new UserVO();
					vo.setName(rs.getString("name"));
					vo.setUserid(rs.getString("userid"));
					vo.setTel(rs.getString("tel"));
					vo.setFirst_time(rs.getString("first_time"));
					vo.setLast_time(rs.getString("last_time"));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		// 로그인
		public int userLogin(String userid, String passwd) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int row = 0;

//			String query = "select count(*) from tbl_users where userid=? and passwd=?";
			String query = "select passwd from tbl_users where userid=?";

			try {
				// conn = getConnection();
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					String dbpass = rs.getString("passwd");
					System.out.println(dbpass);
					if (dbpass.equals(passwd)) {
						query = "update tbl_users set last_time=sysdate where userid=?";
//						pstmt.getConnection().prepareStatement(query);
						pstmt = conn.prepareStatement(query);
						pstmt.setString(1, userid);
						pstmt.executeUpdate();
						row = 1;
					} else {
						row = 0;
					}
					
				} else
					row = -1;

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

			return row;
		}

		// user 정보
		public UserVO userSelect(String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			UserVO vo = null;

			String query = "select * from tbl_users where userid=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userid);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					vo = new UserVO();
					vo.setName(rs.getString("name"));
					vo.setUserid(rs.getString("userid"));
					vo.setTel(rs.getString("tel"));
					vo.setFirst_time(rs.getString("first_time"));
					vo.setLast_time(rs.getString("last_time"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return vo;
		}
		
		public int userModify(UserVO vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int row = 0;

			String query = "update tbl_users_sec set passwd = ? where userid = ?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, vo.getPasswd());
				pstmt.setString(2, vo.getUserid());
	
				row = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return row;
		}

	}

