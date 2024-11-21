package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/comments")
@Transactional
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    // write Command
/*
    http POST localhost:8080/comments
    user="value" commentContent="value"
    boardId="value"
    likeCount="value"
    badCount="value"
*/

    // delete Command
//    http DELETE localhost:8080/comments/1

    // update Command
/*
    http PUT localhost:8080/comments/1
    user="value"
    commentContent="value"
    boardId="value"
    likeCount="value"
    badCount="value"
 */
    @RequestMapping(
            value = "/comments/write",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    public Comment write(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody Comment comment
    ) throws Exception {
        System.out.println("##### /comment/write  called #####");
//        Comment comment = new Comment();
        comment.write();
        commentRepository.save(comment);
        return comment;
    }


    @RequestMapping(
            value = "/comments/{id}/update",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Comment update(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody UpdateCommand updateCommand
    ) throws Exception {
        System.out.println("##### /comment/update  called #####");
        Optional<Comment> optionalComment = commentRepository.findById(id);

        optionalComment.orElseThrow(() -> new Exception("No Entity Found"));
        Comment comment = optionalComment.get();
        comment.update(updateCommand);

        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(
            value = "/comments/{id}/likeco",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Comment likeCo(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /comment/likeCo  called #####");
        Optional<Comment> optionalComment = commentRepository.findById(id);

        optionalComment.orElseThrow(() -> new Exception("No Entity Found"));
        Comment comment = optionalComment.get();
        comment.likeCo();

        commentRepository.save(comment);
        return comment;
    }

    @RequestMapping(
            value = "/comments/{id}/badco",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Comment badCo(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /comment/badCo  called #####");
        Optional<Comment> optionalComment = commentRepository.findById(id);

        optionalComment.orElseThrow(() -> new Exception("No Entity Found"));
        Comment comment = optionalComment.get();
        comment.badCo();

        commentRepository.save(comment);
        return comment;
    }
}
//>>> Clean Arch / Inbound Adaptor
