package controller.board;

import service.Action;
import service.board.BoardDeleteAction;
import service.board.BoardDeleteProAction;
import service.board.BoardListAction;
import service.board.BoardModifyAction;
import service.board.BoardModifyProAction;
import service.board.BoardViewAction;
import service.board.BoardWriteAction;
import service.board.BoardWriteProAction;

public class BoardActionFactory {
	private static BoardActionFactory instance = new BoardActionFactory();
	
	private BoardActionFactory() {
		
	}
	
	public static BoardActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("BoardActionFactory : " + cmd);
		if(cmd.equals("board_list")) {
			action = new BoardListAction();
		}
		else if(cmd.equals("board_write")) {
			action = new BoardWriteAction();
		}
		else if(cmd.equals("board_wirte_pro")) {
			action = new BoardWriteProAction();
		}
		else if(cmd.equals("board_view")) {
			action = new BoardViewAction();
		}
		else if(cmd.equals("board_modify")) {
			action = new BoardModifyAction();
		}
		else if(cmd.equals("board_modify_pro")) {
			action = new BoardModifyProAction();
		}
		else if(cmd.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		else if(cmd.equals("board_delete_pro")) {
			action = new BoardDeleteProAction();
		}
		return action;
	}
}
