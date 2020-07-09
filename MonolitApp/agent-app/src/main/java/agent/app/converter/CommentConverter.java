package agent.app.converter;


import agent.app.dto.comment.CommentCreateDTO;
import agent.app.dto.comment.CommentDTO;
import agent.app.model.Comment;

public class CommentConverter {

    public static Comment toCommentFromCommentCreateDTO(CommentCreateDTO commentCreateDTO){
        return Comment.builder()
                .content(commentCreateDTO.getContent())
                .creationDate(DateAPI.DateTimeNow())
                .approved(false)
                .build();
    }

    public static CommentDTO toCommentDTOFromComment(Comment comment){
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .creationDate(comment.getCreationDate().toString())
                .publisherUserId(comment.getPublisherUser().getId())
                .approved(comment.getApproved())
                .build();
    }

}
