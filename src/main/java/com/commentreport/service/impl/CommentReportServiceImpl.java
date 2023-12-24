//package com.commentreport.service.impl;
//
//import com.comment.model.Comment;
//import com.commentreport.dto.CommentReportRequest;
//import com.commentreport.model.CommentReport;
//import com.commentreport.repository.CommentReportRepository;
//import com.commentreport.repository.CommentRepository;
//import com.commentreport.service.CommentReportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CommentReportServiceImpl implements CommentReportService {
//
//    @Autowired
//    private CommentReportRepository commentReportRepository;
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Override
//    public List<CommentReport> getCommentReports() {
//
//        return commentReportRepository.findAll(); //取不到Comment的com_id
//    }
//
//    @Override
//    public CommentReport getCommentReportById(Integer repId) {
//
//        Optional<CommentReport> commentReport = commentReportRepository.findById(repId);
//
//        if (commentReport.isPresent()) {
//            // 如果Optional包含物件，则返回
//            return commentReport.get();
//        } else {
//            return null;
//        }
//
////        return commentReportRepository.findById(repId)
////                .orElseThrow(() -> new EntityNotFoundException("CommentReport not found for id: " + repId));
//    }
//
//    @Override
//    public Integer createCommentReport(CommentReportRequest commentReportRequest) {
//
//        Comment comment = commentRepository.findById(commentReportRequest.getComId())
//                                            .orElseThrow(() -> new RuntimeException("找不到"));
//
//        CommentReport commentReport = new CommentReport();
//
//        commentReport.setComment(comment);
//        commentReport.setMemId(commentReportRequest.getMemId());
//        commentReport.setRepTitle(commentReportRequest.getRepTitle());
//        commentReport.setRepContent(commentReportRequest.getRepContent());
//
//        Date now = new Date();
//        commentReport.setRepTime(now);
//
//        CommentReport saveCommentReport = commentReportRepository.save(commentReport);
//
//        return saveCommentReport.getRepId();
//    }
//
//    @Override
//    public CommentReport updateCommentReport(Integer repId, CommentReport CommentReport) {
//
//        return null;
//    }
//
//}
