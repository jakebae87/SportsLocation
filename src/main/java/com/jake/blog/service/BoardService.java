package com.jake.blog.service;

import com.jake.blog.model.Board;
import com.jake.blog.model.Reply;
import com.jake.blog.model.User;
import com.jake.blog.repository.BoardRepository;
import com.jake.blog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void write(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board detail(int id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
                });
        return board;
    }

    @Transactional
    public void delete(int id) {
        System.out.println("글삭제하기 : " + id);
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Board requestBoard) {
        Board updateBoard = boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
                });
        updateBoard.setTitle(requestBoard.getTitle());
        updateBoard.setContent(requestBoard.getContent());
    }

    @Transactional
    public void replySave(User user, int boardId, Reply reply) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("댓글 쓰기 실패: 게시글 id를 찾을 수 없습니다.");
                });

        reply.setUser(user);
        reply.setBoard(board);

        replyRepository.save(reply);
    }

    @Transactional
    public void replyDelete(int replyId) {
        replyRepository.deleteById(replyId);
    }
}
