package util;

import java.net.URLEncoder;

public class PageIndex {
	public static String pageList(int page,int totpage,String url,String addtag) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev 占쏙옙占쎌삢 癰귨옙占쎈땾
		String s_idx = "";    // 甕곕뜇�깈 占쏙옙占쎌삢 癰귨옙占쎈땾
		String s_next = "";   // Next 占쏙옙占쎌삢 癰귨옙占쎈땾

		idx_start = ((page-1) / 10) * 10 + 1 ;  // 占쎈뻻占쎌삂 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
		idx_pre = ((page-1) / 10);              // Priview 占쎈읂占쎌뵠筌욑옙 �④쑴沅�

	  	// Prev 占쎈ご占쎈뻻 �겫占썽겫占�
	  	if(idx_pre > 0) {
	  		s_pre = "<a href='"+url+"&page="+(idx_pre*10)+addtag+"'>"
	  				+ "<img src=./img/i_prev.gif width=30 height=7></a>";
	  	} else {
	  		s_pre = "<img src=./img/i_prev.gif width=30 height=7> ";
	  	}

	  	// 甕곕뜇�깈 占쎈ご占쎈뻻�겫占썽겫占�	
	  	for(int i=0;i<10;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		if(idx_start == page)
	  			s_idx = s_idx + " "+idx_start+" ";
	  		else {
	  			s_idx = s_idx + " <a href='" + url + "&page=" + idx_start;
	  			s_idx = s_idx + addtag + "'> " + idx_start + " </a> ";
	  		}
	  	}
		// Next 占쎈ご占쎈뻻�겫占썽겫占�
	  	if(idx_start <= totpage ) {
	  		s_next = "<a href='"+url+"&page="+idx_start+addtag+"'>"
	  				+ "<img src=./img/i_next.gif width=30 height=7></a>";
	  	} else {
	  		s_next = " <img src=./img/i_next.gif width=30 height=7>";
	  	}

	  	String outHtml = s_pre + s_idx + s_next;  // Html �눧占� 鈺곌퀬鍮�
	  	return outHtml;
	}

	public static String pageListHan(int page,int totpage,String url,String query, String key) {
		int idx_pre, idx_start;
		  	
		String s_pre = "";    // Prev 占쏙옙占쎌삢 癰귨옙占쎈땾
		String s_idx = "";    // 甕곕뜇�깈 占쏙옙占쎌삢 癰귨옙占쎈땾
		String s_next = "";   // Next 占쏙옙占쎌삢 癰귨옙占쎈땾

		idx_start = ((page-1) / 10) * 10 + 1 ;  // 占쎈뻻占쎌삂 占쎈읂占쎌뵠筌욑옙 �④쑴沅�
		idx_pre = ((page-1) / 10);              // Priview 占쎈읂占쎌뵠筌욑옙 �④쑴沅�

	  	// Prev 占쎈ご占쎈뻻 �겫占썽겫占�
	  	if(idx_pre > 0) {
	  		s_pre = "<a href='"+url+"&page="+(idx_pre*10)+"&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "<img src=Board/img/i_prev.gif width=30 height=7></a>";
	  	} else {
	  		s_pre = "<img src=Board/img/i_prev.gif width=30 height=7> ";
	  	}

	  	// 甕곕뜇�깈 占쎈ご占쎈뻻�겫占썽겫占�	
	  	for(int i=0;i<10;i++,idx_start++) {
	  		if(idx_start>totpage) break;
	  		if(idx_start == page)
	  			s_idx = s_idx + " "+idx_start+" ";
	  		else {
	  			s_idx = s_idx + " <a href='" + url + "&page=" + idx_start;
	  			s_idx = s_idx + "&search="+query+"&key=" + URLEncoder.encode(key) + "'> " + idx_start + " </a> ";
	  		}
	  	}
		// Next 占쎈ご占쎈뻻�겫占썽겫占�
	  	if(idx_start <= totpage ) {
	  		s_next = "<a href='"+url+"&page="+idx_start+ "&search="+query+"&key="+ URLEncoder.encode(key)+"'>"
	  				+ "<img src=Board/img/i_next.gif width=30 height=7></a>";
	  	} else {
	  		s_next = " <img src=Board/img/i_next.gif width=30 height=7>";
	  	}

	  	String outHtml = s_pre + s_idx + s_next;  // Html �눧占� 鈺곌퀬鍮�
	  	return outHtml;
	}

}
